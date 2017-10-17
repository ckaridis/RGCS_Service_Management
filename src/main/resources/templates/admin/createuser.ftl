<#include "/base.ftl">

    <!-- PAGE HEADER GOES HERE -->
    <#macro page_head>
        <title> User Registration </title>
    </#macro>


    <!--  BODY CODE HOES HERE -->
    <#macro page_body>



        <div class="container">
            <div class="row">
                <form class="form-horizontal">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Registration Form</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="lastname">Last Name</label>
                            <div class="col-md-5">
                                <input id="lastname" name="lastname" type="text" placeholder="Your last name" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="firstname">First Name</label>
                            <div class="col-md-5">
                                <input id="firstname" name="firstname" type="text" placeholder="Your first name" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="email">Email</label>
                            <div class="col-md-5">
                                <input id="email" name="email" type="text" placeholder="Your email here" class="form-control input-md" required="">
                                <span class="help-block">xxxxxxxxx@xxxxx.xxx</span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="username">Username</label>
                            <div class="col-md-5">
                                <input id="username" name="username" type="text" placeholder="Your username" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="password">Password </label>
                            <div class="col-md-5">
                                <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmasipassword">Konfirmasi Password</label>
                            <div class="col-md-5">
                                <input id="confirmasipassword" name="confirmasipassword" type="password" placeholder="Confirmation password" class="form-control input-md" required="">
                                <span class="help-block">Type again your password</span>
                            </div>
                        </div>

                        <!-- Multiple Radios (inline) -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="gender">Gender</label>
                            <div class="col-md-4">
                                <label class="radio-inline" for="gender-0">
                                    <input type="radio" name="gender" id="gender-0" value="Male" checked="checked">
                                    Male
                                </label>
                                <label class="radio-inline" for="gender-1">
                                    <input type="radio" name="gender" id="gender-1" value="Female">
                                    Female
                                </label>
                            </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmation"></label>
                            <div class="col-md-4">
                                <button id="confirmation" name="confirmation" class="btn btn-primary">Submit</button>
                            </div>
                        </div>

                    </fieldset>
                </form>

            </div>
        </div>


    </#macro>

    <@display_page/>