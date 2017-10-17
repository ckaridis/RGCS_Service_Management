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
                                <th>ID</th>
                                <th>VAT Number</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Active Services</th>
                                <th>Email</th>
                                <th>Type</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr id="d1">
                                <td>1</td>
                                <td id="f1">123456789</td>
                                <td id="l1">John</td>
                                <td id="m1">Doe</td>
                                <td id="m1">2</td>
                                <td id="m1">test@test.com</td>
                                <td id="m1">Administrator</td>
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
                            <tr id="d1">
                                <td>1</td>
                                <td id="f2">123456789</td>
                                <td id="l2">John</td>
                                <td id="m2">Doe</td>
                                <td id="m2">2</td>
                                <td id="m2">test@test.com</td>
                                <td id="m2">Administrator</td>
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
                            <tr id="d2">
                                <td>1</td>
                                <td id="f1">123456789</td>
                                <td id="l1">John</td>
                                <td id="m1">Doe</td>
                                <td id="m1">2</td>
                                <td id="m1">test@test.com</td>
                                <td id="m1">Administrator</td>
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
                            <tr id="d3">
                                <td>1</td>
                                <td id="f1">123456789</td>
                                <td id="l1">John</td>
                                <td id="m1">Doe</td>
                                <td id="m1">2</td>
                                <td id="m1">test@test.com</td>
                                <td id="m1">Administrator</td>
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
                            </tbody>
                        </table>
                    </div>
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