<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/cover/">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<c:set value='<%=(String)session.getAttribute("getPrincipalName")%>' var="loggedinuser"></c:set>
<header class="masthead mb-auto">
    <div class="inner">
        <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link active" href="${pageContext.request.contextPath}/list">Home</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/myProfileAdmin">My Profile(${loggedinuser})</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
    </div>
</header>


<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>

<sec:authorize access="hasRole('ADMIN')" var="userRole"></sec:authorize>					
<%
String ip=request.getServerName();
//ip = "172.104.62.103";
int port=request.getServerPort();
%>	
<script lang="javascript" type="text/javascript">
var ip='<%=ip%>';
var port='<%=port%>';
var contextpath='<%=request.getContextPath()%>';
var host='http://'+ip+':'+port+contextpath;
var hostws='ws://'+ip+':'+port+contextpath;
</script>
<% 
Date curdatee = new Date();
String curdate = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss").format(curdatee);
System.out.println( "<h2 align = \"center\">" +curdate.toString()+"</h2>");
%>
<% 
System.out.println("D: "+request.getRequestURI());
System.out.println("D: "+request.getRequestURL());
%> 
<script type="text/javascript">
var ss=1;
function formatAMPM(dd) {
	var d = dd,
	seconds = d.getSeconds().toString().length == 1 ? '0'+d.getSeconds() : d.getSeconds(),
    minutes = d.getMinutes().toString().length == 1 ? '0'+d.getMinutes() : d.getMinutes(),
    hours = d.getHours().toString().length == 1 ? '0'+d.getHours() : d.getHours(),
    ampm = d.getHours() >= 12 ? 'pm' : 'am',
    months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],
    days = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
return days[d.getDay()]+' '+months[d.getMonth()]+' '+d.getDate()+' '+d.getFullYear()+' '+hours+':'+minutes+':'+seconds;//+ampm;
}
function digClock() {
	  setInterval(function(){ 
		  var d = new Date('<%=curdate%>');
		  d.setSeconds(d.getSeconds()+(ss++));
		  $("#digitalclock").html(formatAMPM(d))
	  }, 1000);
	}
	
	
	
	function logoutSSO()
	{
		// var win = window.open("http://localhost:8080/sso-server/logout");
		 
		 var win = window.open("http://localhost:8080/sso-server/logout", '1366002941508','width=500,height=200,left=375,top=330');


		 setTimeout(function () { win.close();}, 1000);
	}
</script>				
<c:set value='<%=(String)session.getAttribute("staticResouce")%>' var="staticResouce" />	
<div id="kt_header" class="kt-header  kt-header--fixed " data-ktheader-minimize="on">
						<div class="kt-container">

							<!-- begin:: Brand -->
							<div class="kt-header__brand   kt-grid__item" id="kt_header_brand">
								<a class="kt-header__brand-logo" href="${pageContext.request.contextPath}/list">
									<img alt="Logo" src="static/logo.gif" class="kt-header__brand-logo-default">
								</a>
							</div>

							<!-- end:: Brand -->

							<!-- begin: Header Menu -->
							<button class="kt-header-menu-wrapper-close" id="kt_header_menu_mobile_close_btn"><i class="la la-close"></i></button>
							<div class="kt-header-menu-wrapper kt-grid__item kt-grid__item--fluid" id="kt_header_menu_wrapper" style="opacity: 1;">
								<div id="kt_header_menu" class="kt-header-menu kt-header-menu-mobile ">
									<ul class="kt-menu__nav ">
										<li class="kt-menu__item  kt-menu__item--open kt-menu__item--here kt-menu__item--submenu kt-menu__item--rel kt-menu__item--open kt-menu__item--here" ><a href="${pageContext.request.contextPath}/list" class="kt-menu__link"><span class="kt-menu__link-text"><img src="${staticResouce }assets/media/icons/svg/Home/Home.svg" alt=""></span><i class="kt-menu__ver-arrow la la-angle-right"></i></a>
										</li>
										<li class="kt-menu__item  kt-menu__item--submenu kt-menu__item--rel" data-ktmenu-submenu-toggle="click" aria-haspopup="true"><a href="javascript:;" class="kt-menu__link kt-menu__toggle"><span class="kt-menu__link-text">Resume</span><i class="kt-menu__ver-arrow la la-angle-right"></i></a>
											<div class="kt-menu__submenu kt-menu__submenu--classic kt-menu__submenu--left">
												<ul class="kt-menu__subnav">
													<li class="kt-menu__item " aria-haspopup="true"><a href="javascript:;" class="kt-menu__link "><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Express Resume</span></a></li>
													<li class="kt-menu__item  kt-menu__item--submenu" data-ktmenu-submenu-toggle="hover" aria-haspopup="true"><a href="#" class="kt-menu__link kt-menu__toggle"><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">General Resume</span><i class="kt-menu__hor-arrow la la-angle-right"></i><i class="kt-menu__ver-arrow la la-angle-right"></i></a>
														<div class="kt-menu__submenu kt-menu__submenu--classic kt-menu__submenu--right">
															<ul class="kt-menu__subnav">
																<!-- <li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Add Resume</span></a></li> -->
																<li class="kt-menu__item " aria-haspopup="true"><a href="${pageContext.request.contextPath}/viewResumes" class="kt-menu__link "><span class="kt-menu__link-text">View & Print Resume</span></a></li>
																<!-- <li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Update Resume</span></a></li>
																<li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Activate Resume</span></a></li>
																<li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Deactivate Resume</span></a></li> -->
																<li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Make your payment</span></a></li>
																<li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Show/Hide Resume</span></a></li>
															</ul>
														</div>
													</li>
													<li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Fresher Resume</span></a></li>
													<li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Activate Both Resume</span></a></li>
												</ul>
											</div>
										</li>
										<li class="kt-menu__item  kt-menu__item--submenu kt-menu__item--rel" data-ktmenu-submenu-toggle="click" aria-haspopup="true"><a href="javascript:;" class="kt-menu__link kt-menu__toggle"><span class="kt-menu__link-text">Search</span><i class="kt-menu__ver-arrow la la-angle-right"></i></a>
											<div class="kt-menu__submenu kt-menu__submenu--classic kt-menu__submenu--left">
												<ul class="kt-menu__subnav">
													<li class="kt-menu__item " aria-haspopup="true"><a href="javascript:;" class="kt-menu__link "><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Jobs</span></a></li>
													<li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Advertisement</span></a></li>
													<li class="kt-menu__item " aria-haspopup="true"><a href="#" class="kt-menu__link "><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Courses</span></a></li>
												</ul>
											</div>
										</li>
										<li class="kt-menu__item  kt-menu__item--submenu kt-menu__item--rel" data-ktmenu-submenu-toggle="click" aria-haspopup="true"><a href="javascript:;" class="kt-menu__link kt-menu__toggle"><span class="kt-menu__link-text">Services</span><i class="kt-menu__ver-arrow la la-angle-right"></i></a>
											<div class="kt-menu__submenu kt-menu__submenu--classic kt-menu__submenu--left">
												<ul class="kt-menu__subnav">
													<li class="kt-menu__item  kt-menu__item--submenu" data-ktmenu-submenu-toggle="hover" aria-haspopup="true"><a href="#" class="kt-menu__link kt-menu__toggle"><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Free</span><i class="kt-menu__hor-arrow la la-angle-right"></i><i class="kt-menu__ver-arrow la la-angle-right"></i></a>
														<div class="kt-menu__submenu kt-menu__submenu--classic kt-menu__submenu--right">
															<ul class="kt-menu__subnav">
																<li class="kt-menu__item "><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Show/Hide Resume</span></a></li>
															</ul>
														</div>
													</li>
													<li class="kt-menu__item  kt-menu__item--submenu" data-ktmenu-submenu-toggle="hover" aria-haspopup="true"><a href="#" class="kt-menu__link kt-menu__toggle"><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Paid</span><i class="kt-menu__hor-arrow la la-angle-right"></i><i class="kt-menu__ver-arrow la la-angle-right"></i></a>
														<div class="kt-menu__submenu kt-menu__submenu--classic kt-menu__submenu--right">
															<ul class="kt-menu__subnav">
																<li class="kt-menu__item " ><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Watch Dog Alert</span></a></li>
																<li class="kt-menu__item " ><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Resume Broadcaster</span></a></li>
																<li class="kt-menu__item " ><a href="#" class="kt-menu__link "><span class="kt-menu__link-text">Quick Resume Broadcaster</span></a></li>
															</ul>
														</div>
													</li>
												</ul>
											</div>
										</li>
										<li class="kt-menu__item  kt-menu__item--submenu kt-menu__item--rel" data-ktmenu-submenu-toggle="click" aria-haspopup="true"><a href="javascript:;" class="kt-menu__link kt-menu__toggle"><span class="kt-menu__link-text">Need Help?</span><i class="kt-menu__ver-arrow la la-angle-right"></i></a>
											<div class="kt-menu__submenu kt-menu__submenu--classic kt-menu__submenu--left">
												<ul class="kt-menu__subnav">
													<li class="kt-menu__item  kt-menu__item--submenu" ><a href="${pageContext.request.contextPath}/faq" class="kt-menu__link "><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">FAQ's</span></a></li>
													<li class="kt-menu__item  kt-menu__item--submenu" ><a href="${pageContext.request.contextPath}/contactus" class="kt-menu__link "><i class="kt-menu__link-bullet kt-menu__link-bullet--dot"><span></span></i><span class="kt-menu__link-text">Contact Us</span></a></li>
												</ul>
											</div>
										</li>
										<li class="kt-menu__item    kt-menu__item--submenu   " ><a href="${pageContext.request.contextPath}/noticeboardads" class="kt-menu__link"><span class="kt-menu__link-text">Notice Board Ads</span><i class="kt-menu__ver-arrow la la-angle-right"></i></a></li>
										<li class="kt-menu__item    kt-menu__item--submenu   " ><a href="${pageContext.request.contextPath}/careerguidance" class="kt-menu__link"><span class="kt-menu__link-text">Career Guidance</span><i class="kt-menu__ver-arrow la la-angle-right"></i></a></li>
										<li class="kt-menu__item    kt-menu__item--submenu   " ><a href="${pageContext.request.contextPath}/feedback" class="kt-menu__link"><span class="kt-menu__link-text">Feedback</span><i class="kt-menu__ver-arrow la la-angle-right"></i></a></li>
									</ul>
								</div>
							</div>

							<!-- end: Header Menu -->

							<!-- begin:: Header Topbar -->
							<div class="kt-header__topbar kt-grid__item">

								<!--begin: Search -->
								<!-- <div class="kt-header__topbar-item kt-header__topbar-item--search dropdown" id="kt_quick_search_toggle">
									<div class="kt-header__topbar-wrapper" data-toggle="dropdown" data-offset="10px,0px">
										<span class="kt-header__topbar-icon">
											<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" class="kt-svg-icon">
												<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
													<rect id="bound" x="0" y="0" width="24" height="24"></rect>
													<path d="M14.2928932,16.7071068 C13.9023689,16.3165825 13.9023689,15.6834175 14.2928932,15.2928932 C14.6834175,14.9023689 15.3165825,14.9023689 15.7071068,15.2928932 L19.7071068,19.2928932 C20.0976311,19.6834175 20.0976311,20.3165825 19.7071068,20.7071068 C19.3165825,21.0976311 18.6834175,21.0976311 18.2928932,20.7071068 L14.2928932,16.7071068 Z" id="Path-2" fill="#000000" fill-rule="nonzero" opacity="0.3"></path>
													<path d="M11,16 C13.7614237,16 16,13.7614237 16,11 C16,8.23857625 13.7614237,6 11,6 C8.23857625,6 6,8.23857625 6,11 C6,13.7614237 8.23857625,16 11,16 Z M11,18 C7.13400675,18 4,14.8659932 4,11 C4,7.13400675 7.13400675,4 11,4 C14.8659932,4 18,7.13400675 18,11 C18,14.8659932 14.8659932,18 11,18 Z" id="Path" fill="#000000" fill-rule="nonzero"></path>
												</g>
											</svg>
										</span>
									</div>
									<div class="dropdown-menu dropdown-menu-fit dropdown-menu-right dropdown-menu-anim dropdown-menu-lg">
										<div class="kt-quick-search kt-quick-search--inline" id="kt_quick_search_inline">
											<form method="get" class="kt-quick-search__form">
												<div class="input-group">
													<div class="input-group-prepend"><span class="input-group-text"><i class="flaticon2-search-1"></i></span></div>
													<input type="text" class="form-control kt-quick-search__input" placeholder="Search...">
													<div class="input-group-append"><span class="input-group-text"><i class="la la-close kt-quick-search__close"></i></span></div>
												</div>
											</form>
											<div class="kt-quick-search__wrapper kt-scroll ps" data-scroll="true" data-height="300" data-mobile-height="200" style="height: 300px; overflow: hidden;">
											<div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></div>
										</div>
									</div>
								</div> -->

								<!--end: Search -->
								

								<!--begin: Language bar -->
								<div class="kt-header__topbar-item kt-header__topbar-item--langs">
									<div class="kt-header__topbar-wrapper" data-toggle="dropdown" data-offset="10px,0px">
										<span class="kt-header__topbar-icon">
											<img class="" src="${staticResouce }assets/media/flags/020-flag.svg" alt="">
										</span>
									</div>
									<div class="dropdown-menu dropdown-menu-fit dropdown-menu-right dropdown-menu-anim">
										<ul class="kt-nav kt-margin-t-10 kt-margin-b-10">
											<li class="kt-nav__item kt-nav__item--active">
												<a href="#" class="kt-nav__link">
													<span class="kt-nav__link-icon"><img src="${staticResouce }assets/media/flags/020-flag.svg" alt=""></span>
													<span class="kt-nav__link-text">English</span>
												</a>
											</li>
											<li class="kt-nav__item">
												<a href="#" class="kt-nav__link">
													<span class="kt-nav__link-icon"><img src="${staticResouce }assets/media/flags/016-spain.svg" alt=""></span>
													<span class="kt-nav__link-text">Spanish</span>
												</a>
											</li>
											<li class="kt-nav__item">
												<a href="#" class="kt-nav__link">
													<span class="kt-nav__link-icon"><img src="${staticResouce }assets/media/flags/017-germany.svg" alt=""></span>
													<span class="kt-nav__link-text">German</span>
												</a>
											</li>
										</ul>
									</div>
								</div>

								<!--end: Language bar -->
								<c:set value='<%=(String)session.getAttribute("getPrincipalName")%>' var="loggedinuser"></c:set>
								<!--begin: User bar -->
								<div class="kt-header__topbar-item kt-header__topbar-item--user">
									<div class="kt-header__topbar-wrapper" data-toggle="dropdown" data-offset="10px,0px">
										<span class="kt-header__topbar-welcome">Hi,</span>
										<span class="kt-header__topbar-username" style="white-space:nowrap">${loggedinuser}</span>
										<span class="kt-header__topbar-icon"><b><c:out value="${fn:substring(loggedinuser, 0, 1)}" /></b></span>
										<img alt="Pic" src="${staticResouce }assets/media/users/300_21.jpg" class="kt-hidden">
									</div>
									<div class="dropdown-menu dropdown-menu-fit dropdown-menu-right dropdown-menu-anim dropdown-menu-xl">

										<!--begin: Head -->
										<div class="kt-user-card kt-user-card--skin-dark kt-notification-item-padding-x" style="background-image: url(${staticResouce }assets/media/misc/bg-1.jpg)">
											<div class="kt-user-card__avatar">
												<img class="kt-hidden" alt="Pic" src="${staticResouce }assets/media/users/300_25.jpg">

												<!--use below badge element instead the user avatar to display username's first letter(remove kt-hidden class to display it) -->
												<span class="kt-badge kt-badge--lg kt-badge--rounded kt-badge--bold kt-font-success"><c:out value="${fn:substring(loggedinuser, 0, 1)}" /></span>
											</div>
											<div class="kt-user-card__name">
												${loggedinuser}
											</div>
											<div class="kt-user-card__badge">
												<!-- <span class="btn btn-success btn-sm btn-bold btn-font-md">23 messages</span> -->
											</div>
										</div>

										<!--end: Head -->

										<!--begin: Navigation -->
										<div class="kt-notification">
											<a href="${pageContext.request.contextPath}/myProfileAdmin" class="kt-notification__item">
												<div class="kt-notification__item-icon">
													<i class="flaticon2-calendar-3 kt-font-success"></i>
												</div>
												<div class="kt-notification__item-details">
													<div class="kt-notification__item-title kt-font-bold">
														My Profile
													</div>
													<div class="kt-notification__item-time">
														Basic Account Information
													</div>
												</div>
											</a>
											<a href="${pageContext.request.contextPath}/viewPersonalInfo" class="kt-notification__item">
												<div class="kt-notification__item-icon">
													<i class="flaticon2-rocket-1 kt-font-danger"></i>
												</div>
												<div class="kt-notification__item-details">
													<div class="kt-notification__item-title kt-font-bold">
														Personal Information
													</div>
													<div class="kt-notification__item-time">
														Basic Account Information
													</div>
												</div>
											</a>
											<a href="${pageContext.request.contextPath}/updatePersonalInfo" class="kt-notification__item">
												<div class="kt-notification__item-icon">
													<i class="flaticon2-hourglass kt-font-brand"></i>
												</div>
												<div class="kt-notification__item-details">
													<div class="kt-notification__item-title kt-font-bold">
														Update Profile
													</div>
													<div class="kt-notification__item-time">
														Change Account Information
													</div>
												</div>
											</a>
											<a href="${pageContext.request.contextPath}/changePasswordAdmin" class="kt-notification__item">
												<div class="kt-notification__item-icon">
													<i class="flaticon2-lock kt-font-warning"></i>
												</div>
												<div class="kt-notification__item-details">
													<div class="kt-notification__item-title kt-font-bold">
														Change Password
													</div>
													<div class="kt-notification__item-time">
														Change Account Password
													</div>
												</div>
											</a>
											<div class="kt-notification__custom kt-space-between">
												<a href="${pageContext.request.contextPath}/logout" class="btn btn-label btn-label-brand btn-sm btn-bold">Sign Out</a>
											</div>
										</div>

										<!--end: Navigation -->
									</div>
								</div>

								<!--end: User bar -->
							</div>

							<!-- end:: Header Topbar -->
						</div>
					</div> --%>