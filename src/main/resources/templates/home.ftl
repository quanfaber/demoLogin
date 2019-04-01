
<!DOCTYPE html>
<html>
    <head>
        <title>ADMIN PAGE</title>
        <meta charset="UTF-8">
        <#include "/layouts/header.ftl">
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
            <section class="resume-section p-3 p-lg-5 d-flex align-items-center" >
                <div class="w-100">
                    <h1 class="mb-0">Hello,
                        <span class="text-primary">${staff.name}</span>
                    </h1>
                    <br/>
                    <div class="subheading mb-5">
                        <a >· ID: ${staff.id}<br/>· Username: ${staff.username}<br/>· Password: ${staff.password}</a>
                    </div>
                    <p class="lead mb-5"></p>
                </div>
            </section>
<!--            <hr class="m-0">
            <section class="resume-section p-3 p-lg-5 d-flex justify-content-center" >
                <div class="w-100">
                    <h2 class="mb-5">STAFF LIST</h2>
                    <div class="container-fluid">
                        <div class="card shadow mb-4">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name</th>
                                                <th>Username</th>
                                                <th>Password</th>
                                                <th colspan="2">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <#list staffList as stf>
                                            <tr>
                                                <td>${stf.id}</td>
                                                <td>${stf.name}</td>
                                                <td>${stf.username}</td>
                                                <td>${stf.password}</td>
                                                <td><a class="btn btn-outline-danger delBtn" data-toggle="modal" data-target="#exampleModal" href="/delete/${stf.id}">Delete</a></td>
                                                <td ><a class="btn btn-outline-warning" style="text-decoration: none" href="/edit/${stf.id}">Edit</a></td>
                                            </tr>
                                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Delete Staff</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p class="alert alert-danger">Are you sure? You want to delete this Staff!!!</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <a href="" class="btn btn-primary" id="delRef">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </#list>
                                        </tbody>
                                    </table>
                                    <br/>
                                    <#if msg??>
                                    <div style="width: 55%" class="alert alert-success">
                                        <strong >${msg}</strong>
                                    </div>
                                    </#if>
                                    <#if error??>
                                    <div style="width: 55%" class="alert alert-danger">
                                        <strong >${error}</strong>
                                    </div>
                                    </#if>
                                    <#if text??>
                                    <div style="width: 55%" class="alert alert-info">
                                        <strong >${text}</strong>
                                    </div>
                                    </#if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        </section>
        <hr class="m-0">
        <section class="resume-section p-3 p-lg-5 d-flex align-items-center" >
            <div class="w-100">
                <h2 class="mb-5">Education</h2>
                <div class="resume-item d-flex flex-column flex-md-row justify-content-between mb-5">
                    <div class="resume-content">
                        <h3 class="mb-0">University of Colorado Boulder</h3>
                        <div class="subheading mb-3">Bachelor of Science</div>
                        <div>Computer Science - Web Development Track</div>
                        <p>GPA: 3.23</p>
                    </div>
                    <div class="resume-date text-md-right">
                        <span class="text-primary">August 2006 - May 2010</span>
                    </div>
                </div>
                <div class="resume-item d-flex flex-column flex-md-row justify-content-between">
                    <div class="resume-content">
                        <h3 class="mb-0">James Buchanan High School</h3>
                        <div class="subheading mb-3">Technology Magnet Program</div>
                        <p>GPA: 3.56</p>
                    </div>
                    <div class="resume-date text-md-right">
                        <span class="text-primary">August 2002 - May 2006</span>
                    </div>
                </div>
            </div>
        </section>-->
        </div>
        <script type="text/javascript">
            $('.table .delBtn').on('click', function (event) {
                event.prevetDefault();
                var href = $(this).attr('href');
                $('#exampleModal #delRef').attr(href);
                $('#exampleModal').modal();
            });
        </script>
    </body>
</html>
