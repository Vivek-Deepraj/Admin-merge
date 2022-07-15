<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Confirmation Page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div style="margin-left:250px;" class="generic-container">
    <%-- <%@include file="authheader.jsp" %> --%>

    <c:if test="${success ne null}">
        <div class="form-group">
            <div class="alert alert-success lead">
                    ${success}
            </div>
        </div>
    </c:if>
    <c:if test="${error ne null}">
        <div class="form-group">
            <div class="alert alert-danger lead">
                    ${error}
            </div>
        </div>
    </c:if> <c:if test="${fn:length(succslist) gt 0}">
    <div style="color:green;height:200px;overflow:scroll">
        <c:forEach items="${succslist}" var="sl">
            <tr>
                <td>
                    <div>${sl}</div>
                </td>
            </tr>
        </c:forEach>
    </div>
</c:if>
    <c:if test="${fn:length(errorlist) gt 0}">
        <div style="color:red;height:200px;overflow:scroll">
            <c:forEach items="${errorlist}" var="el">
                <tr>
                    <td>
                        <div>${el}</div>
                    </td>
                </tr>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>

</html>