<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
    <title>Mypage_Tourist_MyTour</title>
    <link rel="stylesheet" type="text/css" href="/css/mypage/PaymentList.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/mypage/paymentList.js"></script>
  </head>

  <body>
    <div class="grid">
      <div class="header">
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
        <div class="content-grid">
          <jsp:include page="../Tourist_Sidebar.jsp"></jsp:include>
          <div class="my-tour">
            <div class="tour-list-top">
              <div>
                <h1 style="font-weight: bold">결제 내역</h1>
              </div>
            </div>

            <div class="border"></div>

            <div class="guide-text">
              <span class="sample">
                최근 2년간 주문내역을 조회하실 수 있습니다
              </span>
            </div>

            <!-- 필터 박스 --------------------------------------------------------------->
            <div class="filter-box">
              <form class="search-form">
			  	      <input
	                	type="hidden"
                		name="pageNo"
                		class="page-no"
                		value="${searchPaymentVO.pageNo}" />
                <div class="filter-grid">
                  <div class="search-block">
                  <!-- 날짜 버튼들 -->
                  <div class="date-buttons">
                    <input 
                      id="date-hidden"
                      type="hidden" 
                      value= "${searchPaymentVO.searchType}"
                      name = "searchType" />
                    <input
                      type="button"
                      onclick="window.location.href='/mypage/payment/list/${searchPaymentVO.trstLgnId}'"
                      value="전체조회"
                      />
                    <input 
                      id="one-week"
                      class="${searchPaymentVO.searchType eq '일주일' ? 'checked' : ''}"
                      type="button" 
                      value= "일주일" />
                    <input 
                      id="one-month"
                      class="${searchPaymentVO.searchType eq '1개월' ? 'checked' : ''}"
                      type="button" 
                      value= "1개월" />
                    <input 
                      id="three-month"
                      class="${searchPaymentVO.searchType eq '3개월' ? 'checked' : ''}"
                      type="button" 
                      value= "3개월" />
                    <input 
                      id="six-month"
                      class="${searchPaymentVO.searchType eq '6개월' ? 'checked' : ''}"
                      type="button" 
                      value= "6개월" />
                    <input 
                      id="custom-period"
                      class="${searchPaymentVO.searchType eq '기간검색' ? 'checked' : ''}"
                      type="button" 
                      value= "기간검색" />
                    </div>
                    <!-- 날짜 입력란 -->
                    <div class="date-range">
                      <input id="startDate" type="date" class="startDate" value="${searchPaymentVO.startDate}" name="startDate" />
                      ~
                      <input id="endDate" type="date" class="endDate" value="${searchPaymentVO.endDate}" name="endDate"/>
                    </div>

                    <div class="select-area">
                    <!-- 투어 타입 선택 -->
                    <select class="select-form" name ="tourType">
                      <option value="" ${"" eq searchPaymentVO.tourType ? "selected" : ""}>투어타입</option>
                      <option value="TOURIST" ${"TOURIST" eq searchPaymentVO.tourType ? "selected" : ""}>여행자</option>
                      <option value="GUIDE" ${"GUIDE" eq searchPaymentVO.tourType ? "selected" : ""}>가이드</option>
                    </select>
  
                    <select class="select-form" name ="payState">
                      <option value="" ${"" eq searchPaymentVO.payState ? "selected" : ""}>결제상태</option>
                      <option value="WAITING" ${"WAITING" eq searchPaymentVO.payState ? "selected" : ""}>결제대기</option>
                      <option value="COMPLETE" ${"COMPLETE" eq searchPaymentVO.payState ? "selected" : ""}>결제완료</option>
                      <option value="REFUND" ${"REFUND" eq searchPaymentVO.payState ? "selected" : ""}>환불</option>
                      <option value="CANCEL" ${"CANCEL" eq searchPaymentVO.payState ? "selected" : ""}>예약취소</option>
                    </select>
                  </div>
                </div>
              		
                  <!-- 조회 버튼 -->
                <div class="search-submit-btn">
                  <button>조회하기</button>
                </div>
                </div>
              </form>
            </div>
            <!-------------------------------------------------------------->

            <div class="tour-list">
              <table class="payment-table">
                <thead>
                  <th>결제정보ID</th>
                  <th>결제요청일</th>
                  <th>투어타입</th>
                  <th>투어명</th>
                  <th>가이드 이름</th>
                  <th>결제상태</th>
                  <th>투어금액</th>
                </thead>
                <tbody class="elements-list" >
                  <c:choose>
                    <c:when test="${not empty paymentListVO.paymentList}">
                      <c:forEach
                        items="${paymentListVO.paymentList}"
                        var="payInfo"
                      >
                        <tr
						 onclick="window.location.href='/payment/detail/${searchPaymentVO.trstLgnId}'
						 +'?payId=' + '${payInfo.payId}' ">
                          <td>${payInfo.payId}</td>
                          <td>${payInfo.payCrtDt}</td>
                          <td>${payInfo.payTrTp}</td>
                          <!-- if문을 이용하여 payTrTp이 어느 게시글인지에 따라 출력 -->
                          <c:if test="${payInfo.payTrTp eq 'TOURIST'}">
                            <td>${payInfo.usrTrTtl}</td>
                          </c:if>
                          <c:if test="${payInfo.payTrTp eq 'GUIDE'}">
                            <td>${payInfo.gdTrTtl}</td>
                          </c:if>
                          <td>${payInfo.gdFnm}</td>
                          <td>${payInfo.payStt}</td>
                          <td>${payInfo.payCsh}</td>
                        </tr>
                      </c:forEach>
                    </c:when>
                    <c:otherwise>
                      <tr>
                        <td colspan="7">결제 내역이 존재하지 않습니다.</td>
                      </tr>
                    </c:otherwise>
                  </c:choose>
                </tbody>
              </table>
              <!--  페이지네이션 -->
              <ul class="page-nav">
	      		<c:if test="${searchPaymentVO.hesprevGroup}">
	      			<li>
		      			<a href="javascript:movePage(0);">
		      				처음
		      			</a>
		      		</li>
	      			<li>
	      				<a href="javascript:movePage(${searchPaymentVO.prevGroupStartPageNo});">
	      					이전
	      				</a>
	      			</li>
	      		</c:if>
	      		<c:forEach begin="${searchPaymentVO.groupStartPageNo}"
	      			   end="${searchPaymentVO.groupEndPageNo}"
	      			   step="1"
	      			   var="p">
	      			<li class="${p eq searchPaymentVO.pageNo ? 'active': ''}">
	      				<a href="javascript:movePage(${p});">
		      				${p + 1}
	      				</a>
		      		</li>
	      		</c:forEach>
	      		<c:if test="${searchPaymentVO.hasNextGroup}">
	      			<li>
	      				<a href="javascript:movePage(${searchPaymentVO.nextGroupStartPageNo});">
	      					다음
		      			</a>
	      			</li>
	      			<li>
	      				<a href="javascript:movePage(${searchPaymentVO.pageCount-1 });">
		      				마지막
		      			</a>
		      		</li>
	      	    </c:if>
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
