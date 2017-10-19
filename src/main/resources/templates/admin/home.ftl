<#include "/base.ftl">
    <#include "/macros/navbar.ftl">
        <#include "/macros/searchbar.ftl">

            <!-- PAGE HEADER GOES HERE -->
            <#macro page_head>
                <title> Admin Home </title>
            </#macro>


            <!--  BODY CODE HOES HERE -->
            <#macro page_body>
                <@navbar/>
                <div class="container">

                    <@searchbar/>


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
                                <td id="f1">${repairs.getLicensePlates()}</td>
                                <td id="l1">${repairs.getRepairdate()}</td>
                                <td id="m1">${repairs.getRepairType()}</td>
                                <td id="m1">${repairs.getRepairCost()}</td>
                                <td id="m1">${repairs.getRepairDescription()}</td>
                                <td id="m1">${repairs.getStatus()}</td>
                                <td>
                                    <button type="button" data-toggle="modal" data-target="#edit" data-uid="1"
                                            class="update btn btn-warning btn-sm"><span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                                <td>
                                    <button type="button" data-toggle="modal" data-target="#delete" data-uid="1"
                                            class="delete btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span>
                                    </button>
                                </td>
                            </tr>
                            </#list>
                            </#if>
                            </tbody>
                        </table>
                    </div>
                <div id="edit" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">×</button>
                                <h4 class="modal-title">Update Data</h4>
                            </div>
                            <div class="modal-body">
                                <input id="fn" type="text" class="form-control" name="fname" placeholder="First Name">
                                <input id="ln" type="text" class="form-control" name="fname" placeholder="Last Name">
                                <input id="mn" type="text" class="form-control" name="fname" placeholder="Middle Name">
                                <input id="mn" type="text" class="form-control" name="fname" placeholder="Middle Name">
                                <input id="mn" type="text" class="form-control" name="fname" placeholder="Middle Name">
                                <input id="mn" type="text" class="form-control" name="fname" placeholder="Middle Name">
                            </div>
                            <div class="modal-footer">
                                <button type="button" id="up" class="btn btn-warning" data-dismiss="modal">Update</button>
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
            </#macro>

            <@display_page/>