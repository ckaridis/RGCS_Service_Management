$(document).ready(function (){

       var vehicle = new Map();

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

 $(".editRbtn").click(function (){
           var selectorArray = ($(this).attr('id')).split("-");
           var selector = selectorArray[0];

           var licenseplatesSelectorSelector = "#f3-".concat(selectorArray[0]);
           var licenseplates = $(licenseplatesSelectorSelector).html();

           var repairdateSelector = "#l3-".concat(selectorArray[0]);
           var repairdate = $(repairdateSelector).html().trim();
           repairdate = repairdate.slice(0, 10) + "T" + repairdate.slice(10, 16).replace(" ", "");
           alert(repairdate);

           var repairtypeSelector = "#n3-".concat(selectorArray[0]);
           var repairtype = $(repairtypeSelector).html();

           var repairCostSelector = "#o3-".concat(selectorArray[0]);
           var repairCost = $(repairCostSelector).html();


           var repairDescriptionSelector = "#p3-".concat(selectorArray[0]);
           var repairDescription = $(repairDescriptionSelector).html();


           var statusSelector = "#r3-".concat(selectorArray[0]);
           var status = $(statusSelector).html();


           var id = selectorArray[0];


           $(".repairid").val(id);
           $("#repairdate").val(repairdate);
           $(".repairPlates").val(licenseplates);
           $("#repairCost").val(repairCost);
           $("#repairtype").val(repairtype);
           $("#repairDescription").val(repairDescription);
           $("#status").val(status);
        })

        $(".deleteBtn").click(function (){
                   var selectorArray = ($(this).attr('id')).split("-");
                   var selector = selectorArray[0];

                   var vatSelector = "#f2-".concat(selectorArray[0]);
                   var vat = $(vatSelector).html();


                   var brandSelector = "#l2-".concat(selectorArray[0]);
                   var brand = $(brandSelector).html();


                   var modelSelector = "#m2-".concat(selectorArray[0]);
                   var model = $(modelSelector).html();


                   var fdSelector = "#o2-".concat(selectorArray[0]);
                   var fd = $(fdSelector).html();


                   var colourSelector = "#p2-".concat(selectorArray[0]);
                   var colour = $(colourSelector).html();


                   var plateSelector = "#r2-".concat(selectorArray[0]);
                   var plate = $(plateSelector).html();


                   var id = selectorArray[0];


                   ////////////////////////////////////// populate vehicle map
                   vehicle.clear();

                   vehicle.set("id",id);
                   vehicle.set("uservat",vat);
                   vehicle.set("licenseplates",plate);
                   vehicle.set("brand",brand);
                   vehicle.set("model",model);
                   vehicle.set("colour",colour);
                   vehicle.set("factorydate",fd);

                   alert(vehicle.get("colour"));
                })


                $("#delVehiclebtn").click(function (){

                           alert("jso_fuctio");
                           alert(vehicle.get("colour"));

                           var vehicleData = {
                             "id": vehicle.get("id").toString(),
                             "uservat": vehicle.get("uservat"),
                             "licenseplates": vehicle.get("licenseplates"),
                             "brand": vehicle.get("brand"),
                             "model": vehicle.get("model"),
                             "colour": vehicle.get("colour"),
                             "factorydate": vehicle.get("factorydate")
                            }

                            alert(vehicleData.uservat);

                           $.ajax({
                             type: "POST",
                             contentType : 'application/json; charset=utf-8',
                             dataType : 'json',
                             url: "http://localhost:8080/admin/delVehicle",
                             data: JSON.stringify(vehicleData), // This converts the payLoad to Json to pass along to Controller
                             success :function(result) {
                              // do what ever you want with data
                              alert('yeah');
                            }
                           });
                    })

});