document.addEventListener("DOMContentLoaded", function() {
    // 파일이 선택되면 파일명을 표시
    document.querySelectorAll("input[type='file']").forEach(fileInput => {
        fileInput.addEventListener("change", function(event) {
            const fileLabel = event.target.nextElementSibling;
            const fileName = event.target.files.length > 0 ? event.target.files[0].name : "파일 찾기";
            fileLabel.textContent = fileName;
        });
    });

    // 저장 버튼 클릭 시 빈 라이센스 이름 체크
    const saveButton = document.querySelector(".save-button");
    if (saveButton) {
        saveButton.addEventListener("click", function(event) {
            const licenseNames = document.querySelectorAll("input[type='text']");
            let isValid = true;

            licenseNames.forEach(input => {
                if (input.value.trim() === "") {
                    alert("모든 라이센스 이름을 입력해야 합니다.");
                    isValid = false;
                    return false; // forEach 중단
                }
            });

            if (!isValid) {
                event.preventDefault();
            }
        });
    }
});

// 라이센스 삭제 함수
function deleteLicense(licenseId, licenseName) {
    if (confirm(`정말로 '${licenseName}' 라이센스를 삭제하시겠습니까?"`)) {
        $.ajax({
            url: `/user/deleteLicense/${licenseId}`,
            type: 'DELETE',
            success: function(response) {
                if (response.success) {
                    // 삭제된 항목을 DOM에서 제거
                    const licenseItem = document.querySelector(`.license-item[data-license-id="${licenseId}"]`);
                    if (licenseItem) {
                        licenseItem.remove();
                    }
                    alert("라이센스가 삭제되었습니다.");
					location.reload();
                } else {
                    alert("삭제에 실패했습니다.");
                }
            },
            error: function() {
                alert("삭제 중 오류가 발생했습니다.");
            }
        });
    }
}
// 이미지 미리보기 함
function previewImage(input, previewId) {
    const file = input.files[0];
    const preview = document.getElementById(previewId);

    if (file && file.type.startsWith("image/")) {
        const reader = new FileReader();

        reader.onload = function(e) {
            preview.src = e.target.result;
            preview.style.display = "block"; // 미리보기 이미지 표시
        };

        reader.readAsDataURL(file); // 이미지 파일을 Data URL로 읽어들임
    } else {
        preview.src = "";
        preview.style.display = "none"; // 이미지가 없으면 미리보기 숨김
    }
}

// DOM 설정
document.addEventListener("DOMContentLoaded", function() {
    console.log("DOM 로드 완료");

    // 추가 버튼이 눌리면 라이센스 추가
    const addButton = document.getElementById("add-license-btn");
    if (addButton) {
        console.log("add-license-btn 찾음");
        var licenseIndex = parseInt(addButton.getAttribute("data-license-index"));

        addButton.addEventListener("click", function() {
            console.log("라이센스 추가 버튼 클릭됨");
            addLicense(licenseIndex);
            licenseIndex++;
        });
    }
});

// 라이센스를 추가하는 함수
function addLicense(index) {
    console.log("addLicense 함수 호출");
    const licenseSection = document.getElementById("licenseSection");

    if (licenseSection) {
        const newLicense = document.createElement("div");
        newLicense.classList.add("form-item");
        newLicense.setAttribute("data-license-id", `new-${index}`); // 임시 ID 추가
        newLicense.innerHTML = `
            <label for="license-${index}">라이센스 명</label>
            <input type="text" id="license-${index}" name="licenses[${index}].lcnNm" placeholder="라이센스 명" />
            <button type="button" class="delete-button" onclick="deleteLicense('new-${index}')">삭제</button>
            <div class="form-item">
                <span>라이센스 인증서류</span>
                <div class="filebox">
                    <input type="file" id="lcnImgFile-${index}" name="licenses[${index}].lcnImgFile" class="licenseImg filename" onchange="previewImage(this, 'preview-${index}')" />
                    <label class="file-search" for="lcnImgFile-${index}">파일 찾기</label>
                    <img id="preview-${index}" src="" alt="미리보기" class="img-preview" style="display: none; max-width: 150px; max-height: 150px;"/>
                </div>
            </div>
        `;
        licenseSection.appendChild(newLicense);
    }
}

// 새로 추가된 라이센스를 삭제하는 함수
function deleteLicense(licenseId) {
    if (licenseId && licenseId.startsWith("new-")) {
        // 새로 추가된 항목을 DOM에서 제거
        const newLicenseItem = document.querySelector(`[data-license-id="${licenseId}"]`);
        if (newLicenseItem) {
            newLicenseItem.remove();
            alert("새로 추가된 라이센스가 삭제되었습니다.");
        }
    } else if (licenseId) {
        // 기존 서버에 저장된 라이센스의 경우 AJAX 호출
        if (confirm("정말로 이 라이센스를 삭제하시겠습니까?")) {
            $.ajax({
                url: `/user/deleteLicense/${licenseId}`,
                type: 'DELETE',
                success: function(response) {
                    if (response.success) {
                        // 삭제된 항목을 DOM에서 제거
                        const licenseItem = document.querySelector(`.form-item[data-license-id="${licenseId}"]`);
                        if (licenseItem) {
                            licenseItem.remove();
                        }
                        alert("라이센스가 삭제되었습니다.");
                    } else {
                        alert("삭제에 실패했습니다.");
                    }
                },
                error: function() {
                    alert("삭제 중 오류가 발생했습니다.");
                }
            });
        }
    }
}

// -----------------------------------------------------------------
// ------------------- 프로필 사진 수정 --------------------------------

// 프로필 이미지 미리보기 함수
function previewProfileImage(input) {
    const file = input.files[0];
    const preview = document.getElementById("profilePreview");

    if (file && file.type.startsWith("image/")) {
        const reader = new FileReader();

        reader.onload = function(e) {
            preview.src = e.target.result;
            preview.style.display = "block"; // 미리보기 이미지 표시
        };

        reader.readAsDataURL(file); // 이미지 파일을 Data URL로 읽어들임
		
    } else {
        preview.src = "";
        preview.style.display = "none"; // 이미지가 없으면 미리보기 숨김
    }
}


