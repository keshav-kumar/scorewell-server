$(document).ready(function () {

    $("#submit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        upload_answer();

    });

});