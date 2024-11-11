$().ready(function () {
  const $picModalArea = $("#picModalArea");
  const $btnOpenPicModal = $(".btn-open-pic-modal");
  const $btnClosePicModal = $(".btn-close-pic-modal");

  const $reviewModal = $("#reviewModalArea");
  const $btnOpenReviewModal = $(".btn-open-review-modal");
  const $btnCloseReviewModal = $(".btn-close-review-modal");
  const $btnSubmitReview = $(".btn-submit-review");

  const $reviewListModal = $("#viewAllReviewModal");
  const $btnOpenReviewListModal = $(".btn-open-review-list-modal");
  const $btnCloseReviewListModal = $(".btn-close-review-list-modal");

  function init() {
    // 페이지 로드 시 모달을 닫음
    $reviewModal[0].close();
    $picModalArea[0].close();
    $reviewListModal[0].close();

    // 리뷰 모달 열기 버튼 클릭
    $btnOpenReviewModal.on("click", function () {
      console.log("사진 Modal 열기 버튼 클릭됨.");
      $reviewModal.removeClass("hidden");
      // $('#modalArea').fadeIn();
      // $("body").css("overflow", "hidden");
      $reviewModal[0].showModal();
    });

    // 리뷰 모달 닫기 버튼 클릭
    $btnCloseReviewModal.on("click", function () {
      console.log("사진 Modal 닫기 버튼 클릭됨.");
      $reviewModal.addClass("hidden");
      // $('#modalArea').fadeOut();
      // $("body").css("overflow", "auto");
      $reviewModal[0].close();
    });

    // 리뷰 등록 버튼 클릭
    $btnSubmitReview.on("click", function () {
      console.log("리뷰 등록 버튼 클릭됨.");
      $reviewModal.addClass("hidden");
      // $('#modalArea').fadeOut();
      // $("body").css("overflow", "auto");
      alert("리뷰 작성이 완료되었습니다.");
      $reviewModal[0].close();
    });

    // 사진 모달 열기 버튼 클릭
    $btnOpenPicModal.on("click", function () {
      console.log("사진 Modal 열기 버튼 클릭됨.");
      $picModalArea.removeClass("hidden");
      // $('#modalArea').fadeIn();
      // $("body").css("overflow", "hidden");
      $picModalArea[0].showModal();
    });

    // 사진 모달 닫기 버튼 클릭
    $btnClosePicModal.on("click", function () {
      console.log("사진 Modal 닫기 버튼 클릭됨.");
      $picModalArea.addClass("hidden");
      // $('#modalArea').fadeOut();
      // $("body").css("overflow", "auto");
      $picModalArea[0].close();
    });

    // 리뷰 리스트 모달 열기 버튼 클릭
    $btnOpenReviewListModal.on("click", function () {
      console.log("사진 Modal 열기 버튼 클릭됨.");
      $reviewListModal.removeClass("hidden");
      // $('#modalArea').fadeIn();
      // $("body").css("overflow", "hidden");
      $reviewListModal[0].showModal();
    });

    // 리뷰 리스트 모달 닫기 버튼 클릭
    $btnCloseReviewListModal.on("click", function () {
      console.log("사진 Modal 닫기 버튼 클릭됨.");
      $reviewListModal.addClass("hidden");
      // $('#modalArea').fadeOut();
      // $("body").css("overflow", "auto");
      $reviewListModal[0].close();
    });
  }

  // 별점 클릭 이벤트
  $(".starRating > .starThree").click(function () {
    // 'on' 클래스를 초기화하고, 클릭한 요소와 그 이전 요소에 'on' 클래스를 추가
    $(this).parent().children(".starThree").removeClass("on"); // span이 아니라 .star 클래스 선택
    $(this).addClass("on").prevAll(".starThree").addClass("on"); // span 대신 .star 사용
	var starCnt = $(".on").length;
	console.log(starCnt);
	$("#starCnt").val(starCnt);

  });

  // 초기화 함수 호출
  init();
});