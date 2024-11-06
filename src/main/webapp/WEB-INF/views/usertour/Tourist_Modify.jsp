<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>여행자 투어 수정</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/usertour/Tourist_Modify.css" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script
      type="text/javascript"
      src="/js/usertour/usertourmodify.js"></script>
    <!-- <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="//rawgithub.com/indrimuska/jquery-editable-select/master/dist/jquery-editable-select.min.js"></script>
    <link
      href="//rawgithub.com/indrimuska/jquery-editable-select/master/dist/jquery-editable-select.min.css"
      rel="stylesheet" /> -->
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
              <img alt="메인 이미지" src="/img/tourboard/예시여행이미지.png" />
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 투어 제목</div>
              <form:errors path="usrTrTtl" element="div" cssClass="errors" />
              <input
              	tabindex="1"
                id="usrTrTtl"
                name="usrTrTtl"
                type="text"
                placeholder="제목을 입력해주세요."
                value="${userTourVO.usrTrTtl}" />
            </div>
            <div class="all-select-div">
              <div class="select-div">
                <span class="red">*</span> 투어 지역 선택
              </div>
              <div>
	              <select id="region" required="required" tabindex="2">
	              	<option value="">대륙 선택</option>
	              </select>
	              <select id="country" disabled="disabled" required="required" tabindex="3">
	              	<optgroup id="country-opt">
	              		<option value="">국가 선택</option>
	              	</optgroup>
	              </select>
              </div>
              <select id="city" name="trCtId" disabled="disabled" required="required" tabindex="4">
              	<option value="">도시 선택</option>
              </select>
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 날짜 선택</div>
              <input
              	tabindex="5"
                id="inputYear"
                name="inputYear"
                type="date"
                data-placeholder="투어 날짜를 골라주세요."
                value="${userTourVO.inputYear}" />
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 시간 선택</div>
              <div class="flex-hour-div">
                <div class="time-select">
                  <label for="start-time">시작 시간</label>
                  <input id="start-time" name="inputStartHour" type="time" disabled="disabled" tabindex="6" />
                </div>
                <div class="inline-margin">
                  <img src="/img/tourboard/~.png" />
                </div>
                <div class="time-select">
                  <label for="end-time">종료 시간</label>
                  <input id="end-time" name="inputEndHour" type="time" disabled="disabled" tabindex="7" />
                </div>
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
                  value="${userTourVO.usrTrNp}" />
                <div>명</div>
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 투어 목적</div>
              <form:errors path="usrTrPrps" element="div" cssClass="errors" />
              <textarea tabindex="9" name="usrTrPrps">${userTourVO.usrTrPrps}</textarea>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                투어 희망 정보<span class="font-we"
                  >원하는 일정을 추가해주세요.</span
                ><span class="font-we">&lt;최대 10개까지 넣을 수 있습니다.&gt;</span>
              </div>
              <div class="hope-btn">
                <input tabindex="10" id="plus" type="button" value="일정 추가하기" />
                <input tabindex="11" id="m-btn" type="button" value="일정 삭제하기" />
              </div>
              <div class="loc-inf">
              <c:if test="${not empty userTourVO.userTourSchdlList}">
              	<c:forEach items="${userTourVO.userTourSchdlList}" var="schdls" varStatus="index">
              		<div class="locs">
						<div>
							<label for="hope-location">장소</label>
							<input id="hope-location" name="userTourSchdlList[${index.index}].trLctns" value="${schdls.trLctns}" type="text" required="required" />
						</div>
						<div>
							<label for="hope-info">일정</label>
							<input id="hope-info" name="userTourSchdlList[${index.index}].trRqst" value="${schdls.trRqst}" type="text" required="required" />
						</div>
					</div>
              	</c:forEach>
              </c:if>
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                <span class="red">*</span> 투어 세부 요구사항
              </div>
              <form:errors path="usrTrRqDtl" element="div" cssClass="errors" />
              <textarea tabindex="12" name="usrTrRqDtl">
${userTourVO.usrTrRqDtl}</textarea
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
                <div>
                  <label for="career">경력</label>
                  <select tabindex="16" name="gdCrr" id="career">
                    <option value="0">상관없음</option>
                    <option value="1">1년차 이상</option>
                    <option value="3">3년차 이상</option>
                    <option value="5">5년차 이상</option>
                    <option value="10">10년차 이상</option>
                  </select>
                </div>
              </div>
              <div>
                <div class="select-div">가이드에게 원하는 사항</div>
                <textarea tabindex="17" name="gdWntRq">${userTourVO.gdWntRq}</textarea>
              </div>
              <div class="price-submit-btn">
                <div class="select-div">
                  <span class="red">*</span> 고용 금액
                </div>
                <form:errors
                  path="usrTrGdHrPrc"
                  element="div"
                  cssClass="errors" />
                <div class="price-flex-div">
                  <input
                  	tabindex="18"
                    id="trPrc"
                    name="usrTrGdHrPrc"
                    type="number"
                    value="${userTourVO.usrTrGdHrPrc}"
                    step="0.01"/>
                  <div>$</div>
                </div>
                <div class="right-align">
                  <input tabindex="19" type="submit" value="투어 등록" />
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
