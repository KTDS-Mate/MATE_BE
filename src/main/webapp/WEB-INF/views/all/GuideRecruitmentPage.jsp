<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>가이드 투어 상세보기</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/GuideRecruitmentPage.css"
    />
    <link
      rel="stylesheet"
      type="text/css"
      href="/css/common.css"
    />
  </head>
  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <div class="grid-rows">
          <div class="subject">
            <div>
              <h3>${userTourVO.usrTrTtl}</h3>
            </div>
            <div class="wish-button"></div>
          </div>
          <div class="img-price">
            <div class="img-group">
              <div class="main-img">
              	<img alt="main-img" src="${userTourVO.userTourImgList[0].usrTrRqImgIdUrl}">
              </div>
              <div class="second-img">
              	<img alt="second-img" src="${userTourVO.userTourImgList[0].usrTrRqImgIdUrl}">
              </div>
              <div class="third-img">
              	<img alt="third-img" src="${userTourVO.userTourImgList[0].usrTrRqImgIdUrl}">
              </div>
              <div class="plus-img">
              	<img alt="plus-img" src="${userTourVO.userTourImgList[0].usrTrRqImgIdUrl}">
              	<div class="z-index">
              		<button class="img-btn">+</button>
              	</div>
              </div>
            </div>
            <div class="price-group">
              <div class="price-for">
                <h2>Price</h2>
              </div>
              <div class="price-person">
                <div class="price-ad-c">
                  <h2>${userTourVO.usrTrGdHrPrc}$</h2>
                </div>
              </div>
            </div>
          </div>
          <div class="summation-guide">
            <div class="summation">
              <div class="view-dtls">
                <h2>희망 가이드</h2>
              </div>
              <div>
                <ul class="guide-dtls-list">
                  <li>성별 : ${userTourVO.gdGndr}</li>
                  <li>나이 : ${userTourVO.gdAge}대</li>
                  <li>가이드 경력 : ${userTourVO.gdCrr}년 이상</li>
                </ul>
              </div>
            </div>
          </div>
          <div class="want-tour">
            <div class="want-list">
              <div class="view-dtls">
                <h2>투어에서 원하는 것</h2>
              </div>
              <div>
                <ol class="summation-list">
                  <c:if test="${not empty userTourVO.usrTrRqDtl}">
                  	<li>${userTourVO.usrTrRqDtl}</li>
                  </c:if>
                </ol>
              </div>
            </div>
          </div>
          <div class="want-time">
            <div class="want-time-place">
              <div class="view-dtls">
                <h2>집결 희망 장소 / 시간</h2>
              </div>
              <div class="margin-left">
                <h2>
                  ${userTourVO.usrTrMp}
                </h2>
                <div class="flex-div">
                  <div><h3>${userTourVO.usrTrDt}</h3></div>
                  <div class="margin-right"><h4>Open In GoogleMap</h4></div>
                </div>
              </div>
            </div>
          </div>
          <div class="want-tour">
            <div class="hope-info">
              <div class="view-dtls">
                <h2>투어 희망 정보</h2>
              </div>
              <div>
                <ul class="hope-info-list">
                  <c:choose>
                  	<c:when test="${not empty userTourVO.userTourSchdlList}">
				    	<c:forEach items="${userTourVO.userTourSchdlList}" 
                  			 var="userTourSchdl"
                  			 varStatus="index">
                  			<li>
	                    		<p class="list-item">
	                      			<span class="background-num">${index.index + 1}</span>
	                      				${userTourSchdl.trLctns}
	                    		</p>
	                    		<p class="border-left">
	                      			${userTourSchdl.trRqst}
	                    		</p>
                  			</li>
                  		</c:forEach>
                  	</c:when>
                  	<c:otherwise>
                  		<li>
                  			<p class="list-item">작성한 투어 희망 정보가 없습니다.</p>
                  		</li>
                  	</c:otherwise>
                  </c:choose>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
      </div>
    </div>
  </body>
</html>
