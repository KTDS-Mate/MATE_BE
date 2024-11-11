$(document).ready(function() {
    var message = $(".container").data("message");
    var messageType = $(".container").data("messageType");

	if (message) {
        if (messageType === "success" || messageType === "error") {
            alert(message);
        }
    }
});
