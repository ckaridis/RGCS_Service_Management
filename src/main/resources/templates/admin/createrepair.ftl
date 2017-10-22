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
                    <form class="form-horizontal" action="/admin/CreateRepair" method="post">
                        <fieldset>

                            <!-- Form Name -->
                            <legend>Repair Registration Form</legend>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="licenseplates">License Plate</label>
                                <div class="col-md-5">
                                    <#if licensePlates??>
                                        <input id="licenseplates" name="licenseplates" type="text" value="${licensePlates}"
                                               placeholder="Please type the Repair's License Plates"
                                               class="form-control input-md" required="" readonly="readonly">
                                        <#else>
                                            <input id="licenseplates" name="licenseplates" type="text" value=""
                                                   placeholder="Please type Repair's License Plates"
                                                   class="form-control input-md" required="" >
                                    </#if>

                                </div>
                            </div>

                            <!-- Text input-->

                            <div class="form-group">
                                <label class="col-md-4 control-label" for="repairdate">Repair Date</label>
                                <div class="col-md-5">
                                    <input id="repairdate" name="repairdate" type="datetime-local"
                                           placeholder="Repair Date"
                                           class="form-control input-md" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="repairDescription">Repair Description</label>
                                <div class="col-md-5">
                                    <input id="repairDescription" name="repairDescription" type="text"
                                           placeholder="Repair Description"
                                           class="form-control input-md" required="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-4 control-label" for="repairCost">Repair Cost</label>
                                <div class="col-md-5">
                                    <input id="repairCost" name="repairCost" type="text" placeholder="RepairCost"
                                           class="form-control input-md" required="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-4 control-label" for="status">Status</label>
                                <div class="col-md-5">
                                    <select class="form-control" name="status" id="status">
                                        <option>InProgress</option>
                                        <option>Finished</option>
                                        <option>Cancelled</option>
                                    </select>
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="repairtype">Repair Type</label>
                                <div class="col-md-5">
                                    <select class="form-control" name="repairtype" id="repairtype">
                                        <option>Small</option>
                                        <option>Big</option>
                                    </select>
                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="CreateRepair"></label>
                                <div class="col-md-4">
                                    <button id="CreateRepair" name="CreateRepair" class="btn btn-primary">Create Repair
                                    </button>
                                </div>
                            </div>

                        </fieldset>
                    </form>

                </div>
                <br>
                <#if binding_result??>
                    <p style="text-align:center; font-size:larger; color:lightSlateGrey;">
                        Form errors on previous try :
                    </p>
                    <#list errorsList as error>
                        <div class="row alert alert-warning">
                            <br>
                            <p> <!--style="color:red;font-weight:bold;text-align:center;"-->
                                error : ${error.getDefaultMessage()!error.toString()}
                            </p>
                        </div>
                    </#list>
                </#if>
                <br>
                <#if errorMessage??>
                    <p style="text-align:center; font-size:larger; color:lightSlateGrey;">
                        Exceptions that occured on previous submission try :
                    </p>
                    <div class="row">
                        <br>
                        <p style="color:red;font-weight:bold;text-align:center;">
                            error : ${errorMessage}
                            <#if registrationResult??>
                                <br>
                                registration result : ${registrationResult}
                            </#if>
                        </p>
                    </div>
                </#if>
            </div>


        </#macro>

        <@display_page/>