
	<%@ include file="menu.jsp"%>

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row2">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<ul>
					<li><a href="/home">Home</a></li>
					<li><a href="/ias-daily-questions?course=IAS">IAS question</a></li>
				</ul>
			</div>
		</div>

	</div>

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->

	<div class="wrapper row3">
		<main class="container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<div class="sidebar one_quarter first">
			<!-- ################################################################################################ -->
			<h6>Course List</h6>
			<nav class="sdb_holder">
			<ul>
				<li><a href="#gen_study">General studies</a></li>
				<li><a href="#">Essay</a></li>
				<li><a href="#">Agriculture</a></li>
			</ul>
			</nav>

			<div class="sdb_holder">
				<h6>Evaluated Answer Sheets</h6>
				<form action="/set-list" method="get">
					<div>
						<label for="name">Name<span>*</span></label> <input
							type="text" name="name" id="name" value="" size="22">
					</div>
					<div>
						&nbsp;<label for="name">Phone No. <span>*</span></label> <input
							type="text" name="phone" id="phone" value="" size="22">
					</div>
					<div>
						&nbsp;<label for="email">Mail <span>*</span></label> <input type="text"
							name="email" id="email" value="" size="22">
					</div>
					<div>
						&nbsp;<input type="submit" value="Submit" id="submit">
						<span id="result"></span>
					</div>
				</form>
			</div>
			<!-- ################################################################################################ -->
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="content three_quarter">
			<!-- ################################################################################################ -->
			<h1 class="text-center"><B>Score Well Answer Writing Program</B></h1>
			<p class="text-justify">Answer writing plays a very important role in Civil Services
				Examination. Regular answer writing and its sincere evaluation is
				important to score very high marks in mains exam which ensures
				selection with good rank.</p>
			<p class="text-justify">Keeping this in mind, Score Well has started an answer writing
				program where important and expected questions in GS will be put and
				students can write their answers and get it evaluated. Questions will
				be put on triweekly basis (Mon, Wed, Fri).</p>
			<p class="text-justify">It will develop the right answer writing skills, makes you more
				confident and disciplined to face the exam successfully. It aims to
				increase your score by at least 30% and will help you to achieve your
				goals.</p>
			<h1>Note:</h1>
			<ul>
				<li>Answers will be evaluated in English medium.</li>
				<li>Score Well will try its best to give evaluation within 24 hrs.</li>
				<li>Only three question/day would be set as part of this answer writing program.</li>
				<li>The program runs on subscription basis for 90 days duration.</li>
			</ul>
			<div id="gen_study">
				<div id="comments">
					
					<h2>Question Sets</h2>
					<ul>
					
						<c:forEach var="queSetDesc" items="${questionSets}">
							<li><article> 
								<header>
									<address>
					                	${queSetDesc.releaseDate} <a href="/question-set?set-name=${queSetDesc.setName}" target="_blank">${queSetDesc.setName}</a>
					                	<a href="pdf/question/${queSetDesc.pdfFileName}" target="_blank"><img src="icon/pdf.png" /> </a>
									</address>
								</header> 
							</article></li>
						
						</c:forEach>
					
					</ul>
				</div>
			</div>
			<!-- ################################################################################################ -->
		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	
	<%@ include file="footer.jsp"%>
	<!-- <script src="js/ias-daily-papers.js"></script> -->
	
</body>
</html>