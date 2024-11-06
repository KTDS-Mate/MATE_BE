<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>활동 지역 수정</title>
    <link rel="stylesheet" type="text/css" href="/css/mypage/editLocation.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/editLocation.js"></script>
</head>
<body>
<div class="location-edit">
    <h2>활동 지역 수정</h2>

    <!-- 활동 국가 선택 -->
    <div class="form-item">
        <label for="country-select">활동 국가</label>
        <form:select path="selectedCountry" id="country-select" onchange="loadCities(this.value)">
            <form:option value="">국가를 선택하세요</form:option>
            <c:forEach items="${countriesList}" var="country">
                <form:option value="${country.countryId}">${country.countryName}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <!-- 활동 도시 선택 -->
    <div class="form-item">
        <label for="city-select">활동 도시</label>
        <div class="custom-select-box">
            <div class="selected-option" onclick="toggleDropdown()">도시를 선택하세요</div>
            <ul id="city-dropdown" class="dropdown-list hidden">
                <li class="placeholder-option" onclick="selectCity('', '도시를 선택하세요')">도시를 선택하세요</li>
            </ul>
        </div>
        <button type="button" class="add-city-btn" onclick="addCity()">도시 추가</button>
    </div>

    <!-- 선택된 도시 목록 -->
    <div id="selectedCitiesList" class="selected-cities">
        <ul id="addedCitiesList"></ul>
    </div>

    <!-- 제출 버튼 -->
    <form:form modelAttribute="locationUpdateVO" method="post">
        <div id="cityInputs"></div>
        <button type="submit" class="submit-btn">저장</button>
    </form:form>
</div>
</body>
</html>
