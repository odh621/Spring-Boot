$("#tbutton").prop("disabled", true);

$("textarea").on("input", function () {
    if ($(this).val().length > 0) {
        $("#tbutton").prop("disabled", false);
    } else {
        $("#tbutton").prop("disabled", true);
    }
});

