<#include "/base.ftl">
    <#include "/macros/navbarUser.ftl">
            <!-- PAGE HEADER GOES HERE -->
            <#macro page_head>
                <title> Owner Home </title>
            </#macro>


            <!--  BODY CODE HOES HERE -->
            <#macro page_body>
                <@navbarUser/>
                <div class="container">

                    <div class="row">
                        <table class="table table-hover table-responsive">
                            <thead>
                            <tr>
                                <th>License Plates</th>
                                <th>Repair Date</th>
                                <th>Repair Type</th>
                                <th>Repair Cost</th>
                                <th>Description</th>
                                <th>Status</th>
                            </tr>
                            </thead>
                            <tbody>

                            <#if OwnerRepairs??>
                                <#list OwnerRepairs as repairs>

                                    <tr id="d1">
                                        <td id="f1">${repairs.getLicensePlates()}</td>
                                        <td id="l1">${repairs.getRepairdate()}</td>
                                        <td id="m1">${repairs.getRepairType()}</td>
                                        <td id="m1">${repairs.getRepairCost()}</td>
                                        <td id="m1">${repairs.getRepairDescription()}</td>
                                        <td id="m1">${repairs.getStatus()}</td>
                                    </tr>
                                </#list>
                            </#if>
                            </tbody>
                        </table>
                    </div>
                    <div id="edit" class="modal fade" role="dialog">
            </#macro>
            <@display_page/>