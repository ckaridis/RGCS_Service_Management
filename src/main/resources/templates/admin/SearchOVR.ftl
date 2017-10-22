<#include "/base.ftl">
    <#include "/macros/navbar.ftl">
        <#include "/macros/searchbar.ftl">

            <!-- PAGE HEADER GOES HERE -->
            <#macro page_head>
                <title> Admin Search </title>

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

                    <@searchbar/>

                    <br>
                    <#if binding_result??>
                    <#list errorsList as error>
                       <div class="row">
                       <br>
                       <p class="alert alert-danger" style="color:red;font-weight:bold;text-align:center;">
                                          error : ${error.getDefaultMessage()!error.toString()}
                       </p>
                       </div>
                    </#list>
                    </#if>

                    <div class=row">
                       <#if binding_result_modal??>
                       <p style="text-align:center; font-size:larger; color:lightSlateGrey;">
                          Form errors on previous try :
                       </p>
                       <#list errorsList_modal as error>
                       <div class="row alert alert-warning">
                       <br>
                       <p> <!--style="color:red;font-weight:bold;text-align:center;"-->
                       error : ${error.getDefaultMessage()!error.toString()}
                       </p>
                       </div>
                       </#list>
                       </#if>
                       <br>
                       <#if errorMessage_modal??>
                       <p style="text-align:center; font-size:larger; color:lightSlateGrey;">
                          Exceptions that occured on previous submission try :
                       </p>
                       <div class="row">
                       <br>
                       <p class="alert alert-danger">
                          error : ${errorMessage_modal}
                       </p>
                       </div>
                       </#if>
                       <#if success_modal??>
                       <div class="row">
                       <p class="alert alert-success">
                          ${success_modal}
                       </p>
                       </div>
                       </#if>
                    </div>

                    <br>
                    <br>
                    <#if searchedUser??>
                    <h2 class"primary" style"font-weight:bold;">User search results</h2>
                    <br>
                    <div class="row">
                        <table class="table table-hover table-responsive">
                            <thead>
                            <tr>
                                <th>VAT</th>
                                <th>NAME</th>
                                <th>SURNAME</th>
                                <th>EMAIL</th>
                                <th>PASSWORD</th>
                                <th>ADDRESS</th>
                                <th>USERTYPE</th>
                                <th>EDIT</th>
                                <th>DELETE</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr id="d1">
                                <td id="f1">${searchedUser.getVat()}</td>
                                <td id="l1">${searchedUser.getFirstName()}</td>
                                <td id="m1">${searchedUser.getLastName()}</td>
                                <td id="o1">${searchedUser.getEmail()}</td>
                                <td id="p1">${searchedUser.getPassword()}</td>
                                <td id="q1">${searchedUser.getAddress()}</td>
                                <td id="r1">${searchedUser.getType()}</td>
                                <td>
                                    <button type="button" data-toggle="modal" data-target="#edit" data-uid="1"
                                            class="update btn btn-warning btn-sm" id="edit_btn">
                                               <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </td>
                                <td>
                                    <button type="button" data-toggle="modal" data-target="#delete" data-uid="1"
                                            class="delete btn btn-danger btn-sm">
                                               <span class="glyphicon glyphicon-trash"></span>
                                    </button>
                                </td>
                                <td style="display:hidden" id="s1">${searchedUser.getId()}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    </#if>

                    <#if vehicles??>
                    <h2 class"primary" style"font-weight:bold;">Vehicles search results</h2>
                    <br>
                       <div class="row">
                          <table class="table table-hover table-responsive">
                             <thead>
                                <tr>
                                   <th>VAT</th>
                                   <th>BRAND</th>
                                   <th>MODEL</th>
                                   <th>PRODUCTION YEAR</th>
                                   <th>COLOR</th>
                                   <th>PLATE</th>
                                   <th>EDIT</th>
                                   <th>DELETE</th>
                                 </tr>
                             </thead>
                             <tbody>
                             <#list vehicles as vehicle>
                                <tr id="d1">
                                   <td id="f1">${vehicle.getUservat()}</td>
                                   <td id="l1">${vehicle.getBrand()}</td>
                                   <td id="m1">${vehicle.getModel()}</td>
                                   <td id="m1">${vehicle.getFactoryDate()}</td>
                                   <td id="m1">${vehicle.getColour()}</td>
                                   <td id="m1">${vehicle.getLicenseplate()}</td>
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
                             </tbody>
                          </table>
                       </div>
                    </#if>


                <div id="edit" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">×</button>
                                <h4 class="modal-title">Update Data</h4>
                            </div>
                            <div class="modal-body">
                                          <div class="row">
                                                    <form class="form-horizontal" action="/admin/edituser" method = "post">
                                                        <fieldset>

                                                           <!-- Text input-->
                                                           <div class="form-group">
                                                               <label class="col-md-4 control-label" for="lastname">Last Name</label>
                                                               <div class="col-md-5">
                                                                  <input id="id" name="id" type="text" placeholder="user id"
                                                                         class="form-control input-md" required="" readonly>
                                                               </div>
                                                           </div>

                                                            <!-- Text input-->
                                                            <div class="form-group">
                                                                <label class="col-md-4 control-label" for="lastname">Last Name</label>
                                                                <div class="col-md-5">
                                                                    <input id="lastname" name="lastname" type="text" placeholder="Your last name"
                                                                           class="form-control input-md" required="">

                                                                </div>
                                                            </div>

                                                            <!-- Text input-->
                                                            <div class="form-group">
                                                                <label class="col-md-4 control-label" for="firstname">First Name</label>
                                                                <div class="col-md-5">
                                                                    <input id="firstname" name="firstname" type="text" placeholder="Your first name"
                                                                           class="form-control input-md" required="">

                                                                </div>
                                                            </div>

                                                            <!-- Text input-->
                                                            <div class="form-group">
                                                                <label class="col-md-4 control-label" for="vat">VAT</label>
                                                                <div class="col-md-5">
                                                                    <input id="vat" name="vat" type="text" placeholder="Your VAT number"
                                                                           class="form-control input-md" required="">
                                                                </div>
                                                            </div>

                                                            <!-- Text input-->
                                                            <div class="form-group">
                                                                <label class="col-md-4 control-label" for="email">Email</label>
                                                                <div class="col-md-5">
                                                                    <input id="email" name="email" type="text" placeholder="Your email here"
                                                                           class="form-control input-md" required="">
                                                                    <span class="help-block">xxxxxxxxx@xxxxx.xxx</span>
                                                                </div>
                                                            </div>

                                                             <!-- Text input-->
                                                                <div class="form-group">
                                                                   <label class="col-md-4 control-label" for="address">Address</label>
                                                                   <div class="col-md-5">
                                                                      <input id="address" name="address" type="text"
                                                                            placeholder="Your address goes here" class="form-control input-md"
                                                                            required="">
                                                                   </div>
                                                                </div>


                                                            <!-- Password input-->
                                                            <div class="form-group">
                                                                <label class="col-md-4 control-label" for="password">Password </label>
                                                                <div class="col-md-5">
                                                                    <input id="password" name="password" type="password" placeholder="Password"
                                                                           class="form-control input-md" required="" readonly>

                                                                </div>
                                                            </div>

                                                            <!-- Password input-->
                                                            <div class="form-group">
                                                                <label class="col-md-4 control-label" for="confirmpassword">Confirm Password</label>
                                                                <div class="col-md-5">
                                                                    <input id="confirmpassword" name="confirmpassword" type="password"
                                                                           placeholder="Confirmation password" class="form-control input-md"
                                                                           required="" readonly>
                                                                    <span class="help-block">Type again your password</span>
                                                                </div>
                                                            </div>

                                                             <div class="form-group">
                                                                   <label class="col-md-4 control-label" for="type">Select user type</label>
                                                                   <div class="col-md-5">
                                                                      <select class="form-control" id="type" name="type">
                                                                         <option>Admin</option>
                                                                         <option>Owner</option>
                                                                      </select>
                                                                   </div>
                                                             </div>

                                                            <!-- Button -->
                                                            <div class="form-group">
                                                                <label class="col-md-4 control-label" for="createuser"></label>
                                                                <div class="col-md-4">
                                                                    <input type="submit" id="createuser" value="Update User"
                                                                                  name="createuser" class="btn btn-primary">
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
            </#macro>

            <@display_page/>