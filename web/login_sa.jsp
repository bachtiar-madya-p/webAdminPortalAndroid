<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <title>Login Admin</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width">        
    <link rel="stylesheet" href="css/templatemo_main.css">

</head>
<body>
    <div id="main-wrapper">
        <div class="navbar navbar-inverse" role="navigation">
            <div class="navbar-header">
                <div class="logo"><h1>Dashboard Log In Super Admin</h1></div>
            </div>   
        </div>
        <div class="template-page-wrapper">
            <form class="form-horizontal templatemo-signin-form" role="form" method="post" action="ctl_loginSa?proses=LoginSa">
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="nik" class="col-sm-2 control-label">Username</label>
                        <div class="col-sm-10">
                            <input type="text" name="uname"  class="form-control" id="username" placeholder="user name" maxlength="7" required>
                        </div>
                    </div>              
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <label for="password" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" name="pwd" class="form-control" id="password" placeholder="Password" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-sm-offset-2 col-sm-10">
                                <label>
                                    <li class="active"><a href="login.jsp">Log In Sebagai Admin</a></li>
                                </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="col-sm-offset-2 col-sm-10">
                            <center>
                                <input type="submit" value="Log in" class="btn btn-default"></center>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>