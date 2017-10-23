<#macro navbar>

    <script>



        $(document).ready(function() {
	// get current URL path and assign 'active' class
	var pathname = window.location.pathname;
	$('.nav > li > a[href="'+pathname+'"]').parent().addClass('active');
})




    </script>



    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">RGCS Motors</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/admin/home"><span class="glyphicon glyphicon-home"></span>  Home</a></li>
                <li><a href="/admin/createuser"> <span class="glyphicon glyphicon-user"></span>  Create User</a></li>
                <li><a href="/admin/CreateVehicle"><span class="glyphicon glyphicon-plus-sign"></span>  Create Vehicle</a></li>
                <li><a href="/admin/CreateRepair"><span class="glyphicon glyphicon-list"></span>  Create Repair</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-wrench"></span>  Create Part</a></li>
                <li>
                   <a href="/admin/SearchOVR">
                      <span class="glyphicon glyphicon-search"></span>
                      Search
                   </a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href=""><span class="glyphicon glyphicon-user"></span>${AdminEmail}</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>

    </nav>





</#macro>