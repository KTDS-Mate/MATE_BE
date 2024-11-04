$().ready(function () {
  const $when = $(".when");
  const $calendarModal = $("#calendarModal");
  const $nowMonth = $(".nowMonth");
  const $selectDate = $(".selectDate");
  let currentDate = new Date();

  // 현재 날짜를 yy.MM.dd 형식으로 포맷팅하여 h3에 설정
  function setCurrentDate() {
    const currentYear = currentDate.getFullYear();
    const currentMonth = currentDate.getMonth() + 1; // 월은 0부터 시작하므로 1을 더함
    const currentDay = currentDate.getDate();

    // 날짜 형식 yy.MM.dd로 포맷팅
    const formattedDate = `${String(currentYear).slice(-2)}.${String(
      currentMonth
    ).padStart(2, "0")}.${String(currentDay).padStart(2, "0")}`;

    // .whenSelectArea > h3의 초기 값을 현재 날짜로 설정
    $(".whenSelectArea > h3").text(formattedDate);
  }

  // 달력을 생성하는 함수
  function generateCalendar() {
    $selectDate.empty(); // 이전 날짜를 모두 지움
    const month = currentDate.getMonth(); // 현재 월 (0 ~ 11)
    const year = currentDate.getFullYear(); // 현재 연도

    // 해당 월의 첫째 날과 마지막 날짜 계산
    const firstDay = new Date(year, month, 1).getDay();
    const lastDate = new Date(year, month + 1, 0).getDate();

    // 현재 월 및 연도 표시
    $nowMonth.text(
      `${currentDate.toLocaleString("default", { month: "long" })} ${year}`
    );

    // 첫째 날 전까지 빈 칸 추가
    for (let i = 0; i < firstDay; i++) {
      $selectDate.append('<div class="dateItem empty"></div>');
    }

    // 날짜 추가
    for (let day = 1; day <= lastDate; day++) {
      $selectDate.append(`<div class="dateItem">${day}</div>`);
    }
  }

  // 모달 열기 함수
  function openCalendarModal() {
    $calendarModal.removeClass("hidden");
    generateCalendar();
  }

  // 모달 닫기 함수
  function closeCalendarModal() {
    $calendarModal.addClass("hidden");
  }

  // 날짜 선택 이벤트
  $selectDate.on("click", ".dateItem", function () {
    if (!$(this).hasClass("empty")) {
      $(".dateItem").removeClass("selected");
      $(this).addClass("selected");
      const selectedDay = $(this).text(); // 선택한 일
      const selectedMonth = currentDate.getMonth() + 1; // 월은 0부터 시작하므로 1을 더함
      const selectedYear = currentDate.getFullYear(); // 연도

      // 날짜 형식 yy.MM.dd로 포맷팅
      const formattedDate = `${String(selectedYear).slice(-2)}.${String(
        selectedMonth
      ).padStart(2, "0")}.${String(selectedDay).padStart(2, "0")}`;

      // .whenSelectArea > h3의 값을 선택한 날짜로 변경
      $(".whenSelectArea > h3").text(formattedDate);

      console.log("선택된 날짜:", formattedDate); // 선택된 날짜를 콘솔에 표시
      closeCalendarModal(); // 모달 닫기
    }
  });

  // 이전 달 이동
  $(".prevMonth").on("click", function () {
    currentDate.setMonth(currentDate.getMonth() - 1); // 월을 이전으로 변경
    generateCalendar();
  });

  // 다음 달 이동
  $(".nextMonth").on("click", function () {
    currentDate.setMonth(currentDate.getMonth() + 1); // 월을 다음으로 변경
    generateCalendar();
  });

  // 모달 열기 버튼
  $when.on("click", function (e) {
    e.stopPropagation(); // 이벤트 버블링 중지
    openCalendarModal();
  });

  $calendarModal.on("click", function (e) {
    e.stopPropagation(); // 모달 내부 클릭 시 닫히지 않도록 방지
  });

  // 이미지 전환 버튼 클릭 시 모달 닫히지 않도록 이벤트 추가
  $(".picForwardButton, .picBackwardButton").on("click", function (e) {
    e.stopPropagation(); // 이벤트 전파 중지
  });

  $(document).on("click", function (e) {
    if (
      !$calendarModal.is(e.target) &&
      $calendarModal.has(e.target).length === 0
    ) {
      closeCalendarModal();
    }
  });

  // 페이지가 로딩될 때 현재 날짜를 설정
  setCurrentDate(); // 초기 설정 호출
});
