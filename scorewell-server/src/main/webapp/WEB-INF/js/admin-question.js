//$(document).ready(function () {
//
//    $(".delete_button").click(function (event) {
//
//        //stop submit the form, we will post it manually.
//        event.preventDefault();
//
//        alert("Delete Called "+$('.delete_button').val()+" :: "+$('#deleteQueSet').val());
//        		
//        		
//        $.ajax({
////			type : "GET",
//			url : '/sw/api/delete-question-set?setname='+$('#setname').val(),
//			contentType: "application/json",
//	        dataType: 'json',
//			success : function(response) {
//				location.reload(); 
////				$('#subscribeResult').html(response);
//			},
//		});
//        
//        
//        
//        location.reload(); 
//
//    });
//
//});