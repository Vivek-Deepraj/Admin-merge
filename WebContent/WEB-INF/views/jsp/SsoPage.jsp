<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<%@include file="taglib_includes.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>

<head>
    <title>My Awesome Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
          integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>
<!--Coded with love by Mutiullah Samim-->
<style>
    /* Coded with love by Mutiullah Samim */
    body,
    html {
        margin: 0;
        padding: 0;
        height: 100%;
        background: #60a3bc !important;
    }

    .user_card {
        height: 400px;
        width: 350px;
        margin-top: auto;
        margin-bottom: auto;
        background: #f39c12;
        position: relative;
        display: flex;
        justify-content: center;
        flex-direction: column;
        padding: 10px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border-radius: 5px;

    }

    .brand_logo_container {
        position: absolute;
        height: 170px;
        width: 170px;
        top: -75px;
        border-radius: 50%;
        background: #60a3bc;
        padding: 10px;
        text-align: center;
    }

    .brand_logo {
        height: 150px;
        width: 150px;
        border-radius: 50%;
        border: 2px solid white;
    }

    .form_container {
        margin-top: 100px;
    }

    .login_btn {
        width: 100%;
        background: #c0392b !important;
        color: white !important;
    }

    .login_btn:focus {
        box-shadow: none !important;
        outline: 0px !important;
    }

    .login_container {
        padding: 0 2rem;
    }

    .input-group-text {
        background: #c0392b !important;
        color: white !important;
        border: 0 !important;
        border-radius: 0.25rem 0 0 0.25rem !important;
    }

    .input_user,
    .input_pass:focus {
        box-shadow: none !important;
        outline: 0px !important;
    }

    .custom-checkbox .custom-control-input:checked ~ .custom-control-label::before {
        background-color: #c0392b !important;
    }
</style>
<body>
<div class="container h-100">
    <div class="d-flex justify-content-center h-100">
        <div class="user_card">
            <div class="d-flex justify-content-center">
                <div class="brand_logo_container">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ2u59hTp4hsgP5M_iJVrA969zF4fRbXNm8xibn3yQtVA40711m"
                         class="brand_logo" alt="Logo">
                </div>
            </div>
            <%-- <c:url var="loginUrl" value="http://localhost:8087/AuthApp/login" /> --%>
            <c:url var="loginUrl" value="/oauth2/authorization/auth-service"/>
            <div class="d-flex justify-content-center form_container">

            </div>
            <h3>Admin SSO Custom Login - OAuth 2.0</h3><br><br><br>
            <a class="btn btn-primary" href="/admin-service/oauth2/authorization/auth-service">auth-service(AuthApp)</a>
            <div class="mt-4">
                <div class="d-flex justify-content-center links">
                    Don't have an account? <a href="#" class="ml-2">Sign Up</a>
                </div>
                <div class="d-flex justify-content-center links">
                    <a href="#">Forgot your password?</a>
                </div>

            </div>
            <!-- <div class="page-footer-custom"  style="color:white;float:left;padding-left:5px;">Powered By <a target="_blank" href="https://deeprajsoftware.com/"><span  style="color:white">Deepraj Software Services.</span></a> </div> -->
        </div>
    </div>
</div>
</body>
</html>
