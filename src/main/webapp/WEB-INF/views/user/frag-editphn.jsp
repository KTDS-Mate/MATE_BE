<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<h2>휴대폰 번호 변경</h2>
		<form id="editPhoneForm" method="post" action="/user/editphone" class="phone-update-form">
	
		<!-- 새 휴대전화번호 입력 필드 -->
		<div class="form-group">
			<label for="newPhn">새 휴대전화번호</label>
			<input type="tel" id="newPhn" name="newPhn" placeholder="새 휴대전화번호를 입력하세요." required />
			<div class="error error-message" id="newPhn-error"></div>
		</div>
		<div class="form-group">
			<button type="submit" class="submit-btn">휴대전화번호 수정</button>
		</div>
	</form>