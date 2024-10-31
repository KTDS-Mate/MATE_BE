$(document).ready(function () {
  const $carouselList = $(".guideReviewCarousel");
  const width = $(".guideReviewOneArea").outerWidth(true) * 1; // true를 사용하여 마진 포함 너비 가져오기
  // 수정 필요
  const carouselItemCount = $(".guideReviewOneArea").length + 2;

  const $forwardButton = $(".guideReviewForwardButton");
  const $backwardButton = $(".guideReviewBackwardButton");

  let currentTranslateX = 0;
  let isDragging = false;
  let startPos = 0;
  let currentPos = 0;
  const moveGap = 22; // 스냅 전환에 필요한 최소 이동 거리

  // transition 클래스 추가 함수
  const addTransition = () =>
    $carouselList.addClass("reviewCarouselTransition");
  // transition 클래스 제거 함수
  const removeTransition = () =>
    $carouselList.removeClass("reviewCarouselTransition");

  // 캐러셀 위치 업데이트 함수
  const updateCarouselPosition = (position) => {
    $carouselList.css("transform", `translateX(${position}px)`);
  };

  // 버튼 상태 업데이트 함수
  const updateButtonState = () => {
    // 마지막 아이템 위치일 경우 forward 버튼 비활성화
    $forwardButton.prop(
      "disabled",
      currentTranslateX <= -width * (carouselItemCount - 1)
    );
    // 첫 번째 아이템 위치일 경우 backward 버튼 비활성화
    $backwardButton.prop("disabled", currentTranslateX >= 0);
  };

  // 드래그 시작 이벤트
  const dragStart = (clientX) => {
    isDragging = true;
    startPos = clientX;
    currentPos = currentTranslateX;
    removeTransition();
  };

  // 드래그 중 이벤트
  const dragMove = (clientX) => {
    if (isDragging) {
      let dragAmount = clientX - startPos;
      let newTranslateX = currentPos + dragAmount;

      // 경계 설정
      if (newTranslateX < -width * (carouselItemCount - 1)) {
        newTranslateX = -width * (carouselItemCount - 1);
      } else if (newTranslateX > 0) {
        newTranslateX = 0;
      }

      updateCarouselPosition(newTranslateX);
    }
  };

  // 드래그 종료 이벤트
  const dragEnd = () => {
    if (isDragging) {
      isDragging = false;
      addTransition();

      // 이동 거리 조정
      const draggedDistance = currentPos - currentTranslateX;
      if (Math.abs(draggedDistance) > moveGap) {
        currentTranslateX = Math.round(currentTranslateX / width) * width;
      }

      updateCarouselPosition(currentTranslateX);
      updateButtonState(); // 버튼 상태 업데이트
    }
  };

  // 버튼 클릭 이벤트
  $backwardButton.on("click", () => {
    if (currentTranslateX > -width * (carouselItemCount - 2)) {
      addTransition();
      currentTranslateX -= width;
      updateCarouselPosition(currentTranslateX);
      updateButtonState(); // 버튼 상태 업데이트
      // Carousel 위치 업데이트
      updateCarouselPosition();

      // 버튼 상태 업데이트
      updateButtonState();
    }
  });

  $forwardButton.on("click", () => {
    if (currentTranslateX < 0) {
      addTransition();
      currentTranslateX += width;
      updateCarouselPosition(currentTranslateX);
      updateButtonState(); // 버튼 상태 업데이트
      // Carousel 위치 업데이트
      updateCarouselPosition();

      // 버튼 상태 업데이트
      updateButtonState();
    }
  });

  // 드래그 이벤트 설정
  $carouselList.on("mousedown", (e) => dragStart(e.clientX));
  $(window).on("mousemove", (e) => isDragging && dragMove(e.clientX));
  $(window).on("mouseup", dragEnd);

  $carouselList.on("touchstart", (e) => dragStart(e.touches[0].clientX));
  $(window).on(
    "touchmove",
    (e) => isDragging && dragMove(e.touches[0].clientX)
  );
  $(window).on("touchend", dragEnd);

  updateButtonState(); // 초기 버튼 상태 설정
});
