<#macro navbar>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">RGCS Motors</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li class="dropdown"><a class="dropdown-toggle" class="glyphicon glyphicon-plus"
                                        data-toggle="dropdown" href="#">Search <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">User</a></li>
                        <li><a href="#">Service</a></li>
                        <li><a href="#">Vehicle</a></li>
                        <li><a href="#">Part</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Create <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/admin/createuser">User</a></li>
                        <li><a href="#">Service</a></li>
                        <li><a href="#">Vehicle</a></li>
                        <li><a href="#">Part</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/"><span class="glyphicon glyphicon-user"></span> Sign In</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>
    </nav>

</#macro>