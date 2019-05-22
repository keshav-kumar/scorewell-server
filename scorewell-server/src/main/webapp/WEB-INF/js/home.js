
$(document).ready(function() {
	
	$('#submit').click(function(e) {
		e.preventDefault();
		$.ajax({
			type : "POST",
			url : '/sw/save-subscriber',
			data : {
				userName : $('#subscrib_email').val()
			},
			success : function(response) {
				$('#subscribeResult').html(response);
			},
		});
	});
});