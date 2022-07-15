<%-- <div class="kt-footer  kt-footer--extended  kt-grid__item" id="kt_footer" style="background-image: url('./assets/media/bg/bg-2.jpg');">
						<div class="kt-footer__top">
							<div class="kt-container">
								<div class="row">
									<div class="col-lg-2">
										<div class="kt-footer__section">
											<h3 class="kt-footer__title">Who is online ?</h3>
											<div class="kt-footer__content">
												<div class="kt-footer__nav">
													<div class="kt-footer__nav-section">
														<a href="#">Seafarers</a>
														<a href="#">Companies</a>
														<a href="#">Institutes</a>
														<a href="#">Guest Visitors</a>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-4">
										<div class="kt-footer__section">
											<h3 class="kt-footer__title">Quick Links</h3>
											<div class="kt-footer__content">
												<div class="kt-footer__nav">
													<div class="kt-footer__nav-section">
														<a href="#">About Us</a>
														<a href="#">Advertise</a>
														<a href="#">Site Map</a>
														<a href="#">FAQs</a>
														<a href="#">Feedback</a>
													</div>
													<div class="kt-footer__nav-section">
														<a href="#">Contact Us</a>
														<a href="#">Terms & Conditions</a>
														<a href="#">Privacy Policy</a>
														<a href="#">Disclaimer</a>
														<a href="#">Refer a Friend</a>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="kt-footer__section">
											<h3 class="kt-footer__title">@Jobships.com</h3>
											<div class="kt-footer__content">
												Owned and operated by
												<a href="https://www.deeprajgroup.com/" target="_blank">Deepraj Marine Systems Pvt. Ltd.</a>
												</br></br>
												Developed and maintained by
												<a href="https://www.deeprajgroup.com/" target="_blank">Deepraj Software Services Pvt. Ltd.</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="kt-footer__bottom">
							<div class="kt-container">
								<div class="kt-footer__wrapper">
									<div class="kt-footer__logo">
										<a class="kt-header__brand-logo" href="demo4/index&amp;demo=demo2.html">
											<img alt="Logo" src="static/logo.gif" class="kt-header__brand-logo-sticky">
										</a>
										<div class="kt-footer__copyright">
											<!-- 2019&nbsp;©&nbsp;
											<a href="https://www.deeprajgroup.com/" target="_blank">Jobships</a> -->
										</div>
									</div>
									<div class="kt-footer__menu" id="cpyrght">
										
									</div>
								</div>
							</div>
						</div>
					</div>
					<%
String ip=request.getServerName();
int port=request.getServerPort();
%>

<script type="text/javascript">
var ip='<%=ip%>';
var port='<%=port%>';
var contextpath='<%=request.getContextPath()%>';

var host='http://'+ip+':'+port+contextpath;
var getFooterTextService= host+"/api/getFooterTextService";

function setFooterText() { 
	
	$.ajax({
	       type: 'POST',
	       contentType: 'application/json',
	       url: getFooterTextService, 
	       dataType: "json",
	       data: JSON.stringify({
			   "type": "footertext"
		 }), 
	       success: function(data, textStatus, jqXHR){
	             var json = JSON.stringify(data);
	             //alert(json)
	             var ooo = JSON.parse(json);
	             $("#cpyrght").html(ooo.footertext);
	       },
	       error: function(jqXHR, textStatus, errorThrown){
	           //alert(' error: ' + textStatus);
	       }
	   });

}
window.onload = setFooterText();
</script>
					 --%>