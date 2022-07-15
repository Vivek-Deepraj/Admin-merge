<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>

<head>
    <%-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title" /></title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

    <link
    href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
    rel="stylesheet" type="text/css" />
<link
    href="assets/global/plugins/font-awesome/css/font-awesome.min.css"
    rel="stylesheet" type="text/css" />
<link
    href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css"
    rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css"
    rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/uniform/css/uniform.default.css"
    rel="stylesheet" type="text/css" />
<link
    href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"
    rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="assets/global/plugins/gritter/css/jquery.gritter.css"
    rel="stylesheet" type="text/css" />
<link
    href="assets/global/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css"
    rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="assets/global/plugins/bootstrap-datetimepicker/css/datetimepicker.css"/>


<link
    href="assets/global/plugins/fullcalendar/fullcalendar/fullcalendar.css"
    rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/jqvmap/jqvmap/jqvmap.css"
    rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="assets/admin/pages/css/tasks.css" rel="stylesheet"
    type="text/css" />
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="assets/global/css/components.css" rel="stylesheet"
    type="text/css" />
<link href="assets/global/css/plugins.css" rel="stylesheet"
    type="text/css" />
<link href="assets/admin/layout/css/layout.css" rel="stylesheet"
    type="text/css" />
<link href="assets/admin/layout/css/themes/light.css"
    rel="stylesheet" type="text/css" id="style_color" />
<link href="assets/admin/layout/css/custom.css" rel="stylesheet"
    type="text/css" />
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css"
    rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
    href="assets/global/plugins/bootstrap-datepicker/css/datepicker3.css" />
<link href="assets/global/css/components.css" rel="stylesheet"
    type="text/css" />

<link
    href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
    rel="stylesheet" type="text/css" />
<link
    href="assets/global/plugins/font-awesome/css/font-awesome.min.css"
    rel="stylesheet" type="text/css" />
<link
    href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css"
    rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/bootstrap/css/bootstrap.min.css"
    rel="stylesheet" type="text/css" />
<link href="assets/global/plugins/uniform/css/uniform.default.css"
    rel="stylesheet" type="text/css" />
<link
    href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"
    rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css"
    href="assets/global/plugins/select2/select2.css" />
<link rel="stylesheet" type="text/css"
    href="assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css" />
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="assets/global/css/components.css" rel="stylesheet"
    type="text/css" />
<link href="assets/global/css/plugins.css" rel="stylesheet"
    type="text/css" />
<link href="assets/admin/layout/css/layout.css" rel="stylesheet"
    type="text/css" />
<link id="style_color"
    href="assets/admin/layout/css/themes/light.css" rel="stylesheet"
    type="text/css" />
<link href="assets/admin/layout/css/custom.css" rel="stylesheet"
    type="text/css" />
    <script src="assets/global/plugins/jquery-1.11.0.min.js" type="text/javascript"></script>
    <script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="assets/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->


<script src="assets/global/plugins/respond.min.js"></script>
<script src="assets/global/plugins/excanvas.min.js"></script>

<script src="assets/global/plugins/jquery-1.11.0.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/jquery-migrate-1.2.1.min.js"
    type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script
    src="assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/jquery.blockui.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/jquery.cokie.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/uniform/jquery.uniform.min.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
    type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/flot/jquery.flot.resize.min.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/flot/jquery.flot.categories.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/jquery.pulsate.min.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/bootstrap-daterangepicker/moment.min.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/bootstrap-daterangepicker/daterangepicker.js"
    type="text/javascript"></script>
<script type="text/javascript" src="assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
<script
    src="assets/global/plugins/fullcalendar/fullcalendar/fullcalendar.min.js"
    type="text/javascript"></script>
<script
    src="assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/jquery.sparkline.min.js"
    type="text/javascript"></script>
<script src="assets/global/plugins/gritter/js/jquery.gritter.js"
    type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="assets/global/scripts/metronic.js"
    type="text/javascript"></script>
<script src="assets/admin/layout/scripts/layout.js"
    type="text/javascript"></script>
<script src="assets/admin/layout/scripts/quick-sidebar.js"
    type="text/javascript"></script>
<script src="assets/admin/pages/scripts/index.js"
    type="text/javascript"></script>
<script src="assets/admin/pages/scripts/tasks.js"
    type="text/javascript"></script>

<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js"
    type="text/javascript"></script>
<script type="text/javascript"
    src="assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="assets/global/scripts/metronic.js"
    type="text/javascript"></script>
<script src="assets/admin/pages/scripts/components-pickers.js"></script>


<link rel="stylesheet" type="text/css" href="assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="assets/global/plugins/jquery-multi-select/css/multi-select.css"/>

<script src="assets/admin/pages/scripts/components-dropdowns.js"></script>
<script type="text/javascript" src="assets/global/plugins/select2/select2.js"></script>
<script type="text/javascript" src="assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="assets/global/plugins/jquery-multi-select/js/jquery.multi-select.js"></script>
<script type="text/javascript"
    src="assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
    src="assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script src="assets/admin/pages/scripts/table-managed.js"></script>
<script src="assets/admin/pages/scripts/validation.js"></script>
 <script>
                jQuery(document).ready(function() {

                    Metronic.init(); // init metronic core componets
                    Layout.init(); // init layout
                    QuickSidebar.init(); // init quick sidebar
                    Index.init();
                    Index.initDashboardDaterange();
                    Index.initJQVMAP(); // init index page's custom scripts
                    Index.initCalendar(); // init index page's custom scripts
                    Index.initCharts(); // init index page's custom scripts
                    Index.initChat();
                    Index.initMiniCharts();
                    Index.initIntro();
                    Metronic.init();
                    Tasks.initDashboardWidget();
                    ComponentsPickers.init();



                });
            </script>
<style>

td{
font-family: "Open Sans",sans-serif;
    font-size:13px;
    color:#2C5285;
}
</head>
<style>
#site-content2 {
    width: 100%;
    height: 100%;
    overflow: auto;
   
    z-index: 20;
    position: fixed;
    min-height: 600px;
    margin-top:0%;
    margin-bottom:10%;
  
   
}
</style> --%>

        <%
String ip=request.getServerName();
//ip = "172.104.62.103";
int port=request.getServerPort();
%>
    <script lang="javascript" type="text/javascript">
        var ip = '<%=ip%>';
        var port = '<%=port%>';
        var contextpath = '<%=request.getContextPath()%>';
        var host = 'http://' + ip + ':' + port + contextpath;
        var hostws = 'ws://' + ip + ':' + port + contextpath;
    </script>

<body>


<section id="site-content2">
    <tiles:insertAttribute name="body"/>
</section>

</body>
</html>
<script>
    function sendingData() {
        return '<%=(String)session.getAttribute("token")%>';
    }
</script>

<!--
<script>
function OpenWindowWithPostNested(url, windowoption, name, params)
{
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
winn = window.open("post.htm", name, windowoption);
form.submit();
document.body.removeChild(form);
}
</script> -->