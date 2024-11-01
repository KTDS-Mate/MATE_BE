<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>가이드 등록</title>
    <link rel="stylesheet" type="text/css" href="/css/guideregist.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/user/loadcities.js"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet" />

  </head>
  <body>
    <div class="grid">
      <div class="header">
        <jsp:include page="../header.jsp"></jsp:include>
      </div>
      
      <div class="content">
        <div class="main-content">
          <div class="content-title">
            <div><h2>가이드 등록</h2></div>
          </div>
          <form:form modelAttribute="registGuideVO" method="post" class="regist-form" enctype="multipart/form-data">
            <div class="regist-content">
              
              <!-- 인적 사항 -->
              <div class="section-box">
                <div class="sub-title">인적 사항</div>
                
                <div class="form-item">
                  <span>성</span>
                  <span><c:out value="${registGuideVO.usrLnm}" /></span>
                </div>
                
                <div class="form-item">
                  <span>이름</span>
                  <span><c:out value="${registGuideVO.usrFnm}" /></span>
                </div>
                
                <div class="form-item">
                  <span>성별</span>
                  <span><c:out value="${registGuideVO.usrGndr}" /></span>
                </div>
                
                <div class="form-item">
                  <span>생년월일</span>
                  <span><c:out value="${registGuideVO.usrBd}" /></span>
                </div>
                
                <div class="form-item">
                  <span>휴대전화번호</span>
                  <span><c:out value="${registGuideVO.usrPhn}" /></span>
                </div>
                
                <div class="form-item">
                  <span>이메일</span>
                  <span><c:out value="${registGuideVO.usrEml}" /></span>
                </div>
                
                <div class="form-item">
                  <span>대표 국적</span>
                  <span><c:out value="${registGuideVO.countryName}" /></span>
                </div>
                
                <div class="form-item">
                  <span>프로필 사진</span>
                  <div class="filebox">
                     <input type="file" id="gdPrflImgFile" name="gdPrflImgFile" />
                     <label class="file-search" for="gdPrflImgFile">파일 찾기</label>
                  </div>
                </div>
                
                <div class="self-int">
                  <label for="usrSlfIntdctn">자기소개</label>
                  <form:textarea path="usrSlfIntdctn" id="usrSlfIntdctn"></form:textarea>
                </div>
                
                <div class="active-area">
                	<div class="form-item">
                		<label for="active-area">활동 지역</label>
                	</div>
                	
					<div class="form-item">
						<label for="active-country">활동 국가 선택</label>
						<form:select path="gdRpCntId" id="gdRpCntId" onchange="loadCities(this.value)">
							<form:option value="">국가를 선택하세요.</form:option>
					    	<c:forEach items="${countriesList}" var="country">
								<form:option value="${country.countryId}">${country.countryName}</form:option>
							</c:forEach>
						</form:select>
					</div>
				
					<div class="form-item">
						<label for="active-city">활동 도시 선택</label>
						<div class="custom-select-box">
							<div class="custom-select-box">
								<div class="selected-option" onclick="toggleDropdown()">도시를 선택하세요</div>
								<ul id="customDropdown" class="dropdown-list hidden">
									<li class="placeholder-option" onclick="selectCity('', '도시를 선택하세요')">도시를 선택하세요</li>
								</ul>
							</div>
						<button type="button" class="plus-item" onclick="addCity()">지역 추가</button>
					</div>
					<div id="cityInputs"></div>
				
					<div class="form-item selected-cities">
						<ul id="addedCitiesList"></ul>
					</div>
				</div>
				</div>
				
                <div class="form-item">
                  <span>신분증 사본</span>
                  <div class="filebox">
                    <form:input path="gdIdImgFile" type="file" id="gdIdImgFile" class="idcard-img filename" placeholder="(jpg, png, pdf...)" />
                    <label class="file-search" for="gdIdImgFile">파일찾기</label>
                  </div>
                </div>
                
              <div class="form-item">
                  <span>범죄경력 조회서</span>
                  <div class="filebox">
                    <form:input path="gdCbcImgFile" type="file" id="gdCbcImgFile" class="idcard-img filename" placeholder="(jpg, png, pdf...)" />
                    <label class="file-search" for="gdCbcImgFile">파일찾기</label>
                  </div>
             </div>
                
             
              <!-- 자격요건 -->
              <div class="section-box">
                <div class="sub-title">자격요건</div>
                
                <div class="form-item">
                <label for=license-0>라이센스 명</label>
                	<div class="license">
               			<form:input path="licenses[0].lcnNm" id="license-0" placeholder="라이센스 명" />
               		</div>
                </div>
                
                <div class="form-item">
                  <span>라이센스 인증서류</span>
                  <div class="filebox">
                    <form:input type="file" path="licenses[0].lcnImgFile" id="lcnImgFile-0" class="licenseImg filename" placeholder="(jpg, png, pdf..)" />
                    <label class="file-search" for="licenseImg-0">파일 찾기</label>
                  </div>
                </div>
                
                <!-- 라이센스 추가 버튼 -->
                <div class="license-plus-btn">
                  <button type="button" onclick="addLicenseItem()">라이센스 추가</button>
                </div>
                
                <!-- 추가 라이센스 컨테이너 -->
                <div id="additionalLicenses"></div>
                
              </div>

              <!-- 정산 정보 -->
              <div class="section-box">
                <div class="sub-title">정산 정보</div>
                <div class="form-item">
                  <span>PayPal Email 주소</span>
                  <div class="filebox">
                    <form:input path="usrPypEml" class="license filename" placeholder="PayPal Email 주소 입력" />
                  </div>
                </div>
              </div>

	            <div class="select-btn">
	              <button type="submit" class="regist-button">신청</button>
	              <button type="button" class="cancel-button">취소</button>
	            </div>
              
            </div>
        </div>
        </form:form>
      </div>
      </div>
      <div class="footer">
        <jsp:include page="../footer.jsp"></jsp:include>
     </div>
     </div>
  </body>
</html>
