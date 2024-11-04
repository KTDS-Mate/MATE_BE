$().ready(function () {
  $("#profile").on("change", function () {
    var fileName = $("#profile").val();
    $("input.profile").val(fileName);
  });

  $("#idcard-img").on("change", function () {
    var fileName = $("#idcard-img").val();
    $("input.idcard-img").val(fileName);
  });

  $("#license").on("change", function () {
    var fileName = $("#license").val();
    $("input.license").val(fileName);
  });
});
