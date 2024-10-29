<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
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
        <form:form modelAttribute="userTourWriteVO" method="post">
          <input />
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
              <select id="region" required="required">
              	<option value="">대륙 선택</option>
              </select>
              <select id="country" disabled="disabled" required="required">
              	<option value="">국가 선택</option>
              </select>
              <select id="city" name="trCtId" disabled="disabled" required="required">
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
                value="${userTourVO.inputYear}" />
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 시간 선택</div>
              <div class="flex-hour-div">
                <div class="time-select">
                	<label for="start-time">시작 시간</label>
                	<input id="start-time" type="time" disabled="disabled" />
                </div>
                <div class="inline-margin">
                  <img src="/img/tourboard/~.png" />
                </div>
                <div class="time-select">
                  <label for="end-time">종료 시간</label>
                  <input id="end-time" type="time" disabled="disabled" />
                </div>
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div"><span class="red">*</span> 인원 선택</div>
              <form:errors path="usrTrNp" element="div" cssClass="errors" />
              <div class="person-flex-div">
                <input
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
              <textarea name="usrTrPrps">${userTourVO.usrTrPrps}</textarea>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                투어 희망 정보<span class="font-we"
                  >원하는 일정을 추가해주세요.</span
                >
              </div>
              <div class="loc-inf">
                <!-- jquery를 사용해 여러 개를 호출 받는 곳 -->
              </div>
              <div class="hope-btn">
                <input id="plus" type="button" value="일정 추가하기" />
              </div>
            </div>
            <div class="all-select-div">
              <div class="select-div">
                <span class="red">*</span> 투어 세부 요구사항
              </div>
              <form:errors path="usrTrRqDtl" element="div" cssClass="errors" />
              <textarea name="usrTrRqDtl">
${userTourVO.usrTrRqDtl}</textarea
              >
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
              <div class="select-div">원하는 가이드</div>
              <div class="flex-want-gd-div">
                <div>
                  <label for="gender">성별</label>
                  <select name="gdGndr" id="gender">
                    <option value="상관없음">상관없음</option>
                    <option value="male">남자</option>
                    <option value="female">여자</option>
                  </select>
                </div>
                <div>
                  <label for="age">나이</label>
                  <select name="gdAge" id="age">
                    <option value="0">상관없음</option>
                    <option value="20">20대</option>
                    <option value="30">30대</option>
                    <option value="40">40대</option>
                  </select>
                </div>
                <div>
                  <label for="career">경력</label>
                  <select name="gdCrr" id="career">
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
                <textarea name="gdWntRq">${userTourVO.gdWntRq}</textarea>
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
                  	id="trPrc"
                    name="usrTrGdHrPrc"
                    type="number"
                    value="${userTourVO.usrTrGdHrPrc}"
                    step="0.01" />
                  <div>$</div>
                </div>
                <div class="right-align">
                  <input id="submit-btn" type="submit" value="수정 완료" disabled="disabled" />
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
