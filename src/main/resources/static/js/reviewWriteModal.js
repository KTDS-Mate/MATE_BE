$().ready(function () {
  const $modal = $("#modalArea");
  const $btnOpenModal = $(".btn-open-modal");
  const $btnCloseModal = $(".btn-close-modal");

  function init() {
    // 모달 열기 버튼 클릭
    $btnOpenModal.on("click", function () {
      console.log("Modal 열기 버튼 클릭됨.");
      $modal.removeClass("hidden");
      // $('#modalArea').fadeIn();
      // $("body").css("overflow", "hidden");
      $modal[0].showModal();
    });

    // 모달 닫기 버튼 클릭
    $btnCloseModal.on("click", function () {
      console.log("Modal 닫기 버튼 클릭됨.");
      $modal.addClass("hidden");
      // $('#modalArea').fadeOut();
      // $("body").css("overflow", "auto");
      alert("리뷰 작성이 완료되었습니다.");
      $modal[0].close();
    });
  }

  // 별점 클릭 이벤트
  $(".starRating > .star").click(function () {
    // 'on' 클래스를 초기화하고, 클릭한 요소와 그 이전 요소에 'on' 클래스를 추가
    $(this).parent().children(".star").removeClass("on"); // span이 아니라 .star 클래스 선택
    $(this).addClass("on").prevAll(".star").addClass("on"); // span 대신 .star 사용
  });

  // 초기화 함수 호출
  init();
});
