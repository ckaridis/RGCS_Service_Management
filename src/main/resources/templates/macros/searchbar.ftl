<#macro searchbar>
    <form class="form-inline" id="searchForm" name="searchForm"
                                       center" action = "/admin/SearchOVR" method = "post" >
      <label class="sr-only" for="searchtype">Name</label>
      <select id="searchSelect" class="form-control mb-2 mr-sm-2 mb-sm-0"
       id="searchtype" name="searchtype" placeholder="Jane Doe" required>
          <option selected disabled>Search type</option>
          <option>Vehicle</option>
          <option>Repair</option>
          <option>Owner</option>
      </select>

      <label class="sr-only" for="searchval">Username</label>
      <div class="input-group mb-2 mr-sm-2 mb-sm-0 col-xs-8">
        <div id="firstAddon" class="input-group-addon">@</div>
        <div id="secondAddon" class="input-group-addon">VAT</div>
        <input type="text" class="form-control input-large" name="searchval" id="searchval"
         placeholder="Enter search criteria comma separated... f.ex. mail@com , vat number" required>
      </div>

      <a id="clear_bt" class="btn btn-default text-muted" href=""
                                      title="Clear">
         <i class="glyphicon glyphicon-remove"></i>
      </a>

      <button type="submit" class="btn btn-primary mb-2 mr-sm-2 mb-sm-0">Search</button>
    </form>
    <br>
    <br>

    <form class="form-inline" id="searchFormRepair" name="searchFormRepair"
          center" action = "/admin/SearchOVRD" method = "post" >

    <div class="form-group">
        <label class="col-md-4 control-label" for="date1">Repair Date</label>
        <div class="col-md-5">
            <input id="date1" name="date1" type="datetime-local"
                   min="2017-10-23T08:30" max="2018-06-30T16:30"
                   placeholder="Repair Date"
                   class="form-control input-md" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-4 control-label" for="date2">Repair Date</label>
        <div class="col-md-5">
            <input id="date2" name="date2" type="datetime-local"
                   min="2017-10-23T08:30" max="2018-06-30T16:30"
                   placeholder="Repair Date"
                   class="form-control input-md">
        </div>
    </div>
    <a id="clear_bt" class="btn btn-default text-muted" href=""
       title="Clear">
        <i class="glyphicon glyphicon-remove"></i>
    </a>
    <button type="submit" class="btn btn-primary mb-2 mr-sm-2 mb-sm-0">Search</button>

    </form>



</#macro>