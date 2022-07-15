<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title"/></title>

    <meta name="description" content="Updates and statistics">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--begin::Fonts -->
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
    <script>
        WebFont.load({
            google: {"families": ["Poppins:300,400,500,600,700", "Roboto:300,400,500,600,700"]},
            active: function () {
                sessionStorage.fonts = true;
            }
        });
    </script>
    <c:set value='<%=(String)session.getAttribute("staticResouce")%>' var="staticResouce"/>
    <!--end::Fonts -->

    <!--begin::Page Vendors Styles(used by this page) -->
    <link href="${staticResouce }assets/vendors/custom/fullcalendar/fullcalendar.bundle.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/custom/datatables/datatables.bundle.css" rel="stylesheet"
          type="text/css"/>

    <!--end::Page Vendors Styles -->

    <!--begin:: Global Mandatory Vendors -->
    <link href="${staticResouce }assets/vendors/general/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet"
          type="text/css"/>

    <!--end:: Global Mandatory Vendors -->

    <!--begin:: Global Optional Vendors -->
    <link href="${staticResouce }assets/vendors/general/tether/dist/css/tether.css" rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css"
          rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/bootstrap-datetime-picker/css/bootstrap-datetimepicker.css"
          rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/bootstrap-timepicker/css/bootstrap-timepicker.css"
          rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.css"
          rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/bootstrap-select/dist/css/bootstrap-select.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/bootstrap-switch/dist/css/bootstrap3/bootstrap-switch.css"
          rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/select2/dist/css/select2.css" rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/ion-rangeslider/css/ion.rangeSlider.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/nouislider/distribute/nouislider.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/owl.carousel/dist/assets/owl.carousel.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/owl.carousel/dist/assets/owl.theme.default.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/dropzone/dist/dropzone.css" rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/summernote/dist/summernote.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/bootstrap-markdown/css/bootstrap-markdown.min.css"
          rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/animate.css/animate.css" rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/toastr/build/toastr.css" rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/morris.js/morris.css" rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/sweetalert2/dist/sweetalert2.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/general/socicon/css/socicon.css" rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/custom/vendors/line-awesome/css/line-awesome.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/custom/vendors/flaticon/flaticon.css" rel="stylesheet" type="text/css"/>
    <link href="${staticResouce }assets/vendors/custom/vendors/flaticon2/flaticon.css" rel="stylesheet"
          type="text/css"/>
    <link href="${staticResouce }assets/vendors/custom/vendors/fontawesome5/css/all.min.css" rel="stylesheet"
          type="text/css"/>

    <!--end:: Global Optional Vendors -->

    <!--begin::Global Theme Styles(used by all pages) -->

    <link href="${staticResouce }assets/css/demo4/style.bundle.css" rel="stylesheet" type="text/css"/>
    <!--end::Global Theme Styles -->

    <!--end::Layout Skins -->
    <link rel="shortcut icon" href="${staticResouce }assets/media/logos/favicon.ico"/>

    <!--begin:: Global Mandatory Vendors -->
    <script src="${staticResouce }assets/vendors/general/jquery/dist/jquery.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/popper.js/dist/umd/popper.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap/dist/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/js-cookie/src/js.cookie.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/moment/min/moment.min.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/tooltip.js/dist/umd/tooltip.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/perfect-scrollbar/dist/perfect-scrollbar.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/sticky-js/dist/sticky.min.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/wnumb/wNumb.js" type="text/javascript"></script>

    <!--end:: Global Mandatory Vendors -->

    <!-- end::Global Config -->


    <!--begin:: Global Optional Vendors -->
    <script src="${staticResouce }assets/vendors/general/jquery-form/dist/jquery.form.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/block-ui/jquery.blockUI.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/components/vendors/bootstrap-datepicker/init.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-datetime-picker/js/bootstrap-datetimepicker.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-timepicker/js/bootstrap-timepicker.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/components/vendors/bootstrap-timepicker/init.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-daterangepicker/daterangepicker.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-maxlength/src/bootstrap-maxlength.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/vendors/bootstrap-multiselectsplitter/bootstrap-multiselectsplitter.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-select/dist/js/bootstrap-select.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-switch/dist/js/bootstrap-switch.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/components/vendors/bootstrap-switch/init.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/select2/dist/js/select2.full.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/ion-rangeslider/js/ion.rangeSlider.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/typeahead.js/dist/typeahead.bundle.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/handlebars/dist/handlebars.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/inputmask/dist/jquery.inputmask.bundle.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/inputmask/dist/inputmask/inputmask.date.extensions.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/inputmask/dist/inputmask/inputmask.numeric.extensions.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/nouislider/distribute/nouislider.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/owl.carousel/dist/owl.carousel.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/autosize/dist/autosize.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/clipboard/dist/clipboard.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/dropzone/dist/dropzone.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/summernote/dist/summernote.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/markdown/lib/markdown.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-markdown/js/bootstrap-markdown.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/components/vendors/bootstrap-markdown/init.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/bootstrap-notify/bootstrap-notify.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/components/vendors/bootstrap-notify/init.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/jquery-validation/dist/jquery.validate.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/jquery-validation/dist/additional-methods.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/components/vendors/jquery-validation/init.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/toastr/build/toastr.min.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/raphael/raphael.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/morris.js/morris.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/chart.js/dist/Chart.bundle.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/vendors/bootstrap-session-timeout/dist/bootstrap-session-timeout.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/vendors/jquery-idletimer/idle-timer.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/waypoints/lib/jquery.waypoints.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/counterup/jquery.counterup.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/es6-promise-polyfill/promise.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/sweetalert2/dist/sweetalert2.min.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/components/vendors/sweetalert2/init.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/jquery.repeater/src/lib.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/jquery.repeater/src/jquery.input.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/jquery.repeater/src/repeater.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/general/dompurify/dist/purify.js" type="text/javascript"></script>

    <script src="${staticResouce }assets/ckeditor/ckeditor-inline.bundle.js" type="text/javascript"></script>
    <script src="${staticResouce }assets/ckeditor/ckeditor-inline.js" type="text/javascript"></script>
    <!--end:: Global Optional Vendors -->

    <!--begin::Page Vendors(used by this page) -->
    <script src="${staticResouce }assets/vendors/custom/datatables/datatables.bundle.js"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/app/custom/general/crud/forms/widgets/bootstrap-datepicker.js"
            type="text/javascript"></script>

    <!--end::Page Vendors -->
    <!--begin::Page Scripts(used by this page) -->

    <!--end::Page Scripts -->
    <!--begin::Page Scripts(used by this page) -->
    <!-- <script src="${staticResouce }assets/app/custom/general/dashboard.js" type="text/javascript"></script>
 -->
    <!--end::Page Scripts -->
    <!--begin::Global Theme Bundle(used by all pages) -->
    <script src="${staticResouce }assets/js/demo4/scripts.bundle.js" type="text/javascript"></script>

    <!--end::Global Theme Bundle -->

    <!--begin::Page Vendors(used by this page) -->
    <script src="${staticResouce }assets/vendors/custom/fullcalendar/fullcalendar.bundle.js"
            type="text/javascript"></script>
    <script src="//maps.google.com/maps/api/js?key=AIzaSyBTGnKT7dt597vo9QgeQ7BFhvSRP4eiMSM"
            type="text/javascript"></script>
    <script src="${staticResouce }assets/vendors/custom/gmaps/gmaps.js" type="text/javascript"></script>

    <!--end::Page Vendors -->

    <!--begin::Page Scripts(used by this page) -->
    <script src="${staticResouce }assets/js/demo4/pages/dashboard.js" type="text/javascript"></script>

</head>

<body style="background-image: url(${staticResouce }assets/media/demos/demo4/header.jpg); background-position: center top; background-size: 100% 350px;"
      class="kt-page--loading-enabled kt-page--loading kt-page--fixed kt-quick-panel--right kt-demo-panel--right kt-offcanvas-panel--right kt-header--fixed kt-header--minimize-menu kt-header-mobile--fixed kt-subheader--enabled kt-subheader--transparent">


<div class="kt-grid kt-grid--hor kt-grid--root">
    <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-page">

        <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor kt-wrapper" id="kt_wrapper">

            <header id="header">
                <tiles:insertAttribute name="header"/>
            </header>

            <section id="site-content">   <!-- overflow:scroll -->
                <tiles:insertAttribute name="body"/>
            </section>

            <footer id="footer">
                <tiles:insertAttribute name="footer"/>
            </footer>
        </div>
    </div>
</div>
<!-- begin::Scrolltop -->
<div id="kt_scrolltop" class="kt-scrolltop">
    <i class="fa fa-arrow-up"></i>
</div>

<!-- end::Scrolltop -->
</body>
<!-- end::Demo Panel -->

<!-- begin::Global Config(global config for global JS sciprts) -->
<script>
    var KTAppOptions = {
        "colors": {
            "state": {
                "brand": "#5d78ff",
                "dark": "#282a3c",
                "light": "#ffffff",
                "primary": "#5867dd",
                "success": "#34bfa3",
                "info": "#36a3f7",
                "warning": "#ffb822",
                "danger": "#fd3995"
            },
            "base": {
                "label": ["#c5cbe3", "#a1a8c3", "#3d4465", "#3e4466"],
                "shape": ["#f0f3ff", "#d9dffa", "#afb4d4", "#646c9a"]
            }
        }
    };
</script>


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
