$().ready(function () {
	var pathname = location.pathname;
	
	var search = location.search;
	
	var nextUrl = "";
	
	if (pathname === "/user/login") {
		nextUrl = "/";
		
	} else {
		nextUrl = pathname + search;
	}
	
	$("input[name=nextUrl]").val(nextUrl);
});