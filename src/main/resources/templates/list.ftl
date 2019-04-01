<!DOCTYPE html>
<html>
    <head>
        <title>ADMIN PAGE</title>
        <meta charset="UTF-8"><#include "/layouts/header.ftl">
        <link rel="stylesheet" type="text/css" href="/css/home.css" >
    </head>
    <body id="page-top">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none"></span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="/home">Staff Info</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="/list">List Staff</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="/new-staff">Add Staff</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger logout" href="/signout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container-fluid p-0">
            <section class="resume-section p-3 p-lg-5 d-flex justify-content-center" >
                <div class="w-100">
                    <h2 class="mb-5">STAFF LIST</h2>
                    <div class="container-fluid">
                        <div class="card shadow mb-4">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover" style="margin-bottom: unset; text-align: center" id="dataTable" width="100%" cellspacing="0">
                                        <thead class="thead-dark">
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Username</th>
                                                <th>Password</th>
                                                <th colspan="2">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody><#list staffList as stf><#if staffId ==  stf.id>
                                            <tr style="background: whitesmoke"><#else>
                                            <tr>
                                                </#if>
                                                <td style="vertical-align: middle">${stf.id}</td>
                                                <td style="vertical-align: middle">${stf.name}</td>
                                                <td style="vertical-align: middle">${stf.username}</td>
                                                <td style="vertical-align: middle">${stf.password}</td>
                                                <td>
                                                    <a class="btn btn-outline-danger delBtn" data-toggle="modal" data-target="#exampleModal" href="/delete/${stf.id}">Delete</a>
                                                </td>
                                                <td >
                                                    <a class="btn btn-outline-warning" style="text-decoration: none" href="/edit/${stf.id}">Edit</a>
                                                </td>
                                            </tr>
                                            <!--                                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog" role="document"><div class="modal-content"><div class="modal-header"><h5 class="modal-title" id="exampleModalLabel">Delete Staff</h5><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></div><div class="modal-body"><p class="alert alert-danger">Are you sure? You want to delete this Staff!!!</p></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button><a href="" class="btn btn-primary" id="delRef">Delete</a></div></div></div></div>-->
                                            </#list>
                                        </tbody>
                                    </table>
                                    <#if msg??>
                                    <div style="margin-bottom: unset; margin-top: 1rem;" class="alert alert-success">
                                        <strong >${msg}</strong>
                                    </div>
                                    </#if>
                                    <#if error??>
                                    <div style="margin-bottom: unset; margin-top: 1rem;" class="alert alert-danger">
                                        <strong >${error}</strong>
                                    </div>
                                    </#if>
                                    <#if text??>
                                    <div style="margin-bottom: unset; margin-top: 1rem;" class="alert alert-info">
                                        <strong >${text}</strong>
                                    </div>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <!--<script type="text/javascript">
        $('.table .delBtn').on('click', function (event){
        event.prevetDefault();
        var href = $(this).attr('href');
        $('#exampleModal #delRef').attr(href);
        $('#exampleModal').modal();
        });
        </script>-->
    </body>
</html>
