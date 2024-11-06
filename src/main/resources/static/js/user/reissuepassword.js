$().ready(function() {
	console.log("!");
    var message = $(".container").data("message");
    var messageType = $(".container").data("messageType");

    if (message) {
        if (messageType === "success") {
            alert(message);
        } else if (messageType === "error") {
            alert(message);
        }
    }
});
