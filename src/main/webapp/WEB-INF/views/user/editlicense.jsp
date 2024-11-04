<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="/css/common.css" />
  <link rel="stylesheet" type="text/css" href="/css/MainPage.css" />
  <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
  <script type="text/javascript" src="/js/editlicense.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/user/guidemodify.css" />
</head>
  
<body>
	<form:form method="post" modelAttribute="guideInfo" action="/user/editlicense" enctype="multipart/form-data">
	    <div class="license-container" data-license-index="${guideInfo.licenses != null ? guideInfo.licenses.size() : 0}">
	    <h2>자격증 등록 및 수정</h2>
	
	    <!-- 기존 자격증 리스트 표시 -->
	    <c:forEach var="license" items="${guideInfo.licenses}" varStatus="status">
	        <div class="license-form">
	            <div class="license-image">
	                <c:choose>
	                    <c:when test="${not empty license.lcnImg}">
	                        <img src="${license.lcnImg}" alt="자격증 이미지">
	                    </c:when>
	                    <c:otherwise>
	                        <img src="img/certificate-placeholder.png" alt="자격증 이미지">
	                    </c:otherwise>
	                </c:choose>
	            </div>
	            <div class="upload-button">
	                <label for="lcnImgFile-${status.index}">사진 등록</label>
	                <input type="file" name="licenses[${status.index}].lcnImgFile" id="lcnImgFile-${status.index}" />
	            </div>
	            
	            <div class="form-item">
	                <input type="text" name="licenses[${status.index}].lcnNm" value="${license.lcnNm}" placeholder="자격증 이름을 입력하세요." />
	            </div>
	
	            <button type="button" class="delete-button" onclick="removeLicenseItem(this)">삭제</button>
	        </div>
	    </c:forEach>
	
	    <!-- 자격증 추가 버튼 -->
	    <button type="button" class="register-button" onclick="addLicenseItem()">추가하기</button>
	
	    <!-- 자격증 추가 영역 -->
	    <div id="additionalLicenses"></div>
	</div>
	
    <!-- 서버로 폼 데이터 전송을 위한 제출 버튼 -->
    <button type="submit" class="submit-button">저장하기</button>
    </form:form>
</body>
</html>