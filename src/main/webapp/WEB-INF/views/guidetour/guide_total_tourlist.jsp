<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Mypage_Tourist_MyTour</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="/css/guidetour/guide_total_tourlist.css" />
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
	rel="stylesheet">
<script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="/js/guidetour/guidetourlist.js"></script>
</head>

<body>
	<div class="grid">
		<!--  -->
		<div class="header">
			<!-- 헤더 공통파일 -->
			<jsp:include page="../header.jsp"></jsp:include>
		</div>
		<!--  -->

		<div class="content">
			<div class="search-title">
				<h1>가이드 투어 목록</h1>
				<div class="search-zone">
					<form class="search-form">
						<input id="search-val-3" type="hidden" name="regionName"
							value="${searchGuideTourVO.regionName}" /> <input
							id="search-val-4" type="hidden" name="orderBy"
							value="${searchGuideTourVO.orderBy}" /> <input type="hidden"
							name="pageNo" class="page-no" value="${searchGuideTourVO.pageNo}" />
						<div class="search-area">
							<select class="search-type" name="searchType">
								<option value="region"
									${"region" eq searchGuideTourVO.searchType ? "selected" : ""}>대륙</option>
								<option value="country"
									${"country" eq searchGuideTourVO.searchType ? "selected" : "" }>국가</option>
								<option value="city"
									${"city" eq searchGuideTourVO.searchType ? "selected" : "" }>도시</option>
								<option value="title"
									${"title" eq searchGuideTourVO.searchType ? "selected" : "" }>제목</option>
							</select> <input type="text" class="search-input" name="searchKeyword"
								placeholder="찾고싶은 나라를 입력하세요."
								value="${searchGuideTourVO.searchKeyword}" />
							<button class="search-button">검색</button>
						</div>
					</form>
				</div>
			</div>
			<div class="region-menu-area">
				<!--   선택한 대륙이 바뀌어도 값을 가져가기 위해 hidden에 담아둔다-->
				<input id="region-hide" type="hidden"
					value="${searchGuideTourVO.regionName}" /> <input id="all"
					class="${searchGuideTourVO.regionName eq '전체' ? 'checked' : ''} "
					type="button" value="전체" /> <input id="asia"
					class="${searchGuideTourVO.regionName eq '아시아' ? 'checked' : ''} "
					type="button" value="아시아" /> <input id="eu"
					class="${searchGuideTourVO.regionName eq '유럽' ? 'checked' : ''} "
					type="button" value="유럽" /> <input id="ose"
					class="${searchGuideTourVO.regionName eq '오세아니아' ? 'checked' : ''} "
					type="button" value="오세아니아" /> <input id="n-ame"
					class="${searchGuideTourVO.regionName eq '북아메리카' ? 'checked' : ''} "
					type="button" value="북아메리카" /> <input id="s-ame"
					class="${searchGuideTourVO.regionName eq '남아메리카' ? 'checked' : ''} "
					type="button" value="남아메리카" /> <input id="af"
					class="${searchGuideTourVO.regionName eq '아프리카' ? 'checked' : ''} "
					type="button" value="아프리카" />
			</div>
			<div class="flex-list-insert-btn">
				<div class="list-view-option">
					<div class="input-option">
						<input id="latest"
							class="${searchGuideTourVO.orderBy eq '최신순' ? 'checked2' : '' }"
							type="button" value="최신순" />
					</div>
					<div class="input-option">
						<input id="high-price"
							class="${searchGuideTourVO.orderBy eq '높은 가격순' ? 'checked2' : ''}"
							type="button" value="높은 가격순" />
					</div>
					<div class="input-option">
						<input id="row-price"
							class="${searchGuideTourVO.orderBy eq '낮은 가격순' ? 'checked2' : ''}"
							type="button" value="낮은 가격순" />
					</div>
					<div class="input-option">
						<input id="deadline"
							class="${searchGuideTourVO.orderBy eq '마감 임박순' ? 'checked2' : '' }"
							type="button" value="마감 임박순" />
					</div>
					<div class="input-option">
						<input id="high-rating"
							class="${searchGuideTourVO.orderBy eq '평점 높은순' ? 'checked2' : ''}"
							type="button" value="평점 높은순" />
					</div>
				</div>
				<c:if
					test="${not empty sessionScope._LOGIN_USER_ && sessionScope._LOGIN_USER_.usrIsGd eq 'Y'}">
					<div class="button" onclick="javascript:moveInsert();">
						<p class="btnText">투어 등록</p>
						<div class="btnTwo">
							<p class="btnText2">GO!</p>
						</div>
					</div>
				</c:if>
			</div>
			<div class="my-tour">
				<c:choose>
					<c:when test="${not empty guideTourListVO.guideTourList}">
						<c:forEach items="${guideTourListVO.guideTourList}"
							var="guideTourVO">
							<div class="tour-box">
								<input class="hide" type="hidden"
									data-gdpst-id="${guideTourVO.gdTrPstId}" />
								<div class="img-box">
									<c:choose>
										<c:when
											test="${not empty guideTourVO.guideTourImgList && not empty guideTourVO.guideTourImgList[0].gdTrImgUrl}">
											<div class="tour-img">
												<img src="${guideTourVO.guideTourImgList[0].gdTrImgUrl}" />
											</div>
										</c:when>
										<c:otherwise>
											<div class="tour-img">
												<img src="/img/tourboard/기본이미지.png" alt="mate 기본이미지" />
											</div>
										</c:otherwise>
									</c:choose>
								</div>
								<div class="tour-box-content">
									<div class="tour-contents">
										<div class="rating-ttl">
											<div class="rating-area">
												<img class="star-icon"
													src="https://img.freepik.com/premium-vector/shiny-golden-star-icon-yellow-stars-glossy-colors-vector-illustration_230920-3112.jpg">
												<c:choose>
													<c:when test="${not empty guideTourVO.avgRvw}">
														<h5 class="averageRating">${guideTourVO.avgRvw}</h5>
													</c:when>
													<c:otherwise>
														<h5 class="averageRating">0</h5>
													</c:otherwise>
												</c:choose>
											</div>
											<h3>${guideTourVO.gdTrTtl}</h3>
											<p class="tour-contents-text">${guideTourVO.gdTrSmry}</p>
										</div>
										<div class="tour-contents-info">
											<div class="asd">
												<div class="tour-contents-text">
													<span>가이드 :</span> ${guideTourVO.userVO.usrLnm}
													${guideTourVO.userVO.usrFnm}
												</div>
												<div class="tour-contents-text">
													<span>최대인원 :</span> ${guideTourVO.gdTrMxNp}명
												</div>
												<div class="tour-contents-text">
													<span>가이드 평점 :</span> ${guideTourVO.avgGdRvw}
												</div>
											</div>
											<div class="asd">
												<div class="tour-contents-ctr">
													${guideTourVO.citiesVO.cityName} /
													${guideTourVO.countriesVO.countryName}</div>
												<div class="tour-time">
													<img class="clock-img" alt="시계"
														src="/img/tourboard/ClockImage.png">
													${userTourVO.usrTrTm} ${guideTourVO.gdTrStDt} <img
														class="inline-margin" src="/img/tourboard/~.png" />
													${guideTourVO.gdTrEdDt}
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="tour-box-right-content">
									<div class="tour-contents-prc">
										<h2>
											<span>$</span>${guideTourVO.gdTrPrc}</h2>
									</div>
									<div class="tour-right-info"></div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="isempty">검색 결과가 없습니다.</div>
					</c:otherwise>
				</c:choose>
			</div>
			<!-------------------------------------------------------------->
			<div class="page-area">
				<ul class="page-nav">
					<c:if test="${searchGuideTourVO.hesprevGroup}">
						<li><a
							href="javascript:movepage(${searchGuideTourVO.prevGroupStartPageNo});">
								&lt; </a></li>
					</c:if>
					<c:forEach begin="${searchGuideTourVO.groupStartPageNo}"
						end="${searchGuideTourVO.groupEndPageNo}" step="1" var="p">
						<li class="${p eq searchGuideTourVO.pageNo ? 'active' : ''}">
							<a
							href="/guidetour/list?pageNo=${p}&listSize=${searchGuideTourVO.listSize}">
								${p + 1} </a>
						</li>
					</c:forEach>
					<c:if test="${searchGuideTourVO.hasNextGroup}">
						<li><a
							href="javascript:movepage(${searchGuideTourVO.nextGroupStartPageNo});">
								&gt; </a></li>
					</c:if>
				</ul>
			</div>
		</div>

		<div class="footer">
			<!-- footer 공통파일 -->
			<jsp:include page="../footer.jsp"></jsp:include>
		</div>
	</div>
</body>

</html>