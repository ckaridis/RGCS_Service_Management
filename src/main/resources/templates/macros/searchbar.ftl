<#macro searchbar>


    <!--<div class="input-group">
        <div class="input-group-btn search-panel">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <span id="search_concept">Select...</span> <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li><a href="#user"><i class="fa fa-angle-double-right"></i> User</a></li>
                <li><a href="#service"><i class="fa fa-angle-double-right"></i> Service</a></li>
                <li><a href="#vehicle"><i class="fa fa-angle-double-right"></i> Vehicle</a></li>
                <li><a href="#part"><i class="fa fa-angle-double-right"></i> Part</a></li>
            </ul>
        </div>
        <input type="hidden" name="search_param" value="name" id="search_param">
        <input type="text" class="form-control" name="q" placeholder="Search.." id="search_key" value="">
        <span class="input-group-btn">
			<a class="btn btn-default text-muted" href="#"
               title="Clear"><i class="glyphicon glyphicon-remove"></i> </a>
			<button class="btn btn-info" type="submit">  Search  </button>
	</span>
    </div>-->


    <form class="form-inline" id="searchForm" name="searchForm"
                                       center" action = "/admin/SearchOVR" method = "post" >
      <label class="sr-only" for="searchtype">Name</label>
      <select class="form-control mb-2 mr-sm-2 mb-sm-0"
       id="searchtype" name="searchtype" placeholder="Jane Doe" required>
          <option selected disabled>Search type</option>
          <option>Vehicle</option>
          <option>Repair</option>
          <option>Owner</option>
      </select>

      <label class="sr-only" for="searchval">Username</label>
      <div class="input-group mb-2 mr-sm-2 mb-sm-0 col-xs-8">
        <div class="input-group-addon">@</div>
        <div class="input-group-addon">VAT</div>
        <input type="text" class="form-control input-large" name="searchval" id="searchval"
         placeholder="Enter search criteria comma separated... f.ex. mail@com , vat number" required>
      </div>

      <a id="clear_bt" class="btn btn-default text-muted" href=""
                                      title="Clear">
         <i class="glyphicon glyphicon-remove"></i>
      </a>

      <button type="submit" class="btn btn-primary mb-2 mr-sm-2 mb-sm-0">Search</button>
    </form>





</#macro>