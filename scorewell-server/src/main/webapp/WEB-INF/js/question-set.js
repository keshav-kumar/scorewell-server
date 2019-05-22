$(document).ready(function () {

    $("#submit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    // Get form
    var form = $('#fileUploadForm')[0];

    var name = $('#name').val();
    var phone = $('#phone').val();
    var email = $('#email').val();
    
    var data = new FormData(form);
    
	data.append("name", name);
	data.append("phone", phone);
	data.append("email", email);

    if(name ==="" || phone === "" || email === ""){
    	$("#result").text("please fille the data.");
    }else{
    
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: '/sw/api/upload-answer',
        data: data,
        
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            $("#result").text(data);
            console.log("SUCCESS : ", data);
            $("#submit").prop("disabled", true);

        },
        error: function (e) {

            $("#result").text("Error:Something went wrong.");
            console.log("ERROR : ", e);
            $("#submit").prop("disabled", false);

        }
    });
    
    }

}