
<!DOCTYPE html>
<html>
    <head>
        <title>REGISTER</title>
        <meta charset="UTF-8">
        <#include "/layouts/header.ftl">
        </head>
    <body class="bg-gradient-primary">
        <div class="container  col-xl-4">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                                    </div>
                                <form class="user" name="registerForm" th:action="/register" id="Register" method="POST">
                                    <div class="form-group">
                                        <input type="text" name="name" class="form-control form-control-user"  required="required" placeholder="Name">
                                        </div>
                                    <div class="form-group">
                                        <input type="email" name="username"  class="form-control form-control-user"  required="required" placeholder="Email Address">
                                        </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="password" name="password" id="password" required="required" class="form-control form-control-user"  placeholder="Password">
                                            </div>
                                        <div class="col-sm-6">
                                            <input type="password" name="confirm_password" required="required" class="form-control form-control-user"  placeholder="Repeat Password">
                                            </div>
                                        </div>
                                    <input href="login.html" class="btn btn-primary btn-user btn-block" type="submit" value="Register Account"/>   
                                    </form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="/login">Already have an account? Login!</a>
                                    </div>
                                <#if error??>
                                <div class="alert alert-danger" style="color: #ff6666; margin-top: 14px; text-align: center; border: unset; border-radius: unset">${error}</div>
                                </#if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <script src="/js/main.js"></script>
        </body>
    </html>
