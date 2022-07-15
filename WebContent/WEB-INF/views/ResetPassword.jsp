<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="page-content-wrapper">
    <div class="page-content">

        <div class="portlet box blue">
            <div class="portlet-title">
                <div class="caption">
                    <i class="fa fa-gift"></i>Reset Password
                </div>


            </div>

            <div class="portlet-body form">
                <!-- BEGIN FORM-->
                <c:set value="${user}" var="user"></c:set>
                <c:set value="${id}" var="id"></c:set>

                <c:if test="${msg eq 'Note Done'}">
                    <form:form action="setResetPassword" modelAttribute="user" method="post" name="form2" id="myForm"
                               class="form-horizontal">
                        <div class="form-body">
                            <input type="hidden" name="id" value="${id}">

                            <div class="form-group">
                                <label class="col-md-3 control-label">New Password</label>
                                <div class="col-md-4">
                                    <input type="password" name="newpassword" min="8" max="10" size="30"
                                           class="form-control" placeholder="New Password"/><font
                                        color="red"><form:errors path="newpassword"/></font>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">Confirm Password</label>
                                <div class="col-md-4">
                                    <input type="password" name="conpassword" min="8" max="10" size="30"
                                           class="form-control" placeholder="Confirm Password"/><font
                                        color="red"><form:errors
                                        path="conpassword"/></font> <%-- value="${user.conpassword}" --%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">Password Policy</label>
                                <div class="col-md-6">
                                    <table>
                                        <tr style="color:#FF4A4A">
                                            <font color="#FF4A4A">
                                                <div>1. Password must be 8 - 10 characters long.</div>
                                                <div>2. Password should contains 1 alphabet, 1 character and 1 special
                                                    character.
                                                </div>
                                                <div>3. User can not use last five passwords.</div>
                                                <div>4. Password will expire in 45 days automatically.</div>
                                                <div>5. Account would be locked after three unsuccessful attempts.</div>
                                                <div>6. User would be required to change the password on first login.
                                                </div>
                                            </font>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="form-actions fluid">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn blue">Submit</button>
                            </div>

                        </div>
                    </form:form>
                </c:if>
                <c:if test="${msg eq 'Done'}">
                    <font style="color: green"> Password Successfully Reset.</font>
                </c:if>


                <!-- END FORM-->
            </div>
        </div>
    </div>
</div>

<script>
    /* jQuery(document).ready(function() {

        Layout.init(); // init current layout

    }); */
</script>







