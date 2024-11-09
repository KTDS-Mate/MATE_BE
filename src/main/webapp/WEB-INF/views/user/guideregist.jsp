<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가이드 등록</title>
    <link rel="stylesheet" href="/css/user/guideregist.css">
    <script src="/js/jquery-3.7.1.min.js"></script>
    <script src="/js/user/guideregist.js"></script>
</head>
<body>

    <div class="header">
      <!-- 헤더 공통파일 -->
      <jsp:include page="../header.jsp"></jsp:include>
    </div>

    <div class="container">
    	<h1>가이드 등록</h1>
    <form:form modelAttribute="registGuideVO" method="post" class="regist-form" enctype="multipart/form-data">
        <!-- 인적 사항 -->
        <div class="section-box">
        
            <h2>인적 사항</h2>
            <div class="form-item">
                <span>성명 (Full Name) </span>
                <c:out value="${registGuideVO.usrLnm} ${registGuideVO.usrFnm}" />
            </div>
            <div class="form-item">
                <span>성별 </span>
                <c:out value="${registGuideVO.usrGndr}" />
            </div>
            <div class="form-item">
                <span>생년월일 </span>
                <c:out value="${registGuideVO.usrBd}" />
            </div>
            <div class="form-item">
                <span>휴대전화번호 </span>
                <c:out value="${registGuideVO.usrPhn}" />
            </div>
            <div class="form-item">
                <span>이메일 </span>
                <c:out value="${registGuideVO.usrEml}" />
            </div>
            <div class="form-item">
                <span>대표 국적 </span>
                <c:out value="${registGuideVO.countryName}" />
            </div>
            <div class="form-item">
                <label>신분증 사본</label>
                <input type="file" id="gdIdImgFile" name="gdIdImgFile">
            </div>
            <div class="form-item">
                <label>범죄경력조회서</label>
                <input type="file" id="gdCbcImgFile" name="gdCbcImgFile">
            </div>
        </div>

        <!-- 커리어 -->
        <div class="section-box">
            <h2>커리어</h2>
            <div class="form-item">
                <label>가이드 경력</label>
                <input type="text" id="usrGdExp" name="usrGdExp" placeholder="년을 제외한 숫자만 입력해주세요.">
            </div>
            <div class="form-item">
                <label>자기소개</label>
                <form:textarea path="usrSlfIntdctn" id="usrSlfIntdctn" placeholder="자기소개를 입력하세요"></form:textarea>
            </div>
            <div class="form-item">
                <label>활동 국가 선택</label>
                <form:select path="gdRpCntId" id="gdRpCntId" onchange="guideregist(this.value)">
                    <form:option value="">국가를 선택하세요</form:option>
                    <c:forEach items="${countriesList}" var="country">
                        <form:option value="${country.countryId}">${country.countryName}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-item">
			    <label>활동 도시 선택</label>
			    <div id="citySelection">
			        <div class="selected-option" onclick="toggleDropdown()">도시를 선택하세요</div>
			        <ul id="customDropdown" class="dropdown-list hidden"></ul>
			        <button type="button" class="plus-item" onclick="addCity()">지역 추가</button>
			    </div>
			    <ul id="addedCitiesList"></ul>
			</div>
		</div>
        <!-- 라이센스 -->
        <div class="section-box">
            <h2>라이센스</h2>
            <div class="form-item">
                <label for="license-0">라이센스명</label>
                <input type="text" name="licenses[0].lcnNm" id="license-0" placeholder="라이센스 명">
            </div>
            <div class="form-item">
                <label>라이센스 인증서류</label>
                <input type="file" name="licenses[0].lcnImgFile" id="lcnImgFile-0">
            </div>
            <div id="additionalLicenses"></div>
            <button type="button" onclick="addLicenseItem()">라이센스 추가</button>
            
        </div>

        <!-- 정산 정보 -->
        <div class="section-box">
            <h2>정산 정보</h2>
            <div class="form-item">
                <label>PayPal Email</label>
                <input type="email" name="usrPypEml" placeholder="PayPal Email 주소 입력">
            </div>
        </div>
		<div class="button-container">
	        <button type="submit">등록</button>
	        <button type="button" onclick="window.location.href='/mypage/edit-profile/choice?usrLgnId=${sessionScope._LOGIN_USER_.usrLgnId}&usrIsGd=${sessionScope._LOGIN_USER_.usrIsGd}'">취소</button>
        </div>
    </form:form>
    </div>
    
    <div class="footer">
      <!-- footer 공통파일 -->
      <jsp:include page="../footer.jsp"></jsp:include>
    </div>
</body>
</html>
