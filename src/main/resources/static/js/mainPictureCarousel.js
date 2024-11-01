$(document).ready(function () {
  const $carouselList = $(".mainPictureCarousel");
  const width = $(".picArea").outerWidth(true) * 1;
  const carouselItemCount = $(".picArea").length;

  const $forwardButton = $(".picForwardButton");
  const $backwardButton = $(".picBackwardButton");

  let currentTranslateX = 0; // 첫 번째 아이템 위치로 초기화
  let isDragging = false;
  let startPos = 0;
  let currentPos = 0;
  const moveGap = 22;

  const addTransition = () =>
    $carouselList.addClass("mainPictureCarouselTransition");
  const removeTransition = () =>
    $carouselList.removeClass("mainPictureCarouselTransition");

  const updateCarouselPosition = (position) => {
    $carouselList.css("transform", `translateX(${position}px)`);
  };

  // updateButtonState 함수에서 초기 위치를 변경하지 않도록 수정
  const updateButtonState = () => {
    // 버튼 상태 업데이트만 담당하고 위치는 변경하지 않음
    if (currentTranslateX <= -width * (carouselItemCount - 1)) {
      currentTranslateX = -width * (carouselItemCount - 1);
    } else if (currentTranslateX >= 0) {
      currentTranslateX = 0;
    }
  };

  updateCarouselPosition(currentTranslateX); // 초기 위치로 캐러셀 설정

  const dragStart = (clientX) => {
    isDragging = true;
    startPos = clientX;
    currentPos = currentTranslateX;
    removeTransition();
  };

  const dragMove = (clientX) => {
    if (isDragging) {
      let dragAmount = clientX - startPos;
      let newTranslateX = currentPos + dragAmount;

      if (newTranslateX < -width * (carouselItemCount - 1)) {
        newTranslateX = -width * (carouselItemCount - 1);
      } else if (newTranslateX > 0) {
        newTranslateX = 0;
      }

      updateCarouselPosition(newTranslateX);
    }
  };

  const dragEnd = () => {
    if (isDragging) {
      isDragging = false;
      addTransition();

      const draggedDistance = currentPos - currentTranslateX;
      if (Math.abs(draggedDistance) > moveGap) {
        currentTranslateX = Math.round(currentTranslateX / width) * width;
      }

      updateCarouselPosition(currentTranslateX);
    }
  };

  $backwardButton.on("click", () => {
    if (currentTranslateX > -width * (carouselItemCount - 1)) {
      addTransition();
      currentTranslateX -= width;
    } else {
      currentTranslateX = 0;
    }
    updateCarouselPosition(currentTranslateX);
  });

  $forwardButton.on("click", () => {
    if (currentTranslateX < 0) {
      addTransition();
      currentTranslateX += width;
    } else {
      currentTranslateX = -width * (carouselItemCount - 1);
    }
    updateCarouselPosition(currentTranslateX);
  });

  // 5초마다 자동으로 다음 이미지로 이동
  setInterval(() => {
    $backwardButton.trigger("click");
  }, 5000);

  $carouselList.on("mousedown", (e) => dragStart(e.clientX));
  $(window).on("mousemove", (e) => isDragging && dragMove(e.clientX));
  $(window).on("mouseup", dragEnd);

  $carouselList.on("touchstart", (e) => dragStart(e.touches[0].clientX));
  $(window).on(
    "touchmove",
    (e) => isDragging && dragMove(e.touches[0].clientX)
  );
  $(window).on("touchend", dragEnd);

  updateCarouselPosition(currentTranslateX); // 초기 위치 설정
});
