function showHidePanel() {
    if ($("#role :selected").text() == "Администратор") {
//    if ($("#microchipTattoo").is(':checked')) {
        $(".empolyeePanel").hide(1000);
        $(".adminPanel").first().show("fast", function showNext() {
            $(this).next(".adminPanel").show("fast", showNext);
        });
    }
    else {
        $(".adminPanel").hide(1000);
        $(".empolyeePanel").first().show("fast", function showNext() {
            $(this).next(".empolyeePanel").show("fast", showNext);
        });
    }
}