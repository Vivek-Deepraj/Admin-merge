<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%
    String ip = request.getServerName();
    int port = request.getServerPort();
%>
<style type="text/css">
    .my-error-class {
        color: #FF4300; /* red */
    }
</style>
<script type="text/javascript">
    var ip = '<%=ip%>';
    var port = '<%=port%>';
    var contextpath = '<%=request.getContextPath()%>';

    var host = 'http://' + ip + ':' + port + contextpath;
    var getcaturl = host + "/api/getUserDataService";
    var getperurl = host + "/api/getUserPermissionDataService";

    function submitForm() {

        var validator = $("#myForm").validate({
            rules: {
                firstName: {
                    required: true
                },
                lastName: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                contactNo: {
                    required: true,
                    minlength: 10,
                    maxlength: 12,
                    digits: true
                }
            },
            errorElement: "span",
            errorClass: "my-error-class",
            messages: {
                firstName: {
                    required: "Enter First Name"
                },
                lastName: {
                    required: "Enter Last Name"
                },
                email: {
                    required: "Enter Email Address",
                    email: "Invalid Email Address"
                },
                contactNo: {
                    required: "Enter Contact No"
                }
            }
        });
        if (validator.form()) {

            //$('#userUpdate').prop('disabled',true);
            var formData = new FormData($('#myForm')[0]);
            // Ajax call
            var ajaxReq = $.ajax({
                url: 'updateUserDetails',
                type: 'POST',
                data: formData,
                cache: false,
                contentType: false,
                processData: false
            });

            // Called on success
            ajaxReq.done(function (msg) {
                var alert = $('<div class="kt-alert kt-alert--outline alert alert-success alert-dismissible" role="alert">' +
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>' +
                    '	<span></span></div>');
                $('form#myForm').find('.alert').remove();
                alert.prependTo($('form#myForm'));
                alert.find('span').html("User Successfully updated.");
            });

            // Called on failure
            ajaxReq.fail(function (jqXHR) {
                var alert = $('<div class="kt-alert kt-alert--outline alert alert-danger alert-dismissible" role="alert">' +
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>' +
                    '	<span></span></div>');
                $('form#myForm').find('.alert').remove();
                alert.prependTo($('form#myForm'));
                alert.find('span').html(jqXHR.responseText + '(' + jqXHR.status +
                    ' - ' + jqXHR.statusText + ')');
            });

        }
        return false;
    }


    function submitFormRP() {

        $.validator.addMethod("pwcheck",
            function (value, element) {
                return /^.*(?=.*[a-z,A-Z]{1})(?=.*[0-9]{1})(?=.*[@#$%!&-+]).*$/.test(value);
            });

        var validator = $("#myFormcp").validate({
            rules: {
                password: {
                    required: true,
                    minlength: 8,
                    maxlength: 12,
                    pwcheck: true
                },
                rpassword: {
                    required: true,
                    equalTo: "#password-field"
                }
            },
            errorElement: "span",
            errorClass: "my-error-class",
            messages: {
                password: {
                    required: "Enter Password",
                    pwcheck: "Invalid Password ! check password policy"
                },
                rpassword: {
                    required: "Enter Confirm Password",
                    equalTo: "Password doesn't same"
                }
            }
        });
        if (validator.form()) {

            //$('#userUpdate').prop('disabled',true);
            var formData = new FormData($('#myFormcp')[0]);
            // Ajax call
            var ajaxReq = $.ajax({
                url: 'updateUserPasswordDetails',
                type: 'POST',
                data: formData,
                cache: false,
                contentType: false,
                processData: false
            });

            // Called on success
            ajaxReq.done(function (msg) {
                var alert = $('<div class="kt-alert kt-alert--outline alert alert-success alert-dismissible" role="alert">' +
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>' +
                    '	<span></span></div>');
                $('form#myFormcp').find('.alert').remove();
                alert.prependTo($('form#myFormcp'));
                alert.find('span').html("User Password Successfully updated.");
            });

            // Called on failure
            ajaxReq.fail(function (jqXHR) {
                var alert = $('<div class="kt-alert kt-alert--outline alert alert-danger alert-dismissible" role="alert">' +
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>' +
                    '	<span></span></div>');
                $('form#myFormcp').find('.alert').remove();
                alert.prependTo($('form#myFormcp'));
                alert.find('span').html(jqXHR.responseText + '(' + jqXHR.status +
                    ' - ' + jqXHR.statusText + ')');
            });
        }
        return false;
    }


    function submitFormGP() {

        var validator = $("#myFormsp").validate({
            rules: {},
            errorElement: "span",
            errorClass: "my-error-class",
            messages: {}
        });
        if (validator.form()) {

            //$('#userUpdate').prop('disabled',true);
            var formData = new FormData($('#myFormsp')[0]);
            // Ajax call
            var ajaxReq = $.ajax({
                url: 'setPermissionsToUser',
                type: 'POST',
                data: formData,
                cache: false,
                contentType: false,
                processData: false
            });

            // Called on success
            ajaxReq.done(function (msg) {
                var alert = $('<div class="kt-alert kt-alert--outline alert alert-success alert-dismissible" role="alert">' +
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>' +
                    '	<span></span></div>');
                $('form#myFormsp').find('.alert').remove();
                alert.prependTo($('form#myFormsp'));
                alert.find('span').html("Permissions allocated successfully.");
            });

            // Called on failure
            ajaxReq.fail(function (jqXHR) {
                var alert = $('<div class="kt-alert kt-alert--outline alert alert-danger alert-dismissible" role="alert">' +
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>' +
                    '	<span></span></div>');
                $('form#myFormsp').find('.alert').remove();
                alert.prependTo($('form#myFormsp'));
                alert.find('span').html(jqXHR.responseText + '(' + jqXHR.status +
                    ' - ' + jqXHR.statusText + ')');
            });
        }
        return false;
    }
</script>
<sec:authorize access="hasRole('ADMIN')" var="userRole"></sec:authorize>
<script src="assets/app/custom/general/crud/datatables/data-sources/ajax-server-side.js"
        type="text/javascript"></script>

<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">

    <!-- begin:: Subheader -->
    <div class="kt-subheader   kt-grid__item" id="kt_subheader">
        <div class="kt-subheader__main">
            <h3 class="kt-subheader__title">
                Admin </h3>
            <span class="kt-subheader__separator kt-hidden"></span>
            <div class="kt-subheader__breadcrumbs">
                <a href="#" class="kt-subheader__breadcrumbs-home"><i class="flaticon2-shelter"></i></a>
                <span class="kt-subheader__breadcrumbs-separator"></span>
                <a href="" class="kt-subheader__breadcrumbs-link">
                    Users List </a>

                <!-- <span class="kt-subheader__breadcrumbs-link kt-subheader__breadcrumbs-link--active">Active link</span> -->
            </div>
        </div>
    </div>

    <!-- end:: Subheader -->

    <!-- begin:: Content -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">
        <div class="kt-portlet kt-portlet--mobile">
            <div class="kt-portlet__head kt-portlet__head--lg">
                <div class="kt-portlet__head-label">
										<span class="kt-portlet__head-icon">
											<i class="kt-font-brand flaticon2-line-chart"></i>
										</span>
                    <h3 class="kt-portlet__head-title">
                        Users List
                    </h3>
                </div>
                <div class="kt-portlet__head-toolbar">
                    <div class="kt-portlet__head-wrapper">
                        <div class="kt-portlet__head-actions">
                            &nbsp;
                            <a href="generate/userlistexport.html" class="btn btn-brand btn-elevate btn-icon-sm">
                                <i class="la la-download"></i>
                                Export
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="kt-portlet__body">

                <!--begin: Search Form -->
                <form id="dt_filter_params" class="kt-form kt-form--fit kt-margin-b-20">
                    <div class="row kt-margin-b-20">
                        <div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
                            <label>User Id:</label>
                            <input type="text" name="userid" id="userid" class="form-control kt-input"
                                   placeholder="User Id" data-col-index="4">
                        </div>
                        <div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
                            <label>User Email:</label>
                            <input type="text" name="email" id="email" class="form-control kt-input"
                                   placeholder="User Email" data-col-index="4">
                        </div>
                        <div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
                            <label>User Type:</label>
                            <select name="urole" id="urole" class="form-control kt-input" data-col-index="7">
                                <option value="">--Select User Type--</option>
                                <c:forEach items="${userProfile}" var="dm">
                                    <option value="${dm.id}">${dm.type}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-lg-3 kt-margin-b-10-tablet-and-mobile">
                            <label>Joining Date:</label>
                            <input type="text" class="form-control kt_datepicker_4_4" name="joiningDate"
                                   id="joiningDate" placeholder="Joining Date">
                        </div>
                    </div>
                </form>

                <!--begin: Datatable -->


                <div id="kt_table_1_wrapper" class="dataTables_wrapper dt-bootstrap4">
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-striped- table-bordered table-hover table-checkable"
                                   id="kt_table_1">
                                <thead>
                                <tr>
                                    <th>User Id</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Contact No</th>
                                    <th>Joining Date</th>
                                    <th>Last Login</th>
                                    <th>Role</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>

                    <!--end: Datatable -->
                </div>

                <!--end: Datatable -->
            </div>
        </div>
    </div>

    <!-- end:: Content -->
</div>


<div class="modal fade" id="kt_modal_1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">User Profile</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">
                        <!--begin::Portlet-->
                        <div class="kt-portlet">
                            <div class="kt-portlet__body kt-portlet__body--fit">
                                <div class="row row-no-padding row-col-separator-xl">
                                    <div class="col-md-6 col-lg-6 col-xl-2">

                                        <!--begin:: Widgets/Stats2-1 -->
                                        <div class="kt-widget1">
                                            <div class="kt-widget1__item">
                                                <div class="kt-widget1__info">
                                                    <h3 class="kt-widget1__title">User Name</h3>
                                                    <span class="kt-widget1__desc"><span id="username"> </span></span>
                                                </div>
                                                <span class="kt-widget1__number kt-font-brand"></span>
                                            </div>
                                            <div class="kt-widget1__item">
                                                <div class="kt-widget1__info">
                                                    <h3 class="kt-widget1__title">User Id</h3>
                                                    <span class="kt-widget1__desc"><span id="useridd"> </span></span>
                                                </div>
                                                <span class="kt-widget1__number kt-font-danger"></span>
                                            </div>
                                            <div class="kt-widget1__item">
                                                <div class="kt-widget1__info">
                                                    <h3 class="kt-widget1__title">Email</h3>
                                                    <span class="kt-widget1__desc"><span id="useremail"> </span></span>
                                                </div>
                                                <span class="kt-widget1__number kt-font-success"></span>
                                            </div>
                                        </div>

                                        <!--end:: Widgets/Stats2-1 -->
                                    </div>
                                    <div class="col-md-6 col-lg-6 col-xl-2">

                                        <!--begin:: Widgets/Stats2-2 -->
                                        <div class="kt-widget1">
                                            <div class="kt-widget1__item">
                                                <div class="kt-widget1__info">
                                                    <h3 class="kt-widget1__title">Joining Date</h3>
                                                    <span class="kt-widget1__desc"><span id="userjdate"> </span></span>
                                                </div>
                                                <span class="kt-widget1__number kt-font-success"></span>
                                            </div>
                                            <div class="kt-widget1__item">
                                                <div class="kt-widget1__info">
                                                    <h3 class="kt-widget1__title">Account Status</h3>
                                                    <span class="kt-widget1__desc"><span id="userstatus"> </span></span>
                                                </div>
                                                <span class="kt-widget1__number kt-font-info"></span>
                                            </div>
                                            <div class="kt-widget1__item">
                                                <div class="kt-widget1__info">
                                                    <h3 class="kt-widget1__title">Contact No</h3>
                                                    <span class="kt-widget1__desc"><span
                                                            id="usercontact"> </span></span>
                                                </div>
                                                <span class="kt-widget1__number kt-font-warning"></span>
                                            </div>
                                        </div>

                                        <!--end:: Widgets/Stats2-2 -->
                                    </div>
                                </div>
                            </div>

                            <!--end::Form-->
                        </div>

                        <!--end::Portlet-->
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="kt_modal_2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Edit User Profile</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <form class="kt-login__form kt-form" id="myForm" action="">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <!--begin::Portlet-->
                            <div class="kt-portlet">

                                <div class="kt-portlet__body kt-portlet__body--fit">
                                    <div class="row row-no-padding row-col-separator-xl">
                                        <div class="col-md-6 col-lg-6 col-xl-2">
                                            <!--begin:: Widgets/Stats2-1 -->
                                            <div class="kt-widget1">
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">First Name</h3>
                                                        <span class="kt-widget1__desc"><input type="text"
                                                                                              name="firstName"
                                                                                              id="firstName"
                                                                                              class="form-control"/></span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-brand"></span>
                                                </div>
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">Email</h3>
                                                        <span class="kt-widget1__desc"><input type="text" name="email"
                                                                                              id="emaill"
                                                                                              class="form-control"/></span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-success"></span>
                                                </div>
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">Account Status</h3>
                                                        <span class="kt-widget1__desc">
														<Select name="status" id="status" class="form-control">
														<option value="yes">Active</option>
														<option value="no">InActive</option>
														</Select></span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-info"></span>
                                                </div>
                                            </div>
                                            <!--end:: Widgets/Stats2-1 -->
                                        </div>
                                        <div class="col-md-6 col-lg-6 col-xl-2">
                                            <!--begin:: Widgets/Stats2-2 -->
                                            <div class="kt-widget1">
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">Last Name</h3>
                                                        <span class="kt-widget1__desc"><input type="text"
                                                                                              name="lastName"
                                                                                              id="lastName"
                                                                                              class="form-control"/></span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-brand"></span>
                                                </div>
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">Contact No</h3>
                                                        <span class="kt-widget1__desc"><input type="text"
                                                                                              name="contactNo"
                                                                                              id="contactNo"
                                                                                              class="form-control"/></span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-warning"></span>
                                                </div>
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">Role</h3>
                                                        <span class="kt-widget1__desc">
															<select name="userrole" id="userrole"
                                                                    class="form-control kt-input" data-col-index="7">
																<c:forEach items="${userProfile}" var="dm">
                                                                    <option value="${dm.id}">${dm.type}</option>
                                                                </c:forEach>
															</select>
														</span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-success"></span>
                                                </div>
                                            </div>
                                            <!--end:: Widgets/Stats2-2 -->
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" id="id" name="id">
                                <!--end::Form-->
                            </div>
                            <!--end::Portlet-->
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" onclick="submitForm()" id="userUpdate" class="btn btn-primary">Update User
                    </button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="kt_modal_3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Reset User Password</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <form class="kt-login__form kt-form" id="myFormcp" action="">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <!--begin::Portlet-->
                            <div class="kt-portlet">

                                <div class="kt-portlet__body kt-portlet__body--fit">
                                    <div class="row row-no-padding row-col-separator-xl">
                                        <div class="col-md-12 col-lg-12 col-xl-4">
                                            <!--begin:: Widgets/Stats2-1 -->
                                            <div class="kt-widget1">
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">New Password</h3>
                                                        <span class="kt-widget1__desc"><input class="form-control"
                                                                                              type="password"
                                                                                              id="password-field"
                                                                                              name="password"></span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-brand"></span>
                                                </div>
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">Confirm Password</h3>
                                                        <span class="kt-widget1__desc"><input class="form-control"
                                                                                              type="password"
                                                                                              name="rpassword"></span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-success"></span>
                                                </div>
                                                <div class="kt-widget1__item">
                                                    <div class="kt-widget1__info">
                                                        <h3 class="kt-widget1__title">Password Policy</h3>
                                                        <span class="kt-widget1__desc">
														<div class="kt-checkbox-list">
														<table>
																	<tr style="color:#FF4A4A">
																		 <font color="#FF4A4A"> 
										                                 <div>1. Password must be 8 - 10 characters long.</div>
										                                 <div>2. Password should contains 1 alphabet, 1 character and 1 special character.</div>
										                                 <div>3. User can not use last five passwords.</div>
										                                 <div>4. Password will expire in 45 days automatically.</div>
										                                 <div>5. Account would be locked after three unsuccessful attempts.</div>
										                                 <div>6. User would be required to change the password on first login.</div>
										                                 </font>
                                                                        </td>
										                            </tr>
														</table>
														</div>
														</span>
                                                    </div>
                                                    <span class="kt-widget1__number kt-font-success"></span>
                                                </div>
                                            </div>
                                            <!--end:: Widgets/Stats2-1 -->
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" id="idcp" name="id">
                                <!--end::Form-->
                            </div>
                            <!--end::Portlet-->
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" onclick="submitFormRP()" id="userPasswordReset" class="btn btn-primary">Update
                        Password
                    </button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="kt_modal_4" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" role="document">
        <div style="margin-left:-100px;width:750px;" class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">User Permissions</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <form class="kt-login__form kt-form" id="myFormsp" action="">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <!--begin::Portlet-->
                            <div class="kt-portlet">

                                <div class="kt-portlet__body kt-portlet__body--fit">
                                    <div class="row row-no-padding row-col-separator-xl">
                                        <div class="col-md-12 col-lg-12 col-xl-4">
                                            <!--begin:: Widgets/Stats2-1 -->
                                            <div id="dataFromApi" class="kt-widget1">

                                            </div>
                                            <!--end:: Widgets/Stats2-1 -->
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" id="idsp" name="id">
                                <!--end::Form-->
                            </div>
                            <!--end::Portlet-->
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" onclick="submitFormGP()" id="userGrantPermission" class="btn btn-primary">
                        Grant Permissions
                    </button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    function getUserDetails(id) {

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: getcaturl,
            dataType: "json",
            data: JSON.stringify({
                "id": id,
                "token": sendingData()
            }),
            success: function (data, textStatus, jqXHR) {
                var json = JSON.stringify(data);
                //alert(json)
                var ooo = JSON.parse(json);
                $("#username").html(ooo.name);
                $("#useremail").html(ooo.email);
                $("#useridd").html(ooo.userid);
                $("#userjdate").html(ooo.joiningdate);
                $("#userstatus").html(ooo.status);
                $("#usercontact").html(ooo.contactno);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(' error: ' + textStatus);
            }
        });

    }

    function editUserDetails(id, urole) {
        //alert('idddddddd')
        $('form#myForm').find('.alert').remove();
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: getcaturl,
            dataType: "json",
            data: JSON.stringify({
                "id": id,
                "token": sendingData()
            }),
            success: function (data, textStatus, jqXHR) {
                var json = JSON.stringify(data);
                //alert(json)
                var ooo = JSON.parse(json);
                $("#id").val(id);
                $("#firstName").val(ooo.fname);
                $("#lastName").val(ooo.lname);
                $("#emaill").val(ooo.email);
                $("#contactNo").val(ooo.contactno);
                if (ooo.status == 'Active')
                    $("select#status").prop('selectedIndex', 0);
                if (ooo.status == 'Inactive')
                    $("select#status").prop('selectedIndex', 1);
                $("#userrole option").each(function () {
                    if ($(this).html() == urole)
                        $(this).prop('selected', true);
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(' error: ' + textStatus);
            }
        });

    }

    function cPass(id) {
        //alert('idddddddd')
        $("#idcp").val(id);
        $('form#myFormcp').find('.alert').remove();
    }

    function gPerm(id) {
        //alert('idddddddd')
        $('form#myFormsp').find('.alert').remove();
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: getperurl,
            dataType: "json",
            data: JSON.stringify({
                "id": id,
                "token": sendingData()
            }),
            success: function (data, textStatus, jqXHR) {
                var json = JSON.stringify(data);
                var count = 0;
                //alert(json)
                //var ooo = JSON.parse(json);
                $('#dataFromApi').html('');
                $("#idsp").val(id);
                $.each(JSON.parse(json), function (idx, obj) {
                    var mainmenu = idx;
                    var appdata = "";
                    var idxdata = JSON.stringify(obj);
                    $.each(JSON.parse(idxdata), function (idx, obj1) {
                        var submenu = obj1[0];
                        var murl = obj1[1];
                        var check = "";
                        if (obj1[2] == 'true')
                            check = "checked";
                        count++;
                        appdata = appdata + '<label class="kt-checkbox"><input type="checkbox" name="urls" value="' + murl + '" ' + check + '> ' + submenu + ' <span></span></label>';
                    });
                    $('#dataFromApi').append('<div class="kt-widget1__item"><div class="kt-widget1__info">' +
                        '<h3 class="kt-widget1__title">' + mainmenu + '</h3>' +
                        '<span class="kt-widget1__desc"><div class="kt-checkbox-inline">' + appdata + '</div></span>' +
                        '</div><span class="kt-widget1__number kt-font-success"></span></div>');

                });

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(' error: ' + textStatus);
            }
        });
    }

    function setActive(id, userid) {
        var alertValue = confirm("Do you want to change status for user " + userid);
        if (alertValue == true) {
            var host = "getActive.html";
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: host,
                dataType: "json",
                async: false,
                data: JSON.stringify({
                    "id": id,
                    "datat": sendingData()
                }),
                success: function (data, textStatus, jqXHR) {
                    //dt_table.clear().draw();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                }
            });
        }
    }
</script>
		