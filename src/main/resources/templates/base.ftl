<#macro page_head> <!-- This is the header code which will be changed from page to page -->
    <title>RGCS MOTORS</title>
    <link rel="stylesheet" type="text/css" href="/css/base.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
            crossorigin="anonymous">
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>

</#macro>


<#macro page_body> <!-- This is the body code which will be changed from page to page -->

    <h1> THIS IS THE DEFAULT BODY</h1>

</#macro>





<#macro display_page> <!-- this is the basic page -->
    <!DOCTYPE html>
    <head lang="en">


        <!-- bootstrap start -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/css/base.css">
        <!-- bootstrap end -->

        <@page_head/> <!-- This is where the extra header code will appear -->

    </head>
    <body>

    <div class="bodyclass"> <!-- required for custom css -->

            <@page_body/>


        <!--bootstrap start -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
                integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
                crossorigin="anonymous"></script>
        <!-- bootstrap end -->
        <script type="text/javascript" src="/js/navbarSelected.js"></script>
    </div>
    </body>
    </html>
</#macro>