<#macro navbarUser>


    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">RGCS Motors</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="javascript:window.location.href=window.location.href">
                    <span class="glyphicon glyphicon-refresh"></span> Refresh Page
                </a> </li>


            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href=""><span class="glyphicon glyphicon-user"></span>  ${OwnerEmail}</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>

    </nav>





</#macro>