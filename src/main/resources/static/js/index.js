// JavaScript Document

$( document ).ready(function() {
    var thisHeight = window.innerHeight;
	document.getElementById("page_wrapper").style.height = thisHeight + 'px';
	
	$("form[name='loginForm']").validate({
		rules : {
			email : {
				required : true,
				email : true
			},
			password : {
				required : true,
				minlength : 6,
				maxlength : 15
			}
		},
		messages : {
			email : {
				required : "Please enter an email",
				email : "Please enter a valid email address"
			},
			password : {
				required : "Please enter a password",
				minlength : "Password must be 6 characters min",
				maxlength : "Password must be 15 characters max"
			}
		},//end of messages
		submitHandler: function(form) {form.submit();}
	})
});