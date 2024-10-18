<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/css/tour_list.css">
</head>

<body>
    <div class="grid">
        <div class="header">
            <!-- 헤더 공통파일 -->
            <jsp:include page="../header.jsp"></jsp:include>
        </div>
        <div class="content">
            <div class="tour-request-list">
                <h1>투어 요청 목록</h1>
            </div>

            <div class="search-zone">
                <div class="search-area">
                    <input type="text" class="search-input" placeholder="검색할 나라 또는 지역을 입력하세요." />
                    <button class="search-button">검색</button>
                </div>
            </div>
            <div class="country-menu-area">
                <div class="checked"><a href="">일본</a></div>
                <div><a href="">동남아</a></div>
                <div><a href="">유럽</a></div>
                <div><a href="">미국</a></div>
                <div><a href="">중국</a></div>
                <div><a href="">그 외</a></div>
            </div>
            <div class="list-view-option">
                <div><a href="">Mate 랭킹순</a></div>
                <div><a href="">높은 가격순</a></div>
                <div><a href="">낮은 가격순</a></div>
                <div><a href="">최신순</a></div>
                <div><a href="">마감 임박순</a></div>
            </div>
            <div class="tour-list-area">
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
                </div>
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
                </div>
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
                </div>
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
                </div>
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
                </div>
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
                </div>
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
                </div>
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
                </div>
                <div class="tour-box">
                    <img class="tour-country-image"
                        src="https://search.pstatic.net/common?src=https://vertical.pstatic.net/vertical/static/travelhome/articleThumbnail/rc-upload-1725346835461-3.jpg&type=w800_travelsearch" />
                    <p class="tour-subject">일본 삿포로 맛집 & 투어여행</p>
                    <p class="tour-comment">삿포로 근교 맛집 , 투어 가이드분 모집합니다.성실하신분 신청해주세요</p>
                    <p class="tour-schedule">일정 : 3박 4일</p>
                    <p class="tour-deadline">마감 3일전</p>
                    <p class="tour-cost">총 가이드 비용</p>
                    <h1 class="tour-fee">300,000원</h1>
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