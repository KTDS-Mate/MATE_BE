<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>라이센스 수정</title>
    <link rel="stylesheet" type="text/css" href="/css/user/editlicense.css" />
</head>
<body>
    <div class="content">
        <h2>라이센스 수정</h2>
        <form:form modelAttribute="guideInfo" method="post" action="/user/editlicense" class="edit-form" enctype="multipart/form-data">
            <div id="licenseSection">
                <!-- 유저의 기존 라이센스 목록을 반복 출력 -->
                <c:forEach var="license" items="${guideInfo.licenses}" varStatus="status">
				    <div class="form-item">
				        <label for="license-${status.index}">라이센스 명</label>
				        <input type="text" id="license-${status.index}" name="licenses[${status.index}].lcnNm" value="${license.lcnNm}" placeholder="라이센스 명" />
				        <button type="button" class="delete-button" onclick="deleteLicense('${license.lcnId}', '${license.lcnNm}')">삭제</button>
				    </div>
				    <div class="form-item">
				        <span>라이센스 인증서류</span>
				        <div class="filebox">
				            <input type="file" id="lcnImgFile-${status.index}" name="licenses[${status.index}].lcnImgFile" class="licenseImg filename" />
				            <label class="file-search" for="lcnImgFile-${status.index}">파일 찾기</label>
				            <!-- 기존 파일명 표시 -->
				            <input type="hidden" name="licenses[${status.index}].lcnId" value="${license.lcnId}" />
				            <span>${license.lcnImg}</span>
				            <!-- 이미지 미리보기 -->
				            <img id="preview-${status.index}" src="${license.lcnImg}" alt="미리보기" class="img-preview" style="display: ${license.lcnImg ? 'block' : 'none'}; max-width: 150px; max-height: 150px;"/>
				        </div>
				    </div>
				</c:forEach>
            </div>
            
            <!-- 라이센스 추가 버튼 -->
			<div class="form-item">
			    <button type="button" id="add-license-btn" data-license-index="${guideInfo.licenses.size()}">라이센스 추가</button>
			</div>
            
            <div class="form-item">
                <button type="submit" class="save-button">저장</button>
                <button type="button" class="cancel-button" onclick="window.history.back();">취소</button>
            </div>
        </form:form>
    </div>
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/editlicense.js"></script>
</body>
</html>
