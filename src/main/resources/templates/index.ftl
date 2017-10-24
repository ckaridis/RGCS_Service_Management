<#include "base.ftl">

    <!-- THIS IS PAGE HEADER -->
    <#macro page_head>
        <title>RGCS Login Page</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

        <!-- Website CSS style -->
        <link rel="stylesheet" type="text/css" href="/css/index.css">

        <!-- Website Font style -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

        <!-- Fonts -->
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

    </#macro>


    <!-- THIS IS PAGE BODY -->
    <#macro page_body>

        <div class="row">

            <div class="container">
                <div class="row main">
                    <div class="panel-heading">
                        <div class="panel-title text-center">
                            <h1 class="title">RGS Motors</h1>
                            <h3> This project was created by Giorgos, Chris, Chris, Giannis, Vicky.</h3>
                            <h4> Regeneration Coding School 2017.</h4>
                            <hr />
                        </div>
                    </div>
                    <div class="main-login main-center">
                        <h3 class="text-center">Please sign in</h3>
                        <form id="loginForm" class="form-horizontal" method="post" action="/" data-toggle="validator">
                            <div class="form-group">
                                <label for="email" class="cols-sm-2 control-label">Email</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input type="email" class="form-control" name="email" id="email"  placeholder="Enter your Email" required/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Password</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                        <input type="password" data-minlength="6" class="form-control" name="password"
                                               id="password"  placeholder="Enter your Password" required/>

                                    </div>
                                </div>
                            </div>

                            <div class="form-group ">
                                <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Sign in</button>
                            </div>
<!--                            <div class="login-register">
                                <a href="create_account.php">Create account</a> or <a href="reset_password.php">reset password</a>
                            </div>-->
                            <p style="color:red;font-weight:bold" class="text-center">${errorMessage!""}</p>
                        </form>
                    </div>
                </div>
            </div>

            <script type="text/javascript" src="assets/js/bootstrap.js"></script>


        </div>

        <script type="text/javascript" src="/js/index.js"></script>


    </#macro>

    <@display_page/>