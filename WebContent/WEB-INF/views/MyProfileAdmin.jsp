<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-grid--stretch">
    <div class="kt-container kt-body  kt-grid kt-grid--ver" id="kt_body">
        <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">
            <div class="kt-subheader   kt-grid__item" id="kt_subheader">

                <div class="kt-subheader__toolbar">
                    <div class="kt-subheader__wrapper">

                    </div>
                </div>
            </div>
            <div class="kt-content kt-grid__item kt-grid__item--fluid">
                <div class="row">
                    <div class="col-xl-6">
                        <div class="kt-portlet kt-portlet--height-fluid">

                            <div class="kt-portlet__body"><br><br>
                                <div class="kt-widget kt-widget--user-profile-2">

                                    <div class="kt-widget__body">
                                        <h1 class="cover-heading">
                                            Personal Details
                                        </h1>
                                        <div class="kt-widget__content">
                                            <table class="table">
                                                <tr>
                                                    <td>User Name</td>
                                                    <td>${logindetails.firstName} ${logindetails.lastName}</td>
                                                </tr>
                                                <tr>
                                                    <td>Joining Date</td>
                                                    <td>${logindetails.joiningDate}</td>
                                                </tr>
                                                <tr>
                                                    <td>User Id</td>
                                                    <td>${logindetails.userid}</td>
                                                </tr>
                                                <tr>
                                                    <td>Account Status</td>
                                                    <td><c:if test="${logindetails.status eq 'true'}">
                                                        Active
                                                    </c:if>
                                                        <c:if test="${logindetails.status eq 'false'}">
                                                            Inactive
                                                        </c:if></td>
                                                </tr>
                                                <tr>
                                                    <td>Email</td>
                                                    <td>${logindetails.email }</td>
                                                </tr>
                                                <tr>
                                                    <td>Contact No</td>
                                                    <td>${logindetails.contactNo }</td>
                                                </tr>
                                            </table>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-grid--stretch">
        <div class="kt-container kt-body  kt-grid kt-grid--ver" id="kt_body">
            <div class="kt-grid__item kt-grid__item--fluid kt-grid kt-grid--hor">
                <div class="kt-subheader   kt-grid__item" id="kt_subheader">
                    <div class="kt-subheader__main">
                        <h3 class="kt-subheader__title">DDDDDD</h3>
                        <div class="kt-subheader__breadcrumbs">
                            <a href="#" class="kt-subheader__breadcrumbs-home"><i class="flaticon2-shelter"></i></a>
                            <span class="kt-subheader__breadcrumbs-separator"></span>
                            <a href="" class="kt-subheader__breadcrumbs-link">
                                DDDDDDD </a>
                            <span class="kt-subheader__breadcrumbs-separator"></span>
                            <a href="" class="kt-subheader__breadcrumbs-link">
                                DDDDEEEESSSSSSSCCCCCCCC </a>
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
                                            TTTTTTIIIIITTTTTTTTLLLLLLLLLLLLEEEEEEEE
                                        </h3>
                                    </div>
                                    <div class="kt-portlet__head-toolbar">

                                    </div>
                                </div>
                                <div class="kt-portlet__body kt-portlet__body--fluid">
                                    <div class="kt-widget12">
                                        <div class="kt-widget12__content">
                                            <div class="kt-widget12__item">
                                                <div class="kt-widget12__info">

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> -->
					