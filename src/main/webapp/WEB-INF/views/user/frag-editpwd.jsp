<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <h2>비밀번호 변경</h2>
    <form id="pwdChangeForm" method="post" action="/user/editpwd" class="password-update-form">
        <!-- 현재 비밀번호 입력 필드 -->
        <div class="form-group">
            <label for="currentPwd">현재 비밀번호</label>
            <input type="password" id="currentPwd" name="currentPwd" placeholder="현재 비밀번호를 입력하세요." required />
            <div class="error" id="currentPwd-error"></div>
        </div>

        <!-- 새 비밀번호 입력 필드 -->
        <div class="form-group">
            <label for="newPwd">새 비밀번호</label>
            <input type="password" id="newPwd" name="newPwd" placeholder="새 비밀번호를 입력하세요." required />
            <div class="error" id="newPwd-error"></div>
        </div>

        <!-- 새 비밀번호 확인 입력 필드 -->
        <div class="form-group">
            <label for="confirmPwd">새 비밀번호 확인</label>
            <input type="password" id="confirmPwd" name="confirmPwd" placeholder="새 비밀번호를 한번 더 입력하세요." required />
            <div class="error" id="confirmPwd-error"></div>
        </div>

        <div class="form-group">
            <button type="submit" class="submit-btn">비밀번호 변경</button>
        </div>
    </form>
</div>