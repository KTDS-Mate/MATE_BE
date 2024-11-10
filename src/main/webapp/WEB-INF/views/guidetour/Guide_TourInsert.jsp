<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>가이드 투어 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/guidetour/Guide_TourInsert.css"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script
      type="text/javascript"
      src="/js/guidetour/guidetourinsert.js"
    ></script>
    <script src="//rawgithub.com/indrimuska/jquery-editable-select/master/dist/jquery-editable-select.min.js"></script>
    <link
      href="//rawgithub.com/indrimuska/jquery-editable-select/master/dist/jquery-editable-select.min.css"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <form:form modelAttribute="guideTourWriteVO" method="post">
          <div class="insert-main">
            <div class="flex-main-img">
              <div>
                <h1>투어 프로그램 작성</h1>
              </div>
              <img alt="메인 이미지" src="/img/tourboard/예시여행이미지.png" />
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 투어 제목</div>
              <form:errors path="gdTrTtl" element="div" cssClass="errors" />
              <input
                id="usrTrTtl"
                name="gdTrTtl"
                type="text"
                placeholder="제목을 입력해주세요."
                value="${guideTourWriteVO.gdTrTtl}"
              />
            </div>
            <div class="all-select-div">
              <div class="select-div">
                <span class="red">*</span> 투어 지역 선택
              </div>
              <select id="region">
                <option value="" >대륙 선택</option>
              </select>
              <select id="country" disabled>
                <option value="">국가 선택</option>
              </select>
              <select id="city" name="trCtId" disabled>
                <option value="">도시 선택</option>
              </select>
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 날짜 선택</div>
              <input
                id="inputYear"
                name="inputYear"
                type="date"
                data-placeholder="투어 날짜를 골라주세요."
                value="${guideTourWriteVO.inputYear}"
              />
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 시간 선택</div>
              <div class="flex-hour-div">
                <div class="flex-hour">
                  <div class="time-select">
                    <input
                      id="start-minutes"
                      type="time"
                      name="inputStartHour"
                      disabled="disabled"
                    />
                  </div>
                  <div class="inline-margin">
                    <img src="/img/tourboard/~.png" />
                  </div>
                  <div class="time-select">
                    <input
                      id="end-minutes"
                      type="time"
                      name="inputEndHour"
                      disabled="disabled"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                <span class="red">*</span> 최대 인원 선택
              </div>
              <form:errors path="gdTrMxNp" element="div" cssClass="errors" />
              <div class="person-flex-div">
                <input
                  id="maxNp"
                  type="number"
                  name="gdTrMxNp"
                  value="${guideTourWriteVO.gdTrMxNp}"
                />
                <div>명</div>
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 투어 목적</div>
              <form:errors path="gdTrPrps" element="div" cssClass="errors" />
              <textarea name="gdTrPrps">${guideTourWriteVO.gdTrPrps}</textarea>
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 투어 요약</div>
              <form:errors path="gdTrSmry" element="div" cssClass="errors" />
              <textarea name="gdTrSmry">${guideTourWriteVO.gdTrSmry}</textarea>
            </div>
            <div class="all-select-div">
              <div class="select-div">
              <span class="red">*</span>
                투어 세부 일정<span class="font-we"
                  >원하는 일정을 추가해주세요.</span
                >
              </div>
              <div class="loc-inf">
                <!-- jquery를 사용해 여러 개를 호출 받는 곳 -->
              </div>
              <div class="hope-btn">
                <input id="plus" type="button" value="장소/일정 추가하기" />
                <input id="m-btn" type="button" value="장소/일정 삭제하기" />
              </div>
            </div>
            <div class="all-select-div">
            	<div>
                <div class="select-div">투어 추가 정보</div>
             <div class="plus-inf">
                <!-- jquery를 사용해 여러 개를 호출 받는 곳 -->
             </div>
              	<div class="hope-btn">
                	<input id="info-plus" type="button" value="투어 정보 추가하기" />
                	<input id="info-m-btn" type="button" value="투어 정보 삭제하기" />
              	</div>
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                <span class="red">*</span> 투어 제공 요소
              </div>
              <div class="incl-div">
              	<!-- jquery를 사용해 여러 개를 호출 받는 곳 -->
              </div>
              <div class="hope-btn">
                	<input id="incl-plus" type="button" value="투어 정보 추가하기" />
                	<input id="incl-m-btn" type="button" value="투어 정보 삭제하기" />
              </div>
            </div>
            <div class="all-select-div">
              <div class="inline">
                <div class="select-div">투어 이미지 추가</div>
                <input type="file" multiple="multiple" />
                <div class="file-list"></div>
              </div>
              <div class="inline margin-left-location">
                <div class="select-div">
                  <span class="red">*</span> 집결 장소 선택
                </div>
                <a><span class="red-font">Open In Google Map</span></a>
              </div>
            </div>
            <div class="all-select-div">
              <div class="price-submit-btn">
                <div class="select-div">
                  <span class="red">*</span> 투어 금액
                </div>
                <form:errors path="gdTrPrc" element="div" cssClass="errors" />
                <div class="price-flex-div">
                  <input
                    id="trPrc"
                    name="gdTrPrc"
                    type="number"
                    value="${guideTourWriteVO.gdTrPrc}"
                    step="0.01"
                  />
                  <div>$</div>
                </div>
                <div class="right-align">
                  <input id="submit-regi" type="submit" value="투어 등록" />
                </div>
              </div>
            </div>
          </div>
        </form:form>
      </div>
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>
</html>
