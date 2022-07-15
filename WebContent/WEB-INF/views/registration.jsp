<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasRole('ADMIN')" var="userRole"></sec:authorize>
<style type="text/css">
    .my-error-class {
        color: #FF4300; /* red */
    }
</style>

<script lang="javascript">
    var url = host + "/backendapi/";
    host = url + "checkuserid/";
    $.validator.addMethod('checkUserId', function (value, element) {

        var ans = "No";
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: host,
            dataType: "json",
            async: false,
            data: formToJSON(),
            success: function (data, textStatus, jqXHR) {

                ans = data.result;
            },
            error: function (jqXHR, textStatus, errorThrown) {
            }
        });
        return ans == 'No';
    }, 'User id is already exists');

    function formToJSON() {
        var userid = $("#userid").val();
        return JSON.stringify({
            "userid": userid
        });
    }

    function submitForm() {

        var validator = $("#myForm").validate({
            rules: {
                userid:
                    {
                        required: true,

                        checkUserId: {
                            depends: function (element) {
                                return true;
                            }
                        }

                    },
                firstName: "required",
                lastName: "required",
                joiningDate: "required",
                password: "required",
                contactNo: "required",
                email: {
                    required: true,

                    email: true

                }
            },
            errorElement: "span",
            errorClass: "my-error-class",
            messages: {

                userid:
                    {
                        required: " Please Enter User Id"
                    }
                ,
                firstName: " Please Enter First Name",
                lastName: " Please Enter Last Name",
                joiningDate: " Please Enter Joining Date",
                password: " Please Enter Password",
                contactNo: " Please Enter Contact No",
                email: {
                    required: " Please Enter Email Id"
                }
            }
        });
        if (validator.form()) {

            $('form#myForm').attr({action: 'saveuser'});
            $('form#myForm').attr({user: 'user'});
            $('form#myForm').attr({method: 'post'});

            $('form#myForm').submit();
        }
        return false;
    }

    function loadConsumer() {
        if ($("#userrole option:selected").html() == "CLIENT") {
            $("#condiv").show();
        } else {
            $("#condiv").hide();
        }
    }

    window.onload = function () {
        loadConsumer();
        $('#joiningDate').datepicker({
            format: 'dd-mm-yyyy'
        });
    }
</script>
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
                    Add User </a>

                <!-- <span class="kt-subheader__breadcrumbs-link kt-subheader__breadcrumbs-link--active">Active link</span> -->
            </div>
        </div>
    </div>

    <!-- end:: Subheader -->

    <!-- begin:: Content -->
    <div class="kt-content  kt-grid__item kt-grid__item--fluid" id="kt_content">
        <div class="row">
            <div class="col-lg-12">

                <!--begin::Portlet-->
                <div class="kt-portlet">
                    <div class="kt-portlet__head">
                        <div class="kt-portlet__head-label">
                            <h3 class="kt-portlet__head-title">
                                Add User
                            </h3>
                        </div>
                    </div>

                    <!--begin::Form-->
                    <form:form class="kt-form" action="saveuser" modelAttribute="user" method="post" name="form2"
                               id="myForm">

                        <div class="kt-portlet__body">
                            <div class="kt-section kt-section--first">
                                <div class="form-group">
                                    <label>User Id:</label>
                                    <input type="text" name="userid" id="userid" class="form-control"
                                           placeholder="Enter User Id"/>
                                </div>
                                <div class="form-group">
                                    <label>First Name:</label>
                                    <input type="text" name="firstName" id="firstName" class="form-control"
                                           placeholder="Enter First Name"/>
                                </div>
                                <div class="form-group">
                                    <label>Last Name:</label>
                                    <input type="text" name="lastName" id="lastName" class="form-control"
                                           placeholder="Enter Last Name"/>
                                </div>
                                <div class="form-group">
                                    <label>Joining Date:</label>
                                    <input type="text" name="joiningDate" id="joiningDate"
                                           class="form-control kt_datepicker_4_4" placeholder="Enter Joining Date"/>
                                </div>
                                <div class="form-group">
                                    <label>Password:</label>
                                    <input type="password" name="password" id="password" class="form-control"
                                           placeholder="Enter Password"/>
                                    <font color="red"><form:errors path="password"/></font>
                                </div>
                                <div class="form-group">
                                    <label>Password Policy:</label>
                                    <div class="kt-checkbox-list">
                                        <table>
                                            <tr style="color:#FF4A4A">
                                                <font color="#FF4A4A">
                                                    <div>1. Password must be 8 - 10 characters long.</div>
                                                    <div>2. Password should contains 1 alphabet, 1 character and 1
                                                        special character.
                                                    </div>
                                                    <div>3. User can not use last five passwords.</div>
                                                    <div>4. Password will expire in 45 days automatically.</div>
                                                    <div>5. Account would be locked after three unsuccessful attempts.
                                                    </div>
                                                    <div>6. User would be required to change the password on first
                                                        login.
                                                    </div>
                                                </font>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Contact No:</label>
                                    <input type="text" name="contactNo" id="contactNo" class="form-control"
                                           placeholder="Enter Contact No"/>
                                </div>
                                <div class="form-group">
                                    <label>Email address:</label>
                                    <input type="email" id="email" name="email" class="form-control"
                                           placeholder="Enter email">
                                </div>
                                <div class="form-group">
                                    <label>Role</label>
                                    <form:select path="userProfiles" items="${userProfile}" multiple="false"
                                                 id="userrole" itemValue="id" itemLabel="type"
                                                 class="form-control input-sm" onchange="loadConsumer()"/>
                                    <div class="has-error">
                                        <form:errors path="userProfiles" class="help-inline"/>
                                    </div>
                                </div>
                                    <%-- <div class="form-group" id="condiv">
                                     <label>Consumer No</label>
                                     <form:select path="consumerno" items="${consumernos}" multiple="multiple" cssClass="form-control m-bootstrap-select"/>
                                    </div>	 --%>
                            </div>
                        </div>
                        <div class="kt-portlet__foot">
                            <div class="kt-form__actions">
                                <input type="submit" onclick="submitForm();" class="btn btn-primary" value="Submit">
                            </div>
                        </div>
                    </form:form>

                    <!--end::Form-->
                </div>

                <!--end::Portlet-->
            </div>
        </div>
    </div>

    <!-- end:: Content -->
</div>
