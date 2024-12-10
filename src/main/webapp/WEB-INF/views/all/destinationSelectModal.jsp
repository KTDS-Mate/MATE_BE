<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/main/destinationSelectModal.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script
      type="text/javascript"
      src="/js/main/destinationSelectModal.js"
    ></script>
  </head>
  <body>
    <dialog id="destinationSelectModal" class="destinationSelectModal hidden">
      <div id="searchModalArea" class="searchModalArea">
        <h2>검색</h2>
        <div class="searchModalContent">
          <form class="searchForm">
<%--             <input
              type="hidden"
              id="search-val-1"
              name="searchType"
              value="${searchUserTourVO.searchType}"
            /> --%>
            <div class="searchArea">
              <select name="searchType" class="searchType">
                <option
                  value="country"
                  class='${"country" eq searchUserTourVO.searchType ? "selected" : ""}'
                >
                  국가
                </option>
                <option
                  value="city"
                  class='${"city" eq searchUserTourVO.searchType ? "selected" : ""}'
                >
                  도시
                </option>
              </select>
              <input
                type="text"
                class="searchInput"
                name="searchKeyword"
                placeholder="검색어를 입력해주세요."
                value="${searchUserTourVO.searchKeyword}"
              />
              <button type="button" class="searchButton">검색</button>
            </div>

          </form>
                      <div class="searchResultArea" id="searchResultArea">
            	
            </div>
        </div>
      </div>
    </dialog>
  </body>
</html>
