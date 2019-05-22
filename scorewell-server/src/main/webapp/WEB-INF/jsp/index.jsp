
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
						<h2 class="heading">Score Well IAS</h2>
					<p>Answer writing plays a very important role in Civil Services
						Examination. Regular answer writing and its sincere evaluation is
						important to score very high marks in mains exam which ensures
						selection with good rank.</p>
					<p>Keeping this in mind, Score Well has started an answer
						writing program where important and expected questions in GS will
						be put and students can write their answers and get it
						evaluatedQuestions will be put on triweekly basis (Mon, Wed,
						Fri)...&hellip;</p>
					<p>It will develop the right answer writing skills, makes you
						more confident and disciplined to face the exam successfully. It
						aims to increase your score by at least 30% and will help you to
						achieve your goals.</p>
					<footer>
							<a class="btn" href="/ias-daily-questions?course=IAS">Read More <span
								class="fa fa-arrow-right"></span></a>
						</footer>
					</figcaption>
				</figure>
				<!-- ################################################################################################ -->
			</div>
			<div class="one_half">
				<!-- ################################################################################################ -->
				<figure class="btmspace-30">
					<a href="#"><img class="borderedbox inspace-10 btmspace-10"
						src="img/professional.jpg" alt=""></a>
					<figcaption class="borderedbox inspace-30 bg-white">
						<h2 class="heading">Score Well Professional</h2>
						<p>Coming Soon...</p>
						<!-- <footer>
							<a class="btn" href="#">Read More <span
								class="fa fa-arrow-right"></span></a>
						</footer> -->
					</figcaption>
				</figure>
				<figure>
					<a href="#"><img class="borderedbox inspace-10 btmspace-10"
						src="img/medical.jpg" alt=""></a>
					<figcaption class="borderedbox inspace-30 bg-white">
						<h2 class="heading">Score Well Medical</h2>
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