
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
											${queSetDesc.releaseDate} <a
												href="/question-set?set-name=${queSetDesc.setName}"
												target="_blank">${queSetDesc.setName}</a> <a
												href="pdf/question/${queSetDesc.pdfFileName}"
												target="_blank"><img src="icon/pdf.png" /> </a>


											<div class="fl_right">
												<button id="deleteQueSet" class="delete_button"><a href="/sw/api/delete-question-set?setname=${queSetDesc.setName}">Delete</a></button>
												<a href="/sw/api/delete-question-set?setname=${queSetDesc.setName}" class="button">Go to Google</a>
												
											</div>

											<!-- <div class="fl_right">
												<input type="submit" value="Delete" id="deleteQueSet">
											</div> -->
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
	<script src="js/admin-question.js"></script>
	
</body>
</html>