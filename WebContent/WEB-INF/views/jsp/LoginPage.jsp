<!DOCTYPE html>
<%@include file="taglib_includes.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>

    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico"/>
    <link rel="icon" type="image/x-icon" href="images/favicon.ico"/>
    <link rel="shortcut icon" href="favicon.ico">

    <!-- Fonts START -->
    <link
            href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
            rel="stylesheet" type="text/css">
    <!-- Fonts END -->

    <!-- Global styles START -->
    <link href="${pageContext.request.contextPath}/assets/global/plugins/font-awesome/css/font-awesome.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/css/bootstrap.css"
          rel="stylesheet">
    <!-- Global styles END -->

    <!-- Page level plugin styles START -->
    <link href="${pageContext.request.contextPath}/assets/global/plugins/fancybox/source/jquery.fancybox.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/global/plugins/uniform/css/uniform.default.css"
          rel="stylesheet" type="text/css">
    <!-- Page level plugin styles END -->

    <!-- Theme styles START -->
    <link href="${pageContext.request.contextPath}/assets/global/css/components.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/frontend/layout/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/frontend/layout/css/style-responsive.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/frontend/layout/css/themes/red.css" rel="stylesheet"
          id="style-color">
    <link href="${pageContext.request.contextPath}/assets/frontend/layout/css/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/admin/pages/css/lock.min.css" rel="stylesheet"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-1.11.0.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/global/plugins/jquery-migrate-1.2.1.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/global/plugins/bootstrap/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/assets/frontend/layout/scripts/back-to-top.js"
            type="text/javascript"></script>
    <!-- END CORE PLUGINS -->
    <script src="${pageContext.request.contextPath}/assets/admin/pages/scripts/lock.min.js"
            type="text/javascript"></script>
    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script
            src="${pageContext.request.contextPath}/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"
            type="text/javascript"></script>
    <!-- pop up -->
    <script src="${pageContext.request.contextPath}/assets/global/plugins/uniform/jquery.uniform.min.js"
            type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/assets/frontend/layout/scripts/layout.js"
            type="text/javascript"></script>

    <style type="text/css">
        .list-unstyled.list-inline.pull-right a {
            text-decoration: none;
        }
    </style>
    <style>
        .login .content .input-icon {
            border-left: 2px solid #4b8df8 !important;
        }

        .form-control {
            color: black !important
        }

        .row {
            margin-right: 0px;
        }
    </style>
</head>

<body>
<div class="page-lock">
    <div class="page-logo">
        <a class="brand" href="index.html">
            <!-- <img src="static/images/banner.jpg" alt="logo" /> --> <h4 style="color:white">Deepraj Software
            Services</h4></a>
    </div>
    <div class="page-body">
        <div class="lock-head"> Welcome UISoft</div>
        <div class="lock-body">
            <div class="pull-left lock-avatar-block">
                <img src="static/images/banner.jpg" class="lock-avatar"></div>
            <c:url var="loginUrl" value="/login"/>
            <form class="lock-form pull-left" action="${loginUrl}" method="post">
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <div class="form-group">
                    <input class="form-control placeholder-no-fix" type="text" autocomplete="off"
                           placeholder="User Name" name="username"/></div>
                <div class="form-group">
                    <input class="form-control placeholder-no-fix" type="password" autocomplete="off"
                           placeholder="Password" name="password"/></div>
                <div class="form-actions">
                    <button type="submit" class="btn red uppercase">Login</button>
                </div>
            </form>
        </div>
        <div class="lock-bottom">
            <a href="forgotPassword.html">Forgot Password?</a>
        </div>
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                <%
                    Exception error = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
                    if (error != null)
                        out.write(error.getMessage());
                %>

            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-success">
                <p>You have been logged out successfully.</p>
            </div>
        </c:if>
    </div>
    <div class="page-footer-custom"> 2018 &copy; Deepraj Software Services.</div>
</div>


<script type="text/javascript">
    jQuery(document).ready(function () {
        Layout.init();
        Layout.initUniform();
        Layout.initTwitter();
    });
</script>


</body>

<!-- END BODY -->
</html>