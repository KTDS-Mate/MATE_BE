<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <title>여행자 투어 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/usertour/Tourist_TourInsert.css" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="//rawgithub.com/indrimuska/jquery-editable-select/master/dist/jquery-editable-select.min.js"></script>
	<link href="//rawgithub.com/indrimuska/jquery-editable-select/master/dist/jquery-editable-select.min.css" rel="stylesheet">
    <script
      type="text/javascript"
      src="/js/usertour/usertourinsert.js"></script>
  </head>
  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <form:form modelAttribute="userTourWriteVO" method="post" enctype="multipart/form-data">
          <div class="insert-main">
            <div class="flex-main-img">
              <div>
                <h1>투어 요청 작성</h1>
              </div>
              <img class="main-img" alt="메인 이미지" src="/img/tourboard/예시여행이미지.png" />
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 투어 제목</div>
              <form:errors path="usrTrTtl" element="div" cssClass="errors" />
                <textarea id="usrTrTtl" name="usrTrTtl">${userTourWriteVO.usrTrTtl}</textarea>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                <span class="red">*</span> 투어 지역 선택
              </div>
              <div class="region-country-div">
	              <select id="region" required="required" tabindex="2">
	              	<option value="">대륙 선택</option>
	              </select>
	              <select id="country" disabled="disabled" required="required" tabindex="3">
	              	<option value="">국가 선택</option>
	              </select>
              </div>
              <select id="city" name="trCtId" disabled="disabled" required="required" tabindex="4">
              	<option value="">도시 선택</option>
              </select>
            </div>
            <div>
              <div class="select-div"><span class="red">*</span> 날짜 선택</div>
              <label for="date-check">당일치기</label>
              <input name="isChecked" id="date-check" type="checkbox" />
              <div class="tour-date-select">
	              <input
	              	tabindex="5"
	                id="inputYear"
	                name="inputYear"
	                type="date"
	                value="${userTourWriteVO.inputYear}" />
	              <img class="tilde-img" src="/img/tourboard/~.png" />
	              <input
	                id="inputEndYear"
	                name="inputEndYear"
	                type="date"
	                value="${userTourWriteVO.inputEndYear}" />
              </div>
            </div>
            <div class="all-select-div">
              <div class="tour-time-select">
                  <input id="start-time" name="inputStartHour" type="time" tabindex="6" />
                  <img class="tilde-img" src="/img/tourboard/~.png" />
                  <input id="end-time" name="inputEndHour" type="time" tabindex="7" />
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 인원 선택</div>
              <form:errors path="usrTrNp" element="div" cssClass="errors" />
              <div class="person-flex-div">
                <input
                  tabindex="8"
                  id="tourNp"
                  type="number"
                  name="usrTrNp"
                  value="${userTourWriteVO.usrTrNp}" />
                <div>명</div>
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 투어 목적</div>
              <form:errors path="usrTrPrps" element="div" cssClass="errors" />
              <textarea tabindex="9" name="usrTrPrps">${userTourWriteVO.usrTrPrps}</textarea>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                투어 희망 정보<span class="font-we"
                  >원하는 일정을 추가해주세요.</span
                ><span class="font-we">&lt;최대 10개까지 넣을 수 있습니다.&gt;</span>
              </div>
              <div class="loc-inf">
                	<div class="locs">
                		<div>
                			<label>시간</label>
                			<input id="hope-time" name="userTourSchdlList[0].trTm" type="datetime-local" />
                		</div>
						<div>
							<label for="hope-location">장소</label>
							<input id="hope-location" name="userTourSchdlList[0].trLctns" type="text" required="required" />
						</div>
						<div>
							<label for="hope-info">일정</label>
							<textarea id="hope-info" name="userTourSchdlList[0].trRqst" type="text" required="required"></textarea>
						</div>
					</div>
              </div>
              <div class="hope-btn">
                <input tabindex="10" id="plus" type="button" value="일정 추가하기" />
                <input tabindex="11" id="m-btn" type="button" value="일정 삭제하기" />
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                <span class="red">*</span> 투어 세부 요구사항
              </div>
              <form:errors path="usrTrRqDtl" element="div" cssClass="errors" />
              <textarea tabindex="12" name="usrTrRqDtl">
${userTourWriteVO.usrTrRqDtl}</textarea
              >
            </div>
            <div class="all-select-div">
              <div>
                <div class="select-div">투어 이미지 추가<span class="font-we"
                  >&lt;img, png, svc 파일만 넣을 수 있습니다.&gt;</span
                ><span class="font-we">&lt;최대 10개까지 넣을 수 있습니다.&gt;</span></div>
                <input id="add-file" type="button" value="파일 추가" />
                <input id="del-file" type="button" value="파일 삭제" />
                <div class="file-list">
                	<!-- Jquery를 이용해 파일 리스트가 추가되는 곳 -->
                </div>
              </div>
            </div>
            <div class="all-select-div">
	            <div>
	                <div class="select-div">
	                  <span class="red">*</span> 집결 장소 선택
	                </div>
	                <div id="googleMap"></div>
	              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div">원하는 가이드</div>
              <div class="flex-want-gd-div">
                <div>
                  <label for="gender">성별</label>
                  <select tabindex="14" name="gdGndr" id="gender">
                    <option value="상관없음">상관없음</option>
                    <option value="male">남자</option>
                    <option value="female">여자</option>
                  </select>
                </div>
                <div>
                  <label for="age">나이</label>
                  <select tabindex="15" name="gdAge" id="age">
                    <option value="0">상관없음</option>
                    <option value="20">20대</option>
                    <option value="30">30대</option>
                    <option value="40">40대</option>
                  </select>
                </div>
              </div>
              <div>
                <div class="select-div">가이드에게 원하는 사항</div>
                <textarea tabindex="17" name="gdWntRq">${userTourWriteVO.gdWntRq}</textarea>
              </div>
              <div class="price-submit-btn">
                <div class="select-div">
                  <span class="red">*</span> 고용 금액
                </div>
                <div class="insertBtnGroup">
	                <form:errors
	                  path="usrTrGdHrPrc"
	                  element="div"
	                  cssClass="errors" />
	                <div class="price-flex-div">
	                  <strong>$</strong>
	                  <input
	                  	tabindex="18"
	                    id="trPrc"
	                    name="usrTrGdHrPrc"
	                    type="number"
	                    value="${userTourWriteVO.usrTrGdHrPrc}"
	                    step="0.1" />
	                </div>
	                <div class="button" onclick="javascript:moveRequest()">
					    <p class="btnText">해주세요</p>
					    <div class="btnTwo">
					      <p class="btnText2">GO!</p>
					    </div>
					 </div>
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
