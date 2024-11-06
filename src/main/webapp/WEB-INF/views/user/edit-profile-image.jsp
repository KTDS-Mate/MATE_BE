<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/user/editlicense.css" />

</head>
<body>
<form:form method="post" action="/user/update-profile-image" enctype="multipart/form-data">
    <div class="form-item">
        <label for="profileImg">프로필 이미지</label>
        <input type="file" id="profileImg" name="profileImgFile" onchange="previewProfileImage(this)" class="filename" />
        <label class="file-search" for="profileImg">파일 찾기</label>
        <img id="profilePreview" src="${guideInfo.gdPrflImg}" alt="미리보기" class="img-preview"
             style="display: ${guideInfo.gdPrflImg ? 'block' : 'none'}; max-width: 150px; max-height: 150px;"/>
    </div>
    <button type="submit">프로필 이미지 저장</button>
</form:form>
</body>
</html>