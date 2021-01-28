
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
						&nbsp;<label for="email">Email <span>*</span></label> <input type="text"
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
			<p class="text-justify">Answer writing plays a very important
				role in Civil Services Examination. Regular answer writing and its
				sincere evaluation is important to score very high marks in mains
				exam which ensures selection with good rank.</p>
			<p class="text-justify">Keeping this in mind, Score Well has
				started an answer writing program where important and previous years
				questions in GS/Agriculture will be put and students can write their
				answers and get it evaluated. Here, one or two questions, according
				to a schedule, will be put on a daily basis.</p>
			<p class="text-justify">Students are expected that they write and
				submit their answers on a daily basis to get the maximum advantage.
				It will develop the necessary answer writing skills, boost
				confidence and makes one more disciplined to face the exam
				successfully.</p>
			<p class="text-justify"><h1 class="text-left"><B><u>Notes:</u></B></h1></p>
			<ul>
				<li>Please upload good quality scanned pdf file for proper evaluation.</li>
				<li>Adhere to necessary word limit where required. Can
					illustrate with suitable facts, diagrams, case studies and relevant
					examples where required.</li>
				<li>The program runs on a subscription basis. Student can take
					subscription upto Mains 2021 to get the maximum advantage. Student
					can write as many tests as possible and get it evaluated.</li>
				<li>Fees: Rs 15000</li>
			</ul>
			
			<div id="gen_study">
				<div id="comments">
					
					<p class="text-justify"><h1 class="text-left"><B><u>Test Papers:</u></B></h1></p>
					<ul>
					
						<c:forEach var="queSetDesc" items="${questionSets}">
							<li><article> 
								<header>
									<address>
					                	${queSetDesc.releaseDate} : <a href="/question-set?set-name=${queSetDesc.setName}" target="_blank"><font color="red">${queSetDesc.setName}</font></a>
					                	<a href="pdf/question/${queSetDesc.pdfFileName}" target="_blank"><!-- <img src="icon/pdf.png" /> --> </a>
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