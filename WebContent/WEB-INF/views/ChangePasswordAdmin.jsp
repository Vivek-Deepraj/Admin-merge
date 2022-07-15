<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<sec:authorize access="hasRole('ADMIN')" var="userRole"></sec:authorize>
<%
    String email = (String) session.getAttribute("wsloginMailId");
%>
<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-grid--stretch">
    <div class="kt-container kt-body  kt-grid kt-grid--ver" id="kt_body">
        <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">
            <div class="kt-subheader   kt-grid__item" id="kt_subheader">
                <div class="kt-subheader__main">
                    <h3 class="kt-subheader__title">Candidate</h3>
                    <div class="kt-subheader__breadcrumbs">
                        <a href="#" class="kt-subheader__breadcrumbs-home"><i class="flaticon2-shelter"></i></a>
                        <span class="kt-subheader__breadcrumbs-separator"></span>
                        <a href="" class="kt-subheader__breadcrumbs-link">
                            Candidate </a>
                        <span class="kt-subheader__breadcrumbs-separator"></span>
                        <a href="" class="kt-subheader__breadcrumbs-link">
                            Candidate Profile </a>
                    </div>
                </div>
                <div class="kt-subheader__toolbar">
                    <div class="kt-subheader__wrapper">

                    </div>
                </div>
            </div>
            <div class="kt-content kt-grid__item kt-grid__item--fluid">
                <div class="row">
                    <div class="col-xl-6">
                        <div class="kt-portlet kt-portlet--height-fluid">
                            <div class="kt-portlet__head">
                                <div class="kt-portlet__head-label">
                                    <h3 class="kt-portlet__head-title">
                                        Change Password
                                    </h3>
                                </div>
                                <div class="kt-portlet__head-toolbar">

                                </div>
                            </div>
                            <div class="kt-portlet__body kt-portlet__body--fluid">
                                <c:set value="${user}" var="user"></c:set>
                                <!--begin::Form-->
                                <form:form class="kt-form" action="setChangedPasswordAdmin" modelAttribute="user"
                                           method="post" name="form2" id="myForm">
                                    <input type="hidden" name="emailID" value="<%=email%>">
                                    <div class="kt-portlet__body">
                                        <div class="kt-section kt-section--first">
                                            <div class="form-group">
                                                <label>Old Password:</label>
                                                <input type="password" name="oldpassword" id="oldpassword"
                                                       class="form-control" placeholder="Enter Old Password"/>
                                                <font color="red"><form:errors path="oldpassword"/></font>
                                            </div>
                                            <div class="form-group">
                                                <label>New Password:</label>
                                                <input type="password" name="newpassword" id="newpassword" min="8"
                                                       max="10" class="form-control" placeholder="Enter New Password"/>
                                                <font color="red"><form:errors path="newpassword"/></font>
                                            </div>
                                            <div class="form-group">
                                                <label>Confirm Password:</label>
                                                <input type="password" name="conpassword" id="conpassword" min="8"
                                                       max="10" class="form-control"
                                                       placeholder="Confirm New Password"/>
                                                <font color="red"><form:errors path="conpassword"/></font>
                                            </div>
                                            <div class="form-group">
                                                <label>Password Policy:</label>
                                                <div class="kt-checkbox-list">
                                                    <table>
                                                        <tr style="color:#FF4A4A">
                                                            <font color="#FF4A4A">
                                                                <div>1. Password must be 8 - 10 characters long.</div>
                                                                <div>2. Password should contains 1 alphabet, 1 character
                                                                    and 1 special character.
                                                                </div>
                                                                <div>3. User can not use last five passwords.</div>
                                                                <div>4. Password will expire in 45 days automatically.
                                                                </div>
                                                                <div>5. Account would be locked after three unsuccessful
                                                                    attempts.
                                                                </div>
                                                                <div>6. User would be required to change the password on
                                                                    first login.
                                                                </div>
                                                            </font>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${msg eq 'Done'}">
                                        <div class="alert alert-success">
                                            <p>Password changed Successfully.</p>
                                        </div>
                                    </c:if>
                                    <div class="kt-portlet__foot">
                                        <div class="kt-form__actions">
                                            <input type="submit" class="btn btn-primary" value="Submit">
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>