<#include "base.ftl">

    <!-- THIS IS PAGE HEADER -->
    <#macro page_head>
        <title>RGCS Login Page</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/css/index.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                        integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
                        crossorigin="anonymous">
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
        <script type="text/javascript" src="/js/index.js"></script>

    </#macro>


    <!-- THIS IS PAGE BODY -->
    <#macro page_body>

        <div class="row">

            <div id="page_wrapper" class="gradient">
                <div id="form_wrapper">
                    <form id="loginForm" name="loginForm" action="/" method="post">
                        <div>
                            <p>
                                <label for="email" class="whiteLabel"><b>Username :</b></label>
                                <br>
                                <input type="email" placeholder="Enter Email" id="email" name="email">
                            </p>
                            <p>
                                <label for="password" class="whiteLabel"><b>Password :</b></label>
                                <br>
                                <input type="password" placeholder="Enter Password" id="password" name="password">
                            </p>
                            <br>
                            <p style="color:red;font-weight:bold">${errorMessage!""}</p>
                            <p>
                                <button type="submit">Login</button>
                            </p>
                        </div>
                    </form>
                </div>
                <div id="hero_wrapper">
                    <h1>RGCS MOTORS.</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sollicitudin rhoncus mi id ornare.
                        Mauris luctus, tortor vel sagittis rhoncus, turpis augue interdum eros,
                        sit amet iaculis sapien velit sed turpis. Donec eu enim nibh. Integer orci nibh,
                        volutpat ac magna quis, pulvinar pretium diam. Mauris facilisis pretium dignissim.
                        Duis vestibulum elit non augue suscipit elementum. Aenean ut justo tellus.
                    </p>
                </div>
                <div id="names_list_wrapper">
                    <ul id="names_list" align="center">
                        <li class="li_padding_10">chris</li>
                        <li class="li_padding_10">chris</li>
                        <li class="li_padding_10">george</li>
                        <br>
                        <br>
                        <li class="li_padding_20">john</li>
                        <li class="li_padding_20">vicky</li>
                    </ul>
                </div>
                <div id="technologies_wall">
                </div>
            </div>


        </div>

    </#macro>

    <@display_page/>