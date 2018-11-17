<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.log4j.Logger"%>
<%@ page import="main.com.java.security.config.SecurityConfig" %>

<!doctype html>
<html lang="en">

<head>

    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <style>
        .panel-title {
            text-align: center;
        }

        #loginbox {
            width: 450px;
            margin: 100px auto 0 auto;
        }

        .form-group {
            margin: 10px;
            text-align: center;
        }

        .alert {
            width: 80%;
            margin: 5px auto;
        }

        .input-group {
            width: 80%;
            height: 60px;
            margin: 5px auto;
        }

        .input-group-addon {
            font-size: 23px !important;
            height: 100%;
        }

        .input-group .form-control {
            height: 100%;
        }

        #login-button {
            width: 180px;
            margin: 10px auto;
            height: 50px;
            display: inline-block;
        }
    </style>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

<div id="loginbox">

    <div class="panel panel-info">

        <div class="panel-heading">
            <div class="panel-title">Sign In</div>
        </div>

        <div class="panel-body">

            <!-- Login Form -->
            <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                       method="POST" class="form-horizontal" enctype="application/x-www-form-urlencoded">

                <!-- Place for messages: error, alert etc ... -->
                <div class="form-group">
                    <div>
                        <div>

                            <!-- Check for login error -->

                            <c:if test="${param.error != null}">
                                <%! static Logger logger = Logger.getLogger(SecurityConfig.class); %>
                                <% logger.fatal("Authentication failed " + request.getParameter("username")); %>
                                <div class="alert alert-danger">
                                    Invalid username or password.
                                </div>

                            </c:if>

                            <!-- Check for logout -->

                            <c:if test="${param.logout != null}">

                                <div class="alert alert-success">
                                    You have been logged out.
                                </div>

                            </c:if>

                        </div>
                    </div>
                </div>

                <!-- User name -->
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                    <input type="text" name="username" placeholder="username" class="form-control">
                </div>

                <!-- Password -->
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

                    <input type="password" name="password" placeholder="password" class="form-control">
                </div>

                <!-- Login/Submit Button -->
                <div class="form-group">

                    <button type="submit" class="btn btn-success" id="login-button">Login</button>

                </div>

            </form:form>

        </div>

    </div>

</div>

</body>
</html>