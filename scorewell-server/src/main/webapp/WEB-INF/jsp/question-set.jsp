	
	<%@ include file="menu.jsp"%>
	
	<c:set var="queSet" value="${questionSet}" />
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row2">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<ul>
					<li><a href="/home">Home</a></li>
					<li><a href="/ias-daily-questions">IAS question</a></li>
					<li><a href="/question-set">Question set</a></li>
				</ul>
			</div>
		</div>

	</div>

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row3">
		<%-- <section id="cta" class="clear">
		<div class="one_half first">
			<h2 class="heading">
				<font color="red"><B>Question Set : ${questionSet.setName}</B></font>
				<a href="pdf/question/${queSet.pdfFileName}" target="_blank"><img src="icon/pdf.png" /> </a>
				<input type="hidden" id="fileName" value="${queSet.pdfFileName}">
				<a type='button' href="download/question/file/${queSet.pdfFileName}" class="add_question_button" target="_blank">Download File</a>
			</h2>
		</div>
		</section> --%>

	<section id="cta" class="clear">
		<div class="one_third first">
			<h2 class="heading">
				<font color="red"><B>Course Name : ${questionSet.course}</B></font> <input
					type="hidden" id="courseName" value="${queSet.course}">
			</h2>
		</div>
		<div class="one_third">
			<h2 class="heading">
				<font color="red"><B>Subject Name : ${questionSet.subjectName}</B></font> <input
					type="hidden" id="subjectName" value="${queSet.subjectName}">
			</h2>
		</div>
		<div class="one_third">
			<h2 class="heading">
				<font color="red"><B>Set Name : ${questionSet.setName}</B></font> <input
					type="hidden" id="setName" value="${queSet.setName}">
				<%-- <a href="pdf/question/${queSet.pdfFileName}" target="_blank"><img src="icon/pdf.png" /> </a>
				<input type="hidden" id="fileName" value="${queSet.pdfFileName}">
				<a type='button' href="download/question/file/${queSet.pdfFileName}" class="add_question_button" target="_blank">Download File</a> --%>
			</h2>
		</div>
	</section>

	<div class="wrapper content">
			<section id="cta" class="clear"> 
				<ol>
					<c:forEach var="questionDetail" items="${queSet.questions}">
						<li style="font-size:20px";><h1>${questionDetail.question}</h1></li>
					</c:forEach> 
				</ol>
			</section>
		</div>
		
		<section id="cta" class="clear">
			<div id="content">
				<h2>Submit Your Answers</h2>
	
				<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
					<input type="hidden" value="${questionSet.setName}" id="setName" name="setName"/>
					<div class="one_quarter first">
						<label for="name">Name <span>*</span></label> <input type="text"
							name="name" id="name" value="" size="22" required="required">
					</div>
					<div class="one_quarter">
						<label for="phone">Phone No. <span>*</span></label> <input type="text"
							name="phone" id="phone" value="" size="22" required="required">
					</div>
					<div class="one_quarter">
						<label for="email">Email <span>*</span></label> <input type="text"
							name="email" id="email" value="" size="22" required="required">
					</div>
					<div class="one_quarter">
						<label for="upload">Upload <span>*</span></label> 
						<input id="upload" type="file" name="file" value="Upload File">
					</div>
					<div>
						&nbsp; <input type="submit" value="Submit" id="submit">
						<span id="result"></span>
					</div>
				</form>
			</div>
		</section>
		
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
	<script src="js/question-set.js"></script>
</body>
</html>