// JavaScript Document

$( document ).ready(function() {
    var thisHeight = window.innerHeight;
	document.getElementById("page_wrapper").style.height = thisHeight + 'px';
	
	$("form[name='loginForm']").validate({
		rules : {
			uname : {
				required : true,
				minlength : 9,
                maxlength : 9
			},
			psw : {
				required : true,
				minlength : 10,
				maxlength : 10
			}
		},
		messages : {
			uname : {
				required : "Please enter an email",
                minlength: "Must be 9 digits"
			},
			psw : {
				required : "Please enter a password",
				minlength : "Password must be 10 characters long",
				maxlength : "Password must be 10 characters long"
			}
		},//end of messages
		submitHandler: function(form) {form.submit();}
	})
});