$(document).ready(function (){

       $("#edit_btn").click(function (){
       var vat = $("#f1").html();
       var fname = $("#l1").html();
       var lname = $("#m1").html();
       var email = $("#o1").html();
       var password = $("#p1").html();
       var address = $("#q1").html();
       var type = $("#r1").html();
       var id = $("#s1").html();

       $("#id").val(id);
       $("#vat").val(vat);
       $("#firstname").val(fname);
       $("#lastname").val(lname);
       $("#email").val(email);
       $("#password").val(password);
       $("#confirmpassword").val(password);
       $("#address").val(address);
       $("#type").val(type);
    })

});