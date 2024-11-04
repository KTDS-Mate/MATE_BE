<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행자 나의 신청 투어 목록</title>
	<link rel="stylesheet" type="text/css" href="/css/common.css" />
	<link rel="stylesheet" type="text/css" href="/css/Mypage_Tourist_Apply.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet">
	<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/mypage/Mypage_Tourist_Apply.js"></script>
</head>
<body>
	<div class="grid">
      <!--  -->
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <!--  -->

      <div class="content">
        <div class="content-grid">
          <!-- side-bar 공통파일 -->
          <jsp:include page="../Tourist_Sidebar.jsp"></jsp:include>
          <div class="apply-content">
          	<div class="apply-ttl">나의 신청 투어 목록</div>
          	<div class="apply-search-area">
          		<div class="apply-search-zone">
          			<input type="text" placeholder="검색어를 입력해주세요." />
          			<input type="button" value="검색" />
          		</div>
          		<div class="apply-filter-zone">
          			<select>
          				<option value="tr">투어 일자 순</option>
          				<option value="cr">결제 일자 순</option>
          			</select>
          		</div>
          	</div>
          	<div class="apply-table-div">
          		<table class="apply-table">
          			<thead>
          				<tr>
          					<th>투어 제목</th>
          					<th>가이드 명</th>
          					<th>투어 일자</th>
          					<th>투어 상태</th>
          					<th>결제 상태</th>
          					<th>결제 일자</th>
          					<th>투어 완료 선택</th>
          				</tr>
          			</thead>
          			<tbody>
          				<c:choose>
          				<c:when test="${not empty myApplyTourListVO.myApplyUserTourList}">
          				<c:forEach items="${myApplyTourListVO.myApplyUserTourList}" var="myApplyTourVO" varStatus="sts">
          					<tr id='re-${sts.index}' class="result-sum">
	          					<td>
	          						${myApplyTourVO.gdTrTtl}
	          						<input class="apply-hide" type="hidden" 
	          						data-stts="${myApplyTourVO.gdTrStts}" 
	          						data-pay-stts="${myApplyTourVO.paymentVO.payStt}"
	          						data-pst-id="${myApplyTourVO.gdTrPstId}" />
	          					</td>
	          					<td>${myApplyTourVO.userVO.usrLnm} ${myApplyTourVO.userVO.usrFnm}</td>
	          					<td id="st">${myApplyTourVO.gdTrStDt}</td>
	          					<c:choose>
			                      	<c:when test="${myApplyTourVO.gdTrStts eq 'RSRVT'}">
			                      		<td>예약 중</td>
			                      	</c:when>
			                      	<c:when test="${myApplyTourVO.gdTrStts eq 'PRG'}">
			                      		<td>투어 진행중</td>
			                      	</c:when>
			                      	<c:when test="${myApplyTourVO.gdTrStts eq 'CMPLT'}">
			                      		<td>투어 완료</td>
			                      	</c:when>
			                      	<c:otherwise>
			                      		<td>모집 중</td>
			                      	</c:otherwise>
			                    </c:choose>
	          					<c:choose>
			                      	<c:when test="${myApplyTourVO.paymentVO.payStt eq 'CANCEL'}">
			                      		<td>결제 취소</td>
			                      	</c:when>
			                      	<c:when test="${myApplyTourVO.paymentVO.payStt eq 'REFUND'}">
			                      		<td>환불</td>
			                      	</c:when>
			                      	<c:when test="${myApplyTourVO.paymentVO.payStt eq 'COMPLETE'}">
			                      		<td>결제 완료</td>
			                      	</c:when>
			                      	<c:otherwise>
			                      		<td>결제 대기중</td>
			                      	</c:otherwise>
			                      </c:choose>
	          					<td>${myApplyTourVO.paymentVO.payCmpltDt}</td>
	          					<td><input id="success-btn" type="button" value="투어 완료" /></td>
          					</tr>
          				</c:forEach>
          				</c:when>
          				<c:otherwise>
          					<tr>
          						<td colspan="7">신청한 투어가 없습니다.</td>
          					</tr>
          				</c:otherwise>
          				</c:choose>
          			</tbody>
          		</table>
          		<ul class="page-nav">
                  <c:if test="${searchMyApplyTourVO.hesprevGroup}">
                    <li>
                      <!-- <a href="/board/list?pageNo=0&listSize=${searchMyBoardVO.listSize}"> -->
                      <a href="javascript:movePage(0)">
                        처음
                      </a>
                    </li>
                    <li>
                      <a href="javascript:movePage(${searchMyApplyTourVO.prevGroupStartPageNo})">
                        이전
                      </a>
                    </li>
                  </c:if>
                  <c:forEach begin="${searchMyApplyTourVO.groupStartPageNo}" end="${searchMyApplyTourVO.groupEndPageNo}"
                    step="1" var="p">
                    <li class="${p eq searchMyApplyTourVO.pageNo ? 'active' : ''}">
                      <!-- a href="/mypage/mytour/gd-mytour/${sessionScope._LOGIN_USER_.usrLgnId}?pageNo=${p}" -->
                      <a href="javascript:movePage(${p})">

                        ${p+1}

                      </a>
                    </li>
                  </c:forEach>
                  <c:if test="${searchMyApplyTourVO.hasNextGroup}">
                    <li>
                      <a href="javascript:movePage(${searchMyApplyTourVO.nextGroupStartPageNo})">
                        다음
                      </a>
                    </li>
                    <li>
                      <a href="javascript:movePage(${searchMyApplyTourVO.pageCount - 1})">
                        끝
                      </a>
                    </li>
                  </c:if>
                </ul>
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