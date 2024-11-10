$().ready(function () {
  const $phoneNumEditModal = $("#phoneNumEditModal");
  const $btnOpenPhoneNumEditModal = $(".btn-open-phoneNumEdit-modal");
  const $btnClosePhoneNumEditModal = $(".btn-close-phoneNumEdit-modal");

  const $pwEditModal = $("#pwEditModal");
  const $btnOpenPwEditModal = $(".btn-open-pwEdit-modal");
  const $btnClosePwEditModal = $(".btn-close-pwEdit-modal");

  const $pypEditModal = $("#pypEditModal");
  const $btnOpenPypEditModal = $(".btn-open-pypEdit-modal");
  const $btnClosePypEditModal = $(".btn-close-pypEdit-modal");

  const $profilePhotoEditModal = $("#profilePhotoEditModal");
  const $btnOpenProfilePhotoEditModal = $(".btn-open-profilePhotoEdit-modal");
  const $btnCloseProfilePhotoEditModal = $(".btn-close-profilePhotoEdit-modal");

  const $certificateEditModal = $("#certificateEditModal");
  const $btnOpenCertificateEditModal = $(".btn-open-certificateEdit-modal");
  const $btnCloseCertificateEditModal = $(".btn-close-certificateEdit-modal");

  const $crimeEditModal = $("#crimeEditModal");
  const $btnOpenCrimeEditModal = $(".btn-open-crimeEdit-modal");
  const $btnCloseCrimeEditModal = $(".btn-close-crimeEdit-modal");

  const $locationEditModal = $("#locationEditModal");
  const $btnOpenLocationEditModal = $(".btn-open-locationEdit-modal");
  const $btnCloseLocationEditModal = $(".btn-close-locationEdit-modal");

  const $idEditModal = $("#idEditModal");
  const $btnOpenIdEditModal = $(".btn-open-idEdit-modal");
  const $btnCloseIdEditModal = $(".btn-close-idEdit-modal");

  function init() {
    // 페이지 로드 시 모달을 닫음
    $phoneNumEditModal[0].close();
    $pwEditModal[0].close();
    $pypEditModal[0].close();
    $profilePhotoEditModal[0].close();
    $certificateEditModal[0].close();
    $crimeEditModal[0].close();
    $locationEditModal[0].close();
    $idEditModal[0].close();

    // 전화 번호 수정 모달 열기 버튼 클릭
    $btnOpenPhoneNumEditModal.on("click", function () {
      console.log("전화번호 수정 Modal 열기 버튼 클릭됨.");
      $phoneNumEditModal.removeClass("hidden");
      $phoneNumEditModal[0].showModal();
    });

    // 전화 번호 수정 모달 닫기 버튼 클릭
    $btnClosePhoneNumEditModal.on("click", function () {
      console.log("전화번호 수정 Modal 닫기 버튼 클릭됨.");
      $phoneNumEditModal.addClass("hidden");
      $phoneNumEditModal[0].close();
    });

    // 전화 번호 수정 모달 외부 클릭 시 모달 닫기
    $phoneNumEditModal.on("click", function () {
      if (event.target === $phoneNumEditModal[0]) {
        console.log("전화번호 수정 Modal 외부 영역 클릭됨.");
        $phoneNumEditModal.addClass("hidden");
        $phoneNumEditModal[0].close();
      }
    });

    // 비밀번호 수정 모달 열기 버튼 클릭
    $btnOpenPwEditModal.on("click", function () {
      console.log("비밀번호 수정 Modal 열기 버튼 클릭됨.");
      $pwEditModal.removeClass("hidden");
      $pwEditModal[0].showModal();
    });

    // 비밀번호 수정 모달 닫기 버튼 클릭
    $btnClosePwEditModal.on("click", function () {
      console.log("비밀번호 수정 Modal 닫기 버튼 클릭됨.");
      $pwEditModal.addClass("hidden");
      $pwEditModal[0].close();
    });

    // 비밀번호 수정 모달 외부 클릭 시 모달 닫기
    $pwEditModal.on("click", function () {
      if (event.target === $pwEditModal[0]) {
        console.log("비밀번호 수정 Modal 외부 영역 클릭됨.");
        $pwEditModal.addClass("hidden");
        $pwEditModal[0].close();
      }
    });

    // 결제계좌 수정 모달 열기 버튼 클릭
    $btnOpenPypEditModal.on("click", function () {
      console.log("결제계좌 수정 Modal 열기 버튼 클릭됨.");
      $pypEditModal.removeClass("hidden");
      $pypEditModal[0].showModal();
    });

    // 결제계좌 수정 모달 닫기 버튼 클릭
    $btnClosePypEditModal.on("click", function () {
      console.log("결제계좌 수정 Modal 닫기 버튼 클릭됨.");
      $pypEditModal.addClass("hidden");
      $pypEditModal[0].close();
    });

    // 결제계좌 수정 모달 외부 클릭 시 모달 닫기
    $pypEditModal.on("click", function () {
      if (event.target === $pypEditModal[0]) {
        console.log("결제계좌 수정 Modal 외부 영역 클릭됨.");
        $pypEditModal.addClass("hidden");
        $pypEditModal[0].close();
      }
    });

    // 프로필 사진 수정 모달 열기 버튼 클릭
    $btnOpenProfilePhotoEditModal.on("click", function () {
      console.log("프로필 사진 수정 Modal 열기 버튼 클릭됨.");
      $profilePhotoEditModal.removeClass("hidden");
      $profilePhotoEditModal[0].showModal();
    });

    // 프로필 사진 수정 모달 닫기 버튼 클릭
    $btnCloseProfilePhotoEditModal.on("click", function () {
      console.log("프로필 사진 수정 Modal 닫기 버튼 클릭됨.");
      $profilePhotoEditModal.addClass("hidden");
      $profilePhotoEditModal[0].close();
    });

    // 프로필 사진 수정 모달 외부 클릭 시 모달 닫기
    $profilePhotoEditModal.on("click", function () {
      if (event.target === $profilePhotoEditModal[0]) {
        console.log("프로필 사진 수정 Modal 외부 영역 클릭됨.");
        $profilePhotoEditModal.addClass("hidden");
        $profilePhotoEditModal[0].close();
      }
    });

    // 자격증 수정 모달 열기 버튼 클릭
    $btnOpenCertificateEditModal.on("click", function () {
      console.log("자격증 수정 Modal 열기 버튼 클릭됨.");
      $certificateEditModal.removeClass("hidden");
      $certificateEditModal[0].showModal();
    });

    // 자격증 수정 모달 닫기 버튼 클릭
    $btnCloseCertificateEditModal.on("click", function () {
      console.log("자격증 수정 Modal 닫기 버튼 클릭됨.");
      $certificateEditModal.addClass("hidden");
      $certificateEditModal[0].close();
    });

    // 자격증 수정 모달 외부 클릭 시 모달 닫기
    $certificateEditModal.on("click", function () {
      if (event.target === $certificateEditModal[0]) {
        console.log("자격증 수정 Modal 외부 영역 클릭됨.");
        $certificateEditModal.addClass("hidden");
        $certificateEditModal[0].close();
      }
    });

    // 범죄내역이력서 수정 모달 열기 버튼 클릭
    $btnOpenCrimeEditModal.on("click", function () {
      console.log("범죄내역이력서 수정 Modal 열기 버튼 클릭됨.");
      $crimeEditModal.removeClass("hidden");
      $crimeEditModal[0].showModal();
    });

    // 범죄내역이력서 수정 모달 닫기 버튼 클릭
    $btnCloseCrimeEditModal.on("click", function () {
      console.log("범죄내역이력서 수정 Modal 닫기 버튼 클릭됨.");
      $crimeEditModal.addClass("hidden");
      $crimeEditModal[0].close();
    });

    // 범죄내역이력서 수정 모달 외부 클릭 시 모달 닫기
    $crimeEditModal.on("click", function () {
      if (event.target === $crimeEditModal[0]) {
        console.log("범죄내역이력서 수정 Modal 외부 영역 클릭됨.");
        $crimeEditModal.addClass("hidden");
        $crimeEditModal[0].close();
      }
    });

    // 활동 도시 수정 모달 열기 버튼 클릭
    $btnOpenLocationEditModal.on("click", function () {
      console.log("활동 도시 수정 Modal 열기 버튼 클릭됨.");
      $locationEditModal.removeClass("hidden");
      $locationEditModal[0].showModal();
    });

    // 활동 도시 수정 모달 닫기 버튼 클릭
    $btnCloseLocationEditModal.on("click", function () {
      console.log("활동 도시 수정 Modal 닫기 버튼 클릭됨.");
      $locationEditModal.addClass("hidden");
      $locationEditModal[0].close();
    });

    // 활동 도시 수정 모달 외부 클릭 시 모달 닫기
    $locationEditModal.on("click", function () {
      if (event.target === $locationEditModal[0]) {
        console.log("활동 도시 수정 Modal 외부 영역 클릭됨.");
        $locationEditModal.addClass("hidden");
        $locationEditModal[0].close();
      }
    });

    // 신분증 수정 모달 열기 버튼 클릭
    $btnOpenIdEditModal.on("click", function () {
      console.log("신분증 수정 Modal 열기 버튼 클릭됨.");
      $idEditModal.removeClass("hidden");
      $idEditModal[0].showModal();
    });

    // 신분증 수정 모달 닫기 버튼 클릭
    $btnCloseIdEditModal.on("click", function () {
      console.log("신분증 수정 Modal 닫기 버튼 클릭됨.");
      $idEditModal.addClass("hidden");
      $idEditModal[0].close();
    });

    // 신분증 수정 모달 외부 클릭 시 모달 닫기
    $idEditModal.on("click", function () {
      if (event.target === $idEditModal[0]) {
        console.log("신분증 수정 Modal 외부 영역 클릭됨.");
        $idEditModal.addClass("hidden");
        $idEditModal[0].close();
      }
    });
  }

  // 초기화 함수 호출
  init();
});
