<%@include file="taglib_includes.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<style>
    input {
        color: white;
    }
</style>
<script>
    function submitForm() {

        $.validator.addMethod("pwcheck",
            function (value, element) {
                return /^.*(?=.*[a-z,A-Z]{1})(?=.*[0-9]{1})(?=.*[@#$%!&-+]).*$/.test(value);
            });

        var validator = $("#myForm").validate({
            rules: {
                oldpassword: {
                    required: true
                },
                newpassword: {
                    required: true,
                    minlength: 8,
                    maxlength: 12,
                    pwcheck: true
                },
                conpassword: {
                    required: true,
                    equalTo: "#password-field"
                }
            },
            errorElement: "span",
            errorClass: "my-error-class",
            messages: {
                oldpassword: {
                    required: "Enter Old Password"
                },
                newpassword: {
                    required: "Enter New Password",
                    pwcheck: "Invalid Password ! check password policy"
                },
                conpassword: {
                    required: "Enter Confirm Password",
                    equalTo: "Password doesn't same"
                }
            }
        });
        if (validator.form()) {

            $('form#myForm').attr({action: 'setResetPasswordAdmin'});
            $('form#myForm').attr({modelAttribute: 'user'});
            $('form#myForm').attr({method: 'post'});

            $('form#myForm').submit();
        }
        return false;
    }
</script>

<!-- begin::Body -->
<body class="kt-header--fixed kt-header-mobile--fixed kt-subheader--fixed kt-subheader--enabled kt-subheader--solid kt-aside--enabled kt-aside--fixed kt-page--loading">

<!-- begin:: Page -->
<div class="kt-grid kt-grid--ver kt-grid--root">
    <div class="kt-grid kt-grid--hor kt-grid--root kt-login kt-login--v2 kt-login--signin" id="kt_login">
        <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor"
             style="background-image: url(assets/media/bg/bg-1.jpg);">
            <div class="kt-grid__item kt-grid__item--fluid kt-login__wrapper">
                <div class="kt-login__container">
                    <div class="kt-login__logo">
                        <a href="#">
                            <img src="static/images/jobships.png">
                        </a>
                    </div>
                    <div class="kt-login__signupp">
                        <div class="kt-login__head">
                            <h3 class="kt-login__title">Reset Password</h3>
                            <div class="kt-login__desc">Enter your credentials to reset your password:</div>
                        </div>
                        <!-- <form class="kt-login__form kt-form" action=""> -->
                        <form:form class="kt-login__form kt-form" action="setResetPasswordAdmin" modelAttribute="user"
                                   method="post" name="form2" id="myForm">
                            <c:if test="${error != null}">
                                <div class="kt-alert kt-alert--outline alert alert-danger alert-dismissible"
                                     role="alert">
                                    <button type="button" class="close" data-dismiss="alert"
                                            aria-label="Close"></button>
                                    <span>${error }</span></div>
                            </c:if>
                            <input type="hidden" name="uid" value="${uid }">
                            <div class="input-group">
                                <input class="form-control" type="password" placeholder="Old Password"
                                       name="oldpassword">
                                <c:set var="oldpasswordHasBindError">
                                    <form:errors path="oldpassword"/>
                                </c:set>
                            </div>
                            <br>
                            <c:if test="${oldpasswordHasBindError != ''}">
                                <div class="kt-alert kt-alert--outline alert alert-danger alert-dismissible"
                                     role="alert">
                                    <button type="button" class="close" data-dismiss="alert"
                                            aria-label="Close"></button>
                                    <span>${oldpasswordHasBindError }</span></div>
                            </c:if>
                            <div class="input-group">
                                <input class="form-control" type="password" value="" id="password-field"
                                       placeholder="New Password" name="newpassword">
                                <c:set var="newpasswordHasBindError">
                                    <form:errors path="newpassword"/>
                                </c:set>
                            </div>
                            <br>
                            <c:if test="${newpasswordHasBindError != ''}">
                                <div class="kt-alert kt-alert--outline alert alert-danger alert-dismissible"
                                     role="alert">
                                    <button type="button" class="close" data-dismiss="alert"
                                            aria-label="Close"></button>
                                    <span>${newpasswordHasBindError }</span></div>
                            </c:if>
                            <div class="input-group">
                                <input class="form-control" type="password" placeholder="Confirm Password"
                                       name="conpassword">
                                <c:set var="conpasswordHasBindError">
                                    <form:errors path="conpassword"/>
                                </c:set>
                            </div>
                            <br>
                            <c:if test="${conpasswordHasBindError != ''}">
                                <div class="kt-alert kt-alert--outline alert alert-danger alert-dismissible"
                                     role="alert">
                                    <button type="button" class="close" data-dismiss="alert"
                                            aria-label="Close"></button>
                                    <span>${conpasswordHasBindError }</span></div>
                            </c:if>
                            <div class="row kt-login__extra">
                                <div class="col kt-align-left">
                                    <button type="button" class="btn btn-pill" data-toggle="modal"
                                            data-target="#kt_modal_1"><i class="fa fa-lock"></i> Password Policy
                                    </button>
                                </div>
                            </div>
                            <div class="kt-login__actions">
                                <input type="submit" onclick="submitForm()" class="btn btn-pill kt-login__btn-primary"
                                       value="Reset Password"/>
                                <!-- <button id="kt_login_signup_submit" class="btn btn-pill kt-login__btn-primary">Sign Up</button> -->&nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/login" id="kt_login_forgot_cancell"
                                   class="btn btn-pill kt-login__btn-secondary">Cancel</a>
                            </div>
                            <!-- </form> -->
                        </form:form>
                    </div>

                    <div class="kt-login__account">
                        <div style="color:white" class="page-footer-custom"> 2019 &copy; Jobships.</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="kt_modal_1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Password Policy</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <div class="kt-checkbox-list">
                        <table>
                            <tr style="color:#FF4A4A">
                                <font color="#FF4A4A">
                                    <div>1. Password must be 8 - 10 characters long.</div>
                                    <div>2. Password should contains 1 alphabet, 1 character and 1 special character.
                                    </div>
                                    <div>3. User can not use last five passwords.</div>
                                    <div>4. Password will expire in 45 days automatically.</div>
                                    <div>5. Account would be locked after three unsuccessful attempts.</div>
                                    <div>6. User would be required to change the password on first login.</div>
                                </font>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- end:: Page -->

<!-- begin::Global Config(global config for global JS sciprts) -->

</body>

<!-- end::Body -->
</html>