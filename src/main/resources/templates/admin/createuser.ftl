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
                            <legend>User Registration Form</legend>

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
                                <label class="col-md-4 control-label" for="username">Username</label>
                                <div class="col-md-5">
                                    <input id="username" name="username" type="text" placeholder="Your username"
                                           class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Password input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="password">Password </label>
                                <div class="col-md-5">
                                    <input id="password" name="password" type="password" placeholder="Password"
                                           class="form-control input-md" required="">

                                </div>
                            </div>

                            <!-- Password input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="confirmpassword">Confirm Password</label>
                                <div class="col-md-5">
                                    <input id="confirmpassword" name="confirmpassword" type="password"
                                           placeholder="Confirmation password" class="form-control input-md"
                                           required="">
                                    <span class="help-block">Type again your password</span>
                                </div>
                            </div>

                             <!--Multiple Radios (inline)-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="user_type">User type</label>
                                <div class="col-md-4">
                                    <label class="radio-inline" for="admin">
                                        <input type="radio" name="user_type" id="admin" value="Admin" checked="checked">
                                        Admin
                                    </label>
                                    <label class="radio-inline" for="owner">
                                        <input type="radio" name="user_type" id="owner" value="Owner">
                                        Owner
                                    </label>
                                </div>
                            </div>

                            <!-- Button -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="createuser"></label>
                                <div class="col-md-4">
                                    <button id="createuser" name="createuser" class="btn btn-primary">Create User
                                    </button>
                                </div>
                            </div>

                        </fieldset>
                    </form>

                </div>
            </div>


        </#macro>

        <@display_page/>