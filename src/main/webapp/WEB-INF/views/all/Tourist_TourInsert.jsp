<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>여행자 투어 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/css/Tourist_TourInsert.css" />
  </head>
  <body>
    <div class="grid">
      <div class="header">
        <!-- header 공통파일 -->
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      <div class="content">
		<div class="insert-main">
			<img alt="메인 이미지" src="/img/tourboard/예시여행이미지.png">
			<div class="all-select-div">
				<div class="select-div">
					투어 지역 선택
				</div>
				<select id="contry">
					<option value="">국가 선택</option>
					<option value="jp">일본</option>
					<option value="tw">대만</option>
					<option value="bn">베트남</option>
					<option value="cn">중국</option>
					<option value="am">미국</option>
					<option value="eg">영국</option>
					<option value="fr">프랑스</option>
					<option value="os">호주</option>
				</select>
				<select id="city">
					<option value="">도시 선택</option>
				</select>
			</div>
			<div class="all-select-div">
				<div class="select-div">
					날짜 선택
				</div>
				<select id="year">
					<option value="">년도 선택</option>
					<option value="2024">2024</option>
					<option value="2025">2025</option>
					<option value="2026">2026</option>
					<option value="2027">2027</option>
					<option value="2028">2028</option>
				</select>
				<select id="month">
					<option value="">월 선택</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>
				<select id="days">
					<option value="">일 선택</option>
				</select>
			</div>
			<div class="all-select-div">
				<div class="select-div">
					시간 선택
				</div>
				<select id="start-hour">
					<option value="">시작 시간 선택</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
				</select>
				<select id="start-minutes">
					<option value="">시작 분 선택</option>
					<option value="0">0</option>
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="20">20</option>
					<option value="25">25</option>
					<option value="30">30</option>
					<option value="35">35</option>
					<option value="40">40</option>
					<option value="45">45</option>
					<option value="50">50</option>
					<option value="55">55</option>
				</select>
				~
				<select id="end-hour">
					<option value="">종료 시간 선택</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
				</select>
				<select id="end-minutes">
					<option value="">종료 분 선택</option>
					<option value="0">0</option>
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="20">20</option>
					<option value="25">25</option>
					<option value="30">30</option>
					<option value="35">35</option>
					<option value="40">40</option>
					<option value="45">45</option>
					<option value="50">50</option>
					<option value="55">55</option>
				</select>
			</div>
			<div class="all-select-div">
				<div class="select-div">
					인원 선택
				</div>
				<input type="number" value="1"/>
			</div>
			<div class="all-select-div">
				<div class="select-div">
					투어 목적
				</div>
				<textarea></textarea>
			</div>
			<div class="all-select-div">
				<div class="select-div">
					투어 희망 정보
				</div>
				<div>
					<label for="hope-location">장소</label>
					<input id="hope-location" type="text"/>
				</div>
				<div>
					<label for="hope-info">일정</label>
					<input id="hope-info" type="text"/>
				</div>
				<div>
					<button>일정 추가하기</button>
				</div>
			</div>
			<div class="all-select-div">
				<div class="select-div">
					투어 세부 요구사항
				</div>
				<textarea></textarea>
			</div>
			<div class="all-select-div">
				<div class="select-div">
					집결 장소 선택 / 투어 이미지 추가
				</div>
				<input type="number" value="1"/>
			</div>
			<div class="all-select-div">
				<div class="select-div">
					원하는 가이드
				</div>
				<div>
					<label for="gender">성별</label>
					<select id="gender">
						<option value="">성별 선택</option>
						<option value="male">남자</option>
						<option value="female">여자</option>
					</select>
				</div>
				<div>
					<label for="age">나이</label>
					<select id="age">
						<option value="">나이 선택</option>
						<option value="male">남자</option>
						<option value="female">여자</option>
					</select>
				</div>
				<div>
					<label for="gender">성별</label>
					<select id="gender">
						<option value="">성별 선택</option>
						<option value="male">남자</option>
						<option value="female">여자</option>
					</select>
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
