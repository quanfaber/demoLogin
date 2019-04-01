
<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN</title>
        <meta charset="UTF-8">
        <#include "/layouts/header.ftl">
    </head>
    <body class="bg-gradient-primary">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xl-5 col-lg-12 col-md-9">
                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">Welcome!</h1>
                                        </div>
                                        <form class="user" action="/log-in" id="Login" method="POST">
                                            <div class="form-group">
                                                <input type="email" name="username" class="form-control form-control-user" id="exampleInputEmail" required="required" aria-describedby="emailHelp" placeholder="Enter Email Address...">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="password" class="form-control form-control-user" id="exampleInputPassword" required="required" placeholder="Password">
                                            </div>
                                            <input type="submit" class="btn btn-primary btn-user btn-block" value="Login">
                                        </form>
                                        <hr/>
                                        <div class="text-center">
                                            <a class="small" href="/register">Create an Account!</a>
                                        </div>
                                        <#if error??>
                                        <div class="alert alert-danger" style="color: #ff6666; margin-top: 14px; text-align: center; border: unset; border-radius: unset">${error}</div>
                                        </#if>
                                        <#if msg??>
                                        <div class="alert alert-success" style="color: #33cc33; margin-top: 14px; text-align: center; border: unset; border-radius: unset">${msg}</div>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="/js/main.js"></script>
    </body>
</html>
