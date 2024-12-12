$().ready(function() {
	
	// 페이지 로드 될 때 한번만 실행
	const picArea = $(".more-picArea");
	const picRealArea = $(`<div class="picRealArea"></div>`);
	picArea.append(picRealArea);
	const usrTrPstId = $(".ttl-wb").data("pst-id");
	const url = `/usertour/imgs/${usrTrPstId}`;
	$.get(url, {}, function(result) {
		const imgCount = result.imgCnt;
		for (let i = 0; i < imgCount; i++) {
			let imgDom = `<div class="moreImgArea"><img src="${result.imgUrls[i].usrTrRqImgIdUrl}" /></div>`;
			picRealArea.append(imgDom);
		}
	});

	const $picModalArea = $("#picModalArea");
	const $btnOpenPicModal = $(".btn-open-pic-modal");
	const $btnClosePicModal = $(".btn-close-pic-modal");

	function init() {
		// 페이지 로드 시 모달을 닫음
		$picModalArea[0].close();

		// 사진 모달 열기 버튼 클릭
		$btnOpenPicModal.on("click", function() {
			console.log("사진 Modal 열기 버튼 클릭됨.");
			// 사진이 담길 area
			var picArea = $(".picArea");
			// 누른 이미지 url
			var url = $(this).data("img-url");
			picArea.append(`<img src="${url}" alt="확대사진" />`);
			$picModalArea.removeClass("hidden");
			// $('#modalArea').fadeIn();
			// $("body").css("overflow", "hidden");
			$picModalArea[0].showModal();
		});

		// 사진 모달 닫기 버튼 클릭
		$btnClosePicModal.on("click", function() {
			console.log("사진 Modal 닫기 버튼 클릭됨.");
			// 사진이 담긴 area
			var picArea = $(".picArea");
			// 자식 요소 삭제
			picArea.children().remove();
			$picModalArea.addClass("hidden");
			// $('#modalArea').fadeOut();
			// $("body").css("overflow", "auto");
			$picModalArea[0].close();
		});

		$(".plusImgBtn").on('click', function() {
			console.log("더보기 버튼 클릭");

			$("#morepicModalArea").removeClass("hidden");
			$("#morepicModalArea")[0].showModal();
		});
		
		$(".btn-close-more-pic-modal").on('click', function () {
			$("#morepicModalArea").addClass("hidden");
			$("#morepicModalArea")[0].close();
		});
		
	}
	// 초기화 함수 호출
	init();
});