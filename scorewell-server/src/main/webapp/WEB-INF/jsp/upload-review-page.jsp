	
	<%@ include file="admin-menu.jsp"%>
	
	<c:set var="queSet" value="${questionSet}" />
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row2">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<ul>
					<li><a href="/admin">Admin</a></li>
					<li><a href="/admin-answer-list">Review Answer</a></li>
					<li><a href="/upload-review">Upload Review</a></li>
				</ul>
			</div>
		</div>

	</div>

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row3">
		<section id="cta" class="clear">
			
			<div class="one_half first">
				<h2 class="heading">
					<font color="red"><B>Question Sheet : ${questionSet.setName}</B></font>
					<%-- <a href="pdf/question/${userAnswerSheet.fileName}" target="_blank"><img src="icon/pdf.png" /> </a> --%>
					<a type='button' href="download/question/file/${userAnswerSheet.fileName}" class="add_question_button" target="_blank">Download File</a>
				</h2>
				<br></br>
			</div>
			<div class="one_half">
				<h2 class="heading">
					<font color="green"><B>Answer Sheet : ${questionSet.setName}</B></font>
					 <%-- <a href="/pdf/answer/${userAnswerSheet.phone}_${userAnswerSheet.emailId}_${userAnswerSheet.fileName}" target="_blank"><img src="icon/pdf.png" /> </a> --%>
					 <a type='button' href="download/answer/file/${userAnswerSheet.phone}_${userAnswerSheet.emailId}_${userAnswerSheet.fileName}" class="add_question_button" target="_blank">Download File</a>
					
				</h2>
			</div>
		</section>
		
		<div class="wrapper content">
			<section id="cta" class="clear"> 
				<div id="content">
					<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
						<div class="one_half first">
							<input name="userName" id="userName" value="${userAnswerSheet.userName}" size="35" readonly>
				           	<input name="phone" id="phone" value="${userAnswerSheet.phone}" size="35" readonly>
				           	<input name="emailId" id="emailId" value="${userAnswerSheet.emailId}" size="35" readonly>
				           	<input name="setName" id="setName" value="${userAnswerSheet.setName}" size="35" readonly>
				           	<input type="hidden" id="fileName" value="${userAnswerSheet.fileName}" size="35" readonly>
						</div>

						<div class="one_half">
								<label for="upload">Upload Review<span>*</span></label> 
								<input id="upload" type="file" name="file" value="Upload File">
								&nbsp; <input type="submit" value="Submit" id="submit" class="orange_button"> 
								<span id="result"></span>
						</div>
				</form>
				</div>
			</section>
		</div>
		
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row3">
		<section id="cta">
		</section>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->

	<%@ include file="footer.jsp"%>
	<script src="js/upload-review-page.js"></script>
</body>
</html>