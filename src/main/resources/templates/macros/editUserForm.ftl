<#macro editUserForm>


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



</#macro>