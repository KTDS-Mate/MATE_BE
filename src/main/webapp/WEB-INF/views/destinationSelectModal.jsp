<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/destinationSelectModal.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/destinationSelectModal.js"></script>
  </head>
  <body>
    <dialog id="destinationSelectModal" class="destinationSelectModal hidden">
      <div id="searchModalArea" class="searchModalArea hidden">
        <div class="searchmodalContent">
          <h2>검색</h2>
          <input type="text" id="searchInput" placeholder="검색어 입력" />
          <img
            src="/public/searchButton.png"
            alt="검색 버튼"
            id="searchButton"
            class="searchButton"
          />
          <div id="searchResults"></div>
          <button class="closeModal">닫기</button>
        </div>
      </div>
    </dialog>
  </body>
</html>
