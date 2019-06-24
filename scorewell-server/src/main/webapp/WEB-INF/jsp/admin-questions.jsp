
	<%@ include file="admin-menu.jsp"%>

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row2">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<ul>
					<li><a href="/admin">Admin</a></li>
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

			<!-- <div class="sdb_holder">
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
			</div> -->
			<!-- ################################################################################################ -->
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="content three_quarter">
			<!-- ################################################################################################ -->
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