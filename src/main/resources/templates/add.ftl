<!DOCTYPE html>
<html>
    <head>
        <title>ADD PAGE</title>
        <meta charset="UTF-8"><#include "/layouts/header.ftl">
        <link rel="stylesheet" type="text/css" href="/css/home.css" >
    </head>
    <body id="page-top">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">Clarence Taylor</span>
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
                    <h2 class="mb-5">ADD STAFF</h2>
                    <div class="container-fluid">
                        <div class="card shadow mb-4 col-xl-6">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <form name="addForm" action="/add-staff" method="POST" id="DemoJqueryValidation">
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend"><span style="padding-right: 40px" class="input-group-text" id="basic-addon1">Name</span></div>
                                            <input class="form-control"  type="text" name="name" required="required"/>
                                        </div>
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend"><span style="padding-right: 8px" class="input-group-text" id="basic-addon1">UserName</span></div>
                                            <input class="form-control"  type="email" name="username" required="required"/>
                                        </div>
                                        <div  class="input-group mb-3">
                                            <div class="input-group-prepend"><span style="padding-right: 16px" class="input-group-text" id="basic-addon1">Password</span></div>
                                            <input class="form-control"  type="text" name="password" required="required"/>
                                        </div>
                                        <input  class="btn btn-primary btn-lg btn-block" type="submit" value="Add" />
                                        <br/>
                                        <#if msg??>
                                        <div  class="alert alert-danger">
                                            <strong>${msg}</strong>
                                        </div>
                                        </#if>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script src="/js/main.js"></script>
    </body>
</html>
