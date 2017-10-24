<#include "/base.ftl">
    <#include "/macros/navbar.ftl">
        <#include "/macros/searchbar.ftl">

            <!-- PAGE HEADER GOES HERE -->
            <#macro page_head>
                <title> Admin Home </title>
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                        integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
                        crossorigin="anonymous">
                </script>
                <script type="text/javascript" src="/js/search.js"></script>

            </#macro>


            <!--  BODY CODE HOES HERE -->
            <#macro page_body>
                <@navbar/>
                <div class="container">


                    <div class="row">
                        <table class="table table-hover table-responsive">
                            <thead>
                            <tr>
                                <th>License Plates</th>
                                <th>Repair Date</th>
                                <th>Repair Type</th>
                                <th>Repair Cost</th>
                                <th>Description</th>
                                <th>Status</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>

                            <#if AdminRepairs??>
                            <#list AdminRepairs as repairs>

                            <tr id="d1">
                                <td id="f3-${repairs.getId()}">${repairs.getLicenseplate()}</td>
                                <td id="l3-${repairs.getId()}">${repairs.getRepairdate()}</td>
                                <td id="n3-${repairs.getId()}">${repairs.getRepairType()}</td>
                                <td id="o3-${repairs.getId()}">${repairs.getRepairCost()}</td>
                                <td id="p3-${repairs.getId()}">${repairs.getRepairDescription()}</td>
                                <td id="r3-${repairs.getId()}">${repairs.getStatus()}</td>
                                <td>
                                    <button id="${repairs.getId()}-editRbtn" type="button" data-toggle="modal"
                                            data-target="#editRepair" data-uid="1"
                                            class="update btn btn-warning btn-sm editRbtn">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                                <td>
                                    <button type="button" data-toggle="modal" data-target="#delete" data-uid="1"
                                            class="delete btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>
                                    </button>
                                </td>
                                <td id="s2">${repairs.getId()}</td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    </#if>



                    <div id="editRepair" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">×</button>
                                    <h4 class="modal-title">Update Data</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <form class="form-horizontal" action="/admin/editRepair" method="post">

                                            <fieldset>

                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="id">Id</label>
                                                    <div class="col-md-5">
                                                        <input id="id" name="id" type="text" placeholder="repair id"
                                                               class="form-control input-md repairid" required="" readonly>
                                                    </div>
                                                </div>

                                                <!-- Text input-->
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="licenseplates">License Plate</label>
                                                    <div class="col-md-5">
                                                                <input id="licenseplates" name="licenseplates" type="text"
                                                                       value = ""
                                                                       placeholder="Please type the Repair's License Plates"
                                                                       class="form-control input-md repairPlates" required=""
                                                                       readonly="readonly" >
                                                    </div>
                                                </div>

                                                <!-- Text input-->
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="repairdate">Repair Date</label>
                                                    <div class="col-md-5">
                                                        <input id="repairdate" name="repairdate" type="datetime-local"
                                                               min="2017-10-23T08:30" max="2018-06-30T16:30"
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
                                                    <label class="col-md-4 control-label" for="createrepair"></label>
                                                    <div class="col-md-4">
                                                        <button id="createrepair" name="createrepair" class="btn btn-primary">
                                                            Update Repair
                                                        </button>
                                                    </div>
                                                </div>

                                            </fieldset>

                                        </form>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <!-- <button type="button" id="up" class="btn btn-warning" data-dismiss="modal">Update</button> -->
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>

                <div id="delete" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">×</button>
                                <h4 class="modal-title">Delete Data</h4>
                            </div>
                            <div class="modal-body">
                                <strong>Are you sure you want to delete this data?</strong>
                            </div>
                            <div class="modal-footer">
                                <button type="button" id="del" class="btn btn-danger" data-dismiss="modal">Delete</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>

                </div>

                    <script type="text/javascript" src="/js/search.js"></script>

            </#macro>

            <@display_page/>