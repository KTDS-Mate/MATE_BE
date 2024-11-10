<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>ID 이미지 수정</title>
    <link rel="stylesheet" type="text/css" href="/css/user/edit-id-image.css" />
  </head>
  <body>
    <form:form
      method="post"
      action="/user/update-id-image"
      enctype="multipart/form-data"
    >
      <div class="form-item">
        <label for="idImage">ID 이미지</label>
        <input
          type="file"
          id="idImage"
          name="idImageFile"
          onchange="previewIdImage(this)"
          class="filename"
        />
        <label class="file-search" for="idImage">파일 찾기</label>
        <img
          id="idPreview"
          src="${guideInfo.gdIdImg}"
          alt="미리보기"
          class="img-preview"
          style="
            display: $ {
              guideinfo.gdidimg? 'block' : 'none';
            }
            max-width: 150px;
            max-height: 150px;
          "
        />
      </div>
      <button type="submit">ID 이미지 저장</button>
    </form:form>
  </body>
</html>
