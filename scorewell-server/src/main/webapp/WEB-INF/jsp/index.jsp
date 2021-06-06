
	<%@ include file="menu.jsp"%>
	
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- Could use a jQuery background switcher script here to swap the background image for a different one -->
	<div class="wrapper bgded"
		style="background-image: url('img/home-img.jpg');">
		<section id="intro">
			<h2 class="heading_home" style="font-family:courier font-size:160%;">Welcome to Score Well</h2>
		</section>
	</div>
	
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row3">
		<main class="container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<div class="group">
			<div class="one_half first">
				<!-- ################################################################################################ -->
				<figure>
					<a href="#"><img class="borderedbox inspace-10 btmspace-30"
						src="img/ias.jpg" alt=""></a>
					<figcaption class="borderedbox inspace-30 bg-white">
						<h2 class="heading">Score Well</h2>
						<p>Score Well is the newest entry in the field of education
							which aims to provide quality education which is easily
							accessible and affordable to all where premium quality content
							and right guidance will be provided according to latest exam
							pattern and requirement by experts..</p>
						<p>We hope and aim to give you our best so that we together
							create a beautiful journey. Very soon it aims to add various
							dimensions to it so that you take maximum advantage out of it.</p>
						<p>With regards,<br>Team Score Well</p>
					<!-- <footer>
							<a class="btn" href="/ias-daily-questions?course=IAS">Answer Writing Program <span
								class="fa fa-arrow-right"></span></a>
						</footer> -->
					</figcaption>
				</figure>
				<!-- ################################################################################################ -->
			</div>
			<div class="one_half">
				<!-- ################################################################################################ -->
				<figcaption class="borderedbox inspace-30 bg-white">
					<h2 class="heading">
						<a href="/daily-questions?course=IAS"><font color="red"><B>Answer Writing Program</B></font></a>
					</h2>

					<!-- <a href="#"><img class="borderedbox inspace-10 btmspace-10"
						src="img/professional.jpg" alt=""></a> -->
					<!-- <figcaption class="borderedbox inspace-30 bg-white">
						<h2 class="heading">Score Well Professional</h2>
						<p>Coming Soon...</p>
					</figcaption> -->
				
				</figcaption>
					<!-- <a href="#"><img class="borderedbox inspace-10 btmspace-10"
						src="img/medical.jpg" alt=""></a> -->
					<figcaption class="borderedbox inspace-30 bg-white">
						<h2 class="heading"><B>Score Well Updates</B></h2>
							<ul>
								<li><h1>Classroom Program</h1></li>
								<li><h1>Test Series</h1></li>
								<li><h1>Daily Answer Writing Initiative</h1></li>
							</ul>
						<!-- <img class="alignnone size-full wp-image-148903 lazyloaded"
							style="vertical-align: text-top;"
							src="icon/new.gif"
							alt="" data-ll-status="loaded" width="31" height="20"> -->
						<p>Coming Soon...</p>
						<!-- <footer>
							<a class="btn" href="#">Read More <span
								class="fa fa-arrow-right"></span></a>
						</footer> -->
					</figcaption>
				</figure>
				<!-- ################################################################################################ -->
			</div>
		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row4 bgded"
		style="background-image: url('img/01.png');">
		<div class="overlay">
			<section id="footercta">
				<!-- ################################################################################################ -->
				<div class="footer_logo_text uppercase">Briefin<span>gs</span></div>
				<p><h2>Get weekly current affairs email from Score Well.</h2></p>
				<!-- <a class="btn" href="#">Sign Up <span
					class="fa fa-arrow-right"></span></a> -->
			<div class="newsletter">
				<div class="newsletter_form_container ml-lg-auto">
					<form id="newsletter_form" name="subscribe"
						class="newsletter_form d-flex flex-row align-items-center justify-content-center">
						<input id="subscrib_email"  type="email" class="newsletter_input" placeholder="Your Email" required="required">
						<button id="submit" type="submit" class="newsletter_button">Subscribe</button>
						<span id="subscribeResult" name="subscribeResult"></span>
					</form>
				</div>
			</div>
			<!-- ################################################################################################ -->
			</section>
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	
	<%@ include file="footer.jsp"%>
	<%-- <script src="<c:url value="js/home.js" />"></script> --%>
	<script src="js/home.js"></script>
</body>
</html>