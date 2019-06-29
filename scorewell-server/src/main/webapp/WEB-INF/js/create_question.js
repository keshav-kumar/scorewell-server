$(document).ready(function() {

	$('#datepicker').datepicker({dateFormat: 'dd-mm-yy'}).datepicker('setDate', new Date());
	
	$("#submit").click(function(event) {
		event.preventDefault();
		fire_ajax_submit();

	});

});

function fire_ajax_submit() {

	var form = $('#fileUploadForm')[0];

	var course = $('#course').val();
	var subject = $('#subject').val();
	var setName = $('#setName').val();
	var publishDate = $('#datepicker').val();
	
	var que1 = $('#que1').val();
	var que2 = $('#que2').val();
	var que3 = $('#que3').val();

	var data = new FormData(form);

	data.append("que1", que1);
	data.append("que2", que2);
	data.append("que3", que3);
	
	data.append("course", course);
	data.append("subject", subject);
	data.append("setName", setName);
	data.append("publishDate", publishDate);
	
	alert(course);

	if (que1 === "" || que2 === "" || que3 === "") {
		$("#result").text("Please complete the question set.");
	} else {

		$.ajax({
			type : "POST",
			enctype : 'multipart/form-data',
			url : "/sw/api/create-question-set",
			data : data,
			processData : false,
			contentType : false,
			cache : false,
			timeout : 600000,
			success : function(data) {

				$("#result").text(data);
				console.log("SUCCESS : ", data);
				$("#submit").prop("disabled", true);
			},
			error : function(e) {
				$("#result").text(e.responseText);
				console.log("ERROR : ", e);
				$("#submit").prop("disabled", false);
			}
		});
	}

}