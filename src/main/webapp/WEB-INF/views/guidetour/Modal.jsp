<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="stylesheet" type="text/css" href="/css/guidetour/Modal.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/Modal.js"></script>
  </head>
  <body>
    <dialog id="reviewModalArea" class="reviewWriteModal hidden">
      <div class="closeButtonArea">
        <img
          src="/public/close.png"
          alt="닫기 버튼"
          class="closeButton btn-close-review-modal"
        />
      </div>
      <div class="reviewWritingArea">
        <form:form modelAttribute="guideTourReviewWriteVO" method="post">
        <input id="" type="hidden" data-gd-pst-id="${guideTourVO.gdTrPstId}" />
        <input id="starCnt" name="gdTrRvwRtng" type="hidden" value="1" />
          <h2>리뷰 작성</h2>
          <div class="starRating">
            <span class="starThree on" value="1"></span>
            <span class="starThree" value="2"></span>
            <span class="starThree" value="3"></span>
            <span class="starThree" value="4"></span>
            <span class="starThree" value="5"></span>
          </div>
          <textarea
            name="gdTrRvwCntnt"
            class="starBox"
            placeholder="리뷰 내용을 작성해주세요."
          >${GuideTourReviewVO.gdTrRvwCntnt}</textarea>
          <input
            type="submit"
            class="reviewSubmitButton btn-submit-review"
            value="리뷰 등록"
          />
        </form:form>
      </div>
    </dialog>
    <dialog id="picModalArea" class="picModal hidden">
      <div class="picCloseButtonArea">
        <img
          src="/public/close.png"
          alt="닫기 버튼"
          class="picCloseButton btn-close-pic-modal"
        />
      </div>
      <div class="picArea">
        
      </div>
    </dialog>
    <dialog id="morepicModalArea" class="more-picModal hidden">
      <div class="morePicCloseButtonArea">
        <img
          src="/public/close.png"
          alt="닫기 버튼"
          class="pic-more-CloseButton btn-close-more-pic-modal"
        />
      </div>
      <div class="more-picArea">
        
      </div>
    </dialog>
    <dialog id="viewAllReviewModal" class="viewAllReviewModal hidden">
      <div class="closeReviewListButtonArea">
        <h2>후기</h2>
        <img
          src="/public/close.png"
          alt="닫기 버튼"
          class="closeButton btn-close-review-list-modal"
        />
      </div>
      <div class="allReviewArea">
        <div class="reviewListArea">
          <div class="oneReview">
            <div class="oneReviewRating">
              <img src="/public/Star.png" alt="별점 아이콘" class="modal-star" />
              <span class="oneReviewRatingCount">5</span>
              <span class="reviewerNameArea">Gil-Dong Hong</span>
            </div>
            <div class="reviewerAllPicArea">
              <div class="reviewerPicturesAreas">
                <div class="reviewerPicArea">
                  <img
                    src="/public/일본.jpg"
                    alt="리뷰 모달 사진"
                    class="reviewerPicture"
                  />
                </div>
              </div>
            </div>
            <div class="oneReviewTextArea">
              <span>
                Lorem Ipsum is simply dummy text of the printing and typesetting
                industry. Lorem Ipsum has been the industry's standard dummy
                text ever since the 1500s, when an unknown printer took a galley
                of type and scrambled it to make a type specimen book. It has
                survived not only five centuries, but also the leap into
                electronic typesetting, remaining essentially unchanged. It was
                popularised in the 1960s with the release of Letraset sheets
                containing Lorem Ipsum passages, and more recently with desktop
                publishing software like Aldus PageMaker including versions of
                Lorem Ipsum.
              </span>
            </div>
          </div>
        </div>
      </div>
    </dialog>
  </body>
</html>
