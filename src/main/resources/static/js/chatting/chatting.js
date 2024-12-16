const addTarget = document.querySelector('#addTarget'); // 추가 버튼
const addTargetPopupLayer = document.querySelector('#addTargetPopupLayer'); // 팝업 레이어
const closeBtn = document.querySelector('#closeBtn'); // 닫기 버튼
const targetInput = document.querySelector('#targetInput'); // 사용자 검색
const resultArea = document.querySelector('#resultArea'); // 검색 결과

let selectChattingNo; // 선택한 채팅방 번호
let selectTargetNo; // 현재 채팅 대상
let selectTargetName; // 대상의 이름
let selectTargetProfile; // 대상의 프로필

let socket; // WebSocket 객체

// 검색 팝업 레이어 열기
addTarget.addEventListener('click', (e) => {
  addTargetPopupLayer.classList.toggle('popup-layer-close');
  targetInput.focus();
});

// 검색 팝업 레이어 닫기
closeBtn.addEventListener('click', (e) => {
  addTargetPopupLayer.classList.toggle('popup-layer-close');
  resultArea.innerHTML = '';
});

// 사용자 검색(ajax)
targetInput.addEventListener('input', (e) => {
  const query = e.target.value.trim();

  // 입력된 값이 없을 때
  if (query.length == 0) {
    resultArea.innerHTML = ''; // 이전 검색 결과 비우기
    return;
  }

  // 입력된 값이 있을 때
  if (query.length > 0) {
    fetch('/chatting/selectTarget?query=' + query)
      .then((resp) => resp.json())
      .then((list) => {
        resultArea.innerHTML = ''; // 이전 검색 결과 비우기

        if (list.length == 0) {
          const li = document.createElement('li');
          li.classList.add('result-row');
          li.innerText = '일치하는 회원이 없습니다';
          resultArea.append(li);
        }

        for (let member of list) {
          const li = document.createElement('li');
          li.classList.add('result-row');
          li.setAttribute('data-id', member.memberNo);

          const img = document.createElement('img');
          img.classList.add('result-row-img');
          img.setAttribute(
            'src',
            member.profileImage || '/resources/images/user.png'
          );

          let nickname = member.memberNickname;
          let email = member.memberEmail;

          const span = document.createElement('span');
          span.innerHTML = `${nickname} ${email}`.replace(
            query,
            `<mark>${query}</mark>`
          );

          li.append(img, span);
          resultArea.append(li);

          // li요소에 클릭 시 채팅방에 입장하는 이벤트 추가
          li.addEventListener('click', chattingEnter);
        }
      })
      .catch((err) => console.log(err));
  }
});

// 채팅방 입장 또는 선택 함수
function chattingEnter(e) {
  const targetNo = e.currentTarget.getAttribute('data-id');

  fetch('/chatting/enter?targetNo=' + targetNo)
    .then((resp) => resp.text())
    .then((chattingNo) => {
      selectRoomList(); // 채팅방 목록 조회

      setTimeout(() => {
        // 만약 채팅방 목록 중 이미 존재하는 채팅방이 있으면 클릭해서 입장
        const itemList = document.querySelectorAll('.chatting-item');
        for (let item of itemList) {
          if (item.getAttribute('chat-no') == chattingNo) {
            item.focus();
            item.click();
            addTargetPopupLayer.classList.toggle('popup-layer-close');
            targetInput.value = '';
            resultArea.innerHTML = '';
            return;
          }
        }
      }, 200);
    })
    .catch((err) => console.log(err));
}

// 비동기로 채팅방 목록 조회
function selectRoomList() {
  fetch('/chatting/roomList')
    .then((resp) => resp.json())
    .then((roomList) => {
      const chattingList = document.querySelector('.chatting-list');
      chattingList.innerHTML = ''; // 채팅방 목록 지우기

      for (let room of roomList) {
        const li = document.createElement('li');
        li.classList.add('chatting-item');
        li.setAttribute('chat-no', room.chattingNo);
        li.setAttribute('target-no', room.targetNo);

        if (room.chattingNo == selectChattingNo) {
          li.classList.add('select');
        }

        const itemHeader = document.createElement('div');
        itemHeader.classList.add('item-header');

        const listProfile = document.createElement('img');
        listProfile.classList.add('list-profile');
        listProfile.setAttribute(
          'src',
          room.targetProfile || '/resources/images/user.png'
        );
        itemHeader.append(listProfile);

        const itemBody = document.createElement('div');
        itemBody.classList.add('item-body');

        const p = document.createElement('p');
        const targetName = document.createElement('span');
        targetName.classList.add('target-name');
        targetName.innerText = room.targetNickName;

        const recentSendTime = document.createElement('span');
        recentSendTime.classList.add('recent-send-time');
        recentSendTime.innerText = room.sendTime;

        p.append(targetName, recentSendTime);

        const div = document.createElement('div');
        const recentMessage = document.createElement('p');
        recentMessage.classList.add('recent-message');
        if (room.lastMessage != undefined) {
          recentMessage.innerHTML = room.lastMessage;
        }

        div.append(recentMessage);
        itemBody.append(p, div);

        if (room.notReadCount > 0 && room.chattingNo != selectChattingNo) {
          const notReadCount = document.createElement('p');
          notReadCount.classList.add('not-read-count');
          notReadCount.innerText = room.notReadCount;
          div.append(notReadCount);
        }

        li.append(itemHeader, itemBody);
        chattingList.append(li);
      }

      roomListAddEvent();
    })
    .catch((err) => console.log(err));
}

// 채팅방 목록에 이벤트를 추가하는 함수
function roomListAddEvent() {
  const chattingItemList = document.getElementsByClassName('chatting-item');
  for (let item of chattingItemList) {
    item.addEventListener('click', (e) => {
      selectChattingNo = item.getAttribute('chat-no');
      selectTargetNo = item.getAttribute('target-no');
      selectTargetProfile = item.children[0].children[0].getAttribute('src');
      selectTargetName = item.children[1].children[0].children[0].innerText;

      if (item.children[1].children[1].children[1] != undefined) {
        item.children[1].children[1].children[1].remove();
      }

      for (let it of chattingItemList) it.classList.remove('select');

      item.classList.add('select');
      selectChattingFn();
    });
  }
}

// 비동기로 메시지 목록을 조회하는 함수
function selectChattingFn() {
  fetch(
    '/chatting/selectMessage?chattingNo=' +
      selectChattingNo +
      '&memberNo=' +
      loginMemberNo
  )
    .then((resp) => resp.json())
    .then((messageList) => {
      const ul = document.querySelector('.display-chatting');
      ul.innerHTML = '';

      for (let msg of messageList) {
        const li = document.createElement('li');
        const span = document.createElement('span');
        span.classList.add('chatDate');
        span.innerText = msg.sendTime;

        const p = document.createElement('p');
        p.classList.add('chat');
        p.innerHTML = msg.messageContent;

        if (loginMemberNo == msg.senderNo) {
          li.classList.add('my-chat');
          li.append(span, p);
        } else {
          li.classList.add('target-chat');

          const img = document.createElement('img');
          img.setAttribute('src', selectTargetProfile);

          const div = document.createElement('div');
          const b = document.createElement('b');
          b.innerText = selectTargetName;

          const br = document.createElement('br');
          div.append(b, br, p, span);
          li.append(img, div);
        }

        ul.append(li);
        display.scrollTop = display.scrollHeight;
      }
    })
    .catch((err) => console.log(err));
}

// WebSocket 설정
function connectWebSocket() {
  socket = new WebSocket('/chattingSock/' + selectChattingNo); // WebSocket 연결

  socket.onopen = () => {
    console.log('WebSocket 연결 성공');
  };

  socket.onmessage = (event) => {
    const message = JSON.parse(event.data);

    if (message.chattingNo == selectChattingNo) {
      selectChattingFn(); // 메시지 수신 시 다시 메시지 목록을 조회하여 화면에 업데이트
    }
  };

  socket.onclose = () => {
    console.log('WebSocket 연결 종료');
  };

  socket.onerror = (error) => {
    console.log('WebSocket 오류:', error);
  };
}

// 채팅방 목록 클릭 시 WebSocket 연결
function selectChattingFn() {
  if (socket && socket.readyState === WebSocket.OPEN) {
    socket.send(
      JSON.stringify({ chattingNo: selectChattingNo, memberNo: loginMemberNo })
    );
  } else {
    connectWebSocket();
  }
}
