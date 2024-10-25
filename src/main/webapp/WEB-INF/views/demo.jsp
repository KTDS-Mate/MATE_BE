<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<div%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>

		<body>

			<c:choose>
				<c:when test="${empty sessionScope._LOGIN_USER_}">
					<div>
						<a href="/member/login">로그인</a>
					</div>
					<div>
						<a href="/member/regist">회원가입</a>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						${sessionScope._LOGIN_USER_.name}
						(${sessionScope._LOGIN_USER_.email})
					</div>
					<div>
						<a href="/mypage/mytour/gd-mytour">로그아웃</a>
					</div>
					<div>
						<a href="/mypage/mytour/gd-mytour">마이페이지</a>
					</div>
				</c:otherwise>
			</c:choose>


			<div class="right-align">
				<ul class="horizontal-list member-menu" data-email="${sessionScope._LOGIN_USER_.email}">
					<c:choose>
						<c:when test="${empty sessionScope._LOGIN_USER_}">
							<li>
								<a href="/member/regist">회원가입</a>
							</li>
							<li>
								<a href="/member/login">로그인</a>
							</li>
						</c:when>
						<c:otherwise>
							<li>
								${sessionScope._LOGIN_USER_.name}
								(${sessionScope._LOGIN_USER_.email})
							</li>
							<li>
								<a href="/member/logout">로그아웃</a>
							</li>
							<li>
								<a href="/member/delete-me">탈퇴</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</body>

		</html>