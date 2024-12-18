$().ready(function() {
	
    $('.btnbtn').on("click", function(){
        if (confirm("예약하시겠습니까?")){
            alert("예약되었습니다.");
            location.href = "/guidetour/list";
        }
        
    });
	
});