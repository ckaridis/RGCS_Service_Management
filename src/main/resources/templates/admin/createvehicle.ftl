<#include "/base.ftl">
    <#include "/macros/navbar.ftl">

        <!-- PAGE HEADER GOES HERE -->
        <#macro page_head>
            <title> User Registration </title>
        </#macro>


        <!--  BODY CODE HOES HERE -->
        <#macro page_body>


            <@navbar/>
            <div class="container">
                <div class="row">
                    <form class="form-horizontal">
                        <fieldset>

                            <!-- Form Name -->
                            <legend>Vehicle Registration Form</legend>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="owner_vat">Owner VAT</label>
                                <div class="col-md-5">
                                    <input id="owner_vat" name="owner_vat" type="text"
                                           placeholder="Please type the Owner's VAT Number"
                                           class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="license_plate">First Name</label>
                                <div class="col-md-5">
                                    <input id="license_plate" name="license_plate" type="text"
                                           placeholder="Vehicle's Licence Plate"
                                           class="form-control input-md" required="">
                                    <span class="help-block">ABC-1234</span>

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="brand">Brand</label>
                                <div class="col-md-5">
                                    <input id="brand" name="brand" type="text" placeholder="Vehicle brand"
                                           class="form-control input-md" required="">
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="model">Model</label>
                                <div class="col-md-5">
                                    <input id="model" name="model" type="text" placeholder="Vehicle model"
                                           class="form-control input-md" required="">
                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="createvehicle"></label>
                                <div class="col-md-4">
                                    <button id="createvehicle" name="createvehicle" class="btn btn-primary">Create Vehicle
                                    </button>
                                </div>
                            </div>

                        </fieldset>
                    </form>

                </div>
            </div>


        </#macro>

        <@display_page/>