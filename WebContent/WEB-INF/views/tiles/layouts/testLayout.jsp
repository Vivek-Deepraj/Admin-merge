<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>

<body>
<section id="sidemenu">
    <tiles:insertAttribute name="menu"/>
</section>

<header id="header">
    <tiles:insertAttribute name="header"/>
</header>

<section style="background-color:#487ead;overflow:scroll;" id="site-content">   <!-- overflow:scroll -->
    <tiles:insertAttribute name="body"/>
</section>

<footer id="footer">
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>
<script>
    function OpenWindowWithPost(url, windowoption, name, params) {

        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", url);
        form.setAttribute("target", name);
        for (var i in params) {
            if (params.hasOwnProperty(i)) {
                var input = document.createElement('input');
                input.type = 'hidden';
                input.name = i;
                input.value = params[i];
                form.appendChild(input);
            }
        }
        document.body.appendChild(form);
// alert(url)
        window.open(url, name, windowoption);
        //alert()
        form.submit();
        document.body.removeChild(form);
    }

    function sendingData() {
        return '<%=(String)session.getAttribute("token")%>';
    }
</script>
