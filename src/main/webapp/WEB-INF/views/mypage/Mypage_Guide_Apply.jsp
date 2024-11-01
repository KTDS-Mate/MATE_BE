<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="stylesheet" type="text/css" href="/css/Mypage_Guide_Apply.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet">
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
          <jsp:include page="../Guide_Sidebar.jsp"></jsp:include>
          <div class="apply-content">
          	<div class="apply-ttl">나의 신청 투어 목록</div>
          	<div class="apply-search-area">
          		<div class="apply-search-zone">
          			<input type="text" placeholder="검색어를 입력해주세요." />
          			<input type="button" value="검색" />
          		</div>
          		<div class="apply-filter-zone">
          			<select>
          				<option>정렬 순서</option>
          				<option>투어 일자 순</option>
          				<option>결제 일자 순</option>
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
          					<th>결제 상태</th>
          					<th>결제 일자</th>
          					<th>투어 완료 선택</th>
          				</tr>
          			</thead>
          			<tbody>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 응가디우</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>야르상</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          				<tr>
          					<td>송다함과 함께 하늘로 야르여행입니당당당당당당.</td>
          					<td>응우옌 똥뿌직쌈</td>
          					<td>24.11.02</td>
          					<td>Complete</td>
          					<td>24.11.06 11:50</td>
          					<td><input type="button" value="투어 완료" /></td>
          				</tr>
          			</tbody>
          		</table>
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