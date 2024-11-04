document.addEventListener("DOMContentLoaded", function() {
	
	var licenseIndex = parseInt(document.getElementById("license-container").getAttribute("data-license-index")) || 0;

    function addLicenseItem() {
        var additionalLicensesDiv = document.getElementById("additionalLicenses");

        var licenseDiv = document.createElement("div");
        licenseDiv.className = "license-form";

        var imageDiv = document.createElement("div");
        imageDiv.className = "license-image";
        var img = document.createElement("img");
        img.src = "img/certificate-placeholder.png";
        img.alt = "자격증 이미지";
        imageDiv.appendChild(img);

        var uploadDiv = document.createElement("div");
        uploadDiv.className = "upload-button";
        var label = document.createElement("label");
        label.setAttribute("for", "lcnImgFile-" + licenseIndex);
        label.textContent = "사진 등록";
        var inputFile = document.createElement("input");
        inputFile.type = "file";
        inputFile.name = "licenses[" + licenseIndex + "].lcnImgFile";
        inputFile.id = "lcnImgFile-" + licenseIndex;
        uploadDiv.appendChild(label);
        uploadDiv.appendChild(inputFile);

        var inputNameDiv = document.createElement("div");
        inputNameDiv.className = "form-item";
        var inputName = document.createElement("input");
        inputName.type = "text";
        inputName.name = "licenses[" + licenseIndex + "].lcnNm";
        inputName.placeholder = "자격증 이름을 입력하세요.";
        inputNameDiv.appendChild(inputName);

        var deleteButton = document.createElement("button");
        deleteButton.type = "button";
        deleteButton.className = "delete-button";
        deleteButton.textContent = "삭제";
        deleteButton.onclick = function() { 
			removeLicenseItem(deleteButton); 
		};

        licenseDiv.appendChild(imageDiv);
        licenseDiv.appendChild(uploadDiv);
        licenseDiv.appendChild(inputNameDiv);
        licenseDiv.appendChild(deleteButton);

        additionalLicensesDiv.appendChild(licenseDiv);

        licenseIndex++;
    }

    function removeLicenseItem(button) {
        var licenseForm = button.parentNode;
        licenseForm.parentNode.removeChild(licenseForm);
    }

    // 이벤트 핸들러 설정
    document.querySelector(".register-button").addEventListener("click", addLicenseItem);
});
