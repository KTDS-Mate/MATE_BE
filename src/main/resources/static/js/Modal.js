$().ready(function() {

	// 페이지 로드 될 때 한번만 실행
	const picArea = $(".more-picArea");
	const picRealArea = $(`<div class="picRealArea"></div>`);
	picArea.append(picRealArea);
	const gdTrPstId = $(".ttl-wb").data("gd-pst-id");
	const url = `/guidetour/imgs/${gdTrPstId}`;
	$.get(url, {}, function(result) {
		const imgCount = result.imgCnt;
		for (let i = 0; i < imgCount; i++) {
			let imgDom = `<div class="moreImgArea"><img src="${result.imgUrls[i].gdTrImgUrl}" /></div>`;
			picRealArea.append(imgDom);
		}
	});



	const $picModalArea = $("#picModalArea");
	const $btnOpenPicModal = $(".btn-open-pic-modal");
	const $btnClosePicModal = $(".btn-close-pic-modal");

	const $reviewModal = $("#reviewModalArea");
	const $btnOpenReviewModal = $(".btn-open-review-modal");
	const $btnCloseReviewModal = $(".btn-close-review-modal");
	const $btnSubmitReview = $(".btn-submit-review");

	const $reviewListModal = $("#viewAllReviewModal");
	const $btnOpenReviewListModal = $(".btn-open-review-list-modal");
	const $btnCloseReviewListModal = $(".btn-close-review-list-modal");

	function init() {
		// 페이지 로드 시 모달을 닫음
		$reviewModal[0].close();
		$picModalArea[0].close();
		$reviewListModal[0].close();

		// 리뷰 모달 열기 버튼 클릭
		$btnOpenReviewModal.on("click", function() {
			console.log("사진 Modal 열기 버튼 클릭됨.");
			$reviewModal.removeClass("hidden");
			// $('#modalArea').fadeIn();
			// $("body").css("overflow", "hidden");
			$reviewModal[0].showModal();
		});

		// 리뷰 모달 닫기 버튼 클릭
		$btnCloseReviewModal.on("click", function() {
			console.log("사진 Modal 닫기 버튼 클릭됨.");
			$reviewModal.addClass("hidden");
			// $('#modalArea').fadeOut();
			// $("body").css("overflow", "auto");
			$reviewModal[0].close();
		});

		// 리뷰 등록 버튼 클릭
		$btnSubmitReview.on("click", function() {
			console.log("리뷰 등록 버튼 클릭됨.");
			$reviewModal.addClass("hidden");
			// $('#modalArea').fadeOut();
			// $("body").css("overflow", "auto");
			alert("리뷰 작성이 완료되었습니다.");
			$reviewModal[0].close();
		});

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

		$(".btn-close-more-pic-modal").on('click', function() {
			$("#morepicModalArea").addClass("hidden");
			$("#morepicModalArea")[0].close();
		});

		// 리뷰 리스트 모달 열기 버튼 클릭
		$btnOpenReviewListModal.on("click", function() {
			console.log("사진 Modal 열기 버튼 클릭됨.");
			$reviewListModal.removeClass("hidden");
			// $('#modalArea').fadeIn();
			// $("body").css("overflow", "hidden");
			$reviewListModal[0].showModal();
		});

		// 리뷰 리스트 모달 닫기 버튼 클릭
		$btnCloseReviewListModal.on("click", function() {
			console.log("사진 Modal 닫기 버튼 클릭됨.");
			$reviewListModal.addClass("hidden");
			// $('#modalArea').fadeOut();
			// $("body").css("overflow", "auto");
			$reviewListModal[0].close();
		});
	}

	// 별점 클릭 이벤트
	$(".starRating > .starThree").click(function() {
		// 'on' 클래스를 초기화하고, 클릭한 요소와 그 이전 요소에 'on' 클래스를 추가
		$(this).parent().children(".starThree").removeClass("on"); // span이 아니라 .star 클래스 선택
		$(this).addClass("on").prevAll(".starThree").addClass("on"); // span 대신 .star 사용
		var starCnt = $(".on").length;
		console.log(starCnt);
		$("#starCnt").val(starCnt);

	});

	// 초기화 함수 호출
	init();
});