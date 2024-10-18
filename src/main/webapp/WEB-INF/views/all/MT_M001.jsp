<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Mypage_Tourist_MyTour</title>
    <link
            rel="stylesheet"
            type="text/css"
            href="/css/MT_M001.css"
    />
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
        <div class="userSelectArea">
            <div class="tourist-guide">
                <div class="tourist">여행객</div>
                <div class="guide">가이드</div>
            </div>
            <div class="where">
                <h2>Where</h2>
                <p></p>
                <h3>Tokyo</h3>
            </div>
            <div class="when">
                <h2>When</h2>
                <div class="whenSelectArea">
                    <h3>24.09.05</h3>
                    <img src="/public/자리교체.png" alt="Switch">
                    <h3>24.09.12</h3>
                </div>
            </div>
            <div class="adult">
                <h2>Adult</h2>
                <h3>2</h3>
            </div>
            <div class="child">
                <h2>Child</h2>
                <h3>1</h3>
            </div>
            <div class="makeTourButton">
                Make Tour
            </div>
        </div>


        <div class="recommendTourAreaOne">
            <img class="forward" src="public/forward.png">
            <div class="firstRecommendTour">
                <img src="public/로마.jpg">
                <h1>로마</h1>
            </div>
            <div class="secondRecommendTour">
                <img src="public/일본.jpg">
                <h1>도쿄</h1>
            </div>
            <div class="thirdRecommendTour">
                <img src="public/파리.jpg">
                <h1>파리</h1>
            </div>
            <div class="fourthRecommendTour">
                <img src="public/다낭.jpg">
                <h1>다낭</h1>
            </div>
            <img class="backward" src="public/backward.png">
        </div>

        <div class="recommendTourAreaTwo">
            <h1>가이드를 직접 선택한 여행자들의 생생한 후기!</h1>
            <div class="recommendTourContainer">
                <img src="public/forward.png">
                <div class="recommendTourItem">
                    <img src="public/로마.jpg">
                    <h1>로마</h1>
                </div>
                <div class="recommendTourItem">
                    <img src="public/일본.jpg">
                    <h1>도쿄</h1>
                </div>
                <div class="recommendTourItem">
                    <img src="public/파리.jpg">
                    <h1>파리</h1>
                </div>
                <div class="recommendTourItem">
                    <img src="public/다낭.jpg">
                    <h1>다낭</h1>
                </div>
                <img src="public/backward.png">
            </div>
            <h3>1 | 3</h3>
        </div>

        <div class="recommendTourAreaThree">
            <h1>금강산도 식후경! 식도락 투어 코스!</h1>
            <div class="recommendTourContainer">
                <img src="public/forward.png">
                <div class="recommendTourItem">
                    <img src="public/로마.jpg">
                    <h1>로마</h1>
                </div>
                <div class="recommendTourItem">
                    <img src="public/일본.jpg">
                    <h1>도쿄</h1>
                </div>
                <div class="recommendTourItem">
                    <img src="public/파리.jpg">
                    <h1>파리</h1>
                </div>
                <div class="recommendTourItem">
                    <img src="public/다낭.jpg">
                    <h1>다낭</h1>
                </div>
                <img src="public/backward.png">
            </div>
            <h3>1 | 3</h3>
        </div>
    </div>
    <div class="footer">
        <!-- footer 공통파일 -->
        <jsp:include page="../footer.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
