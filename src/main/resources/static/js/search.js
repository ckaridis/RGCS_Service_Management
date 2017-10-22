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

    $(".editVbtn").click(function (){
           var selectorArray = ($(this).attr('id')).split("-");
           var selector = selectorArray[0];

           var vatSelector = "#f2-".concat(selectorArray[0]);
           var vat = $(vatSelector).html();
           alert(vat);

           var brandSelector = "#l2-".concat(selectorArray[0]);
           var brand = $(brandSelector).html();
           alert(brand);

           var modelSelector = "#m2-".concat(selectorArray[0]);
           var model = $(modelSelector).html();
           alert(model);

           var fdSelector = "#o2-".concat(selectorArray[0]);
           var fd = $(fdSelector).html();
           alert(fd);

           var colourSelector = "#p2-".concat(selectorArray[0]);
           var colour = $(colourSelector).html();
           alert(colour);

           var plateSelector = "#r2-".concat(selectorArray[0]);
           var plate = $(plateSelector).html();
           alert(plate);

           var id = selectorArray[0];
           alert(id);

           $(".vehicleid").val(id);
           $("#uservat").val(vat);
           $("#licenseplates").val(plate);
           $("#brand").val(brand);
           $("#model").val(model);
           $("#colour").val(colour);
           $("#factorydate").val(fd);
        })

});