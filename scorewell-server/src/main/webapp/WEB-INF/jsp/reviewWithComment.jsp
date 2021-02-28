	
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
		<section id="cta" class="clear">
		
		<div class="one_half first">
		
		</div>
		
		<div class="one_half first">
			<h2 class="heading">
				<font color="blue"><B>Question Set : </B></font>
				<a type='button' href="download/question/file/${questionFile}" class="add_question_button" target="_blank">Download File</a>
			</h2>
			<h2 class="heading">
				<font color="blue"><B>Answer : </B></font>
				<%-- <a href="pdf/question/${queSet.pdfFileName}" target="_blank"><img src="icon/pdf.png" /> </a> --%>
				<input type="hidden" id="fileName" value="${queSet.pdfFileName}">
				<a type='button' href="download/answer/file/${activityDetails.phone}_${activityDetails.emailId}_${activityDetails.fileName}" class="add_question_button" target="_blank">Download File</a>
			</h2>
			
			<c:choose>
				<c:when test="${activityDetails.reviwedUploaded == true }">
					<h2 class="heading">
						<font color="blue"><B>Reviewed : </B></font>
						<%-- <a href="pdf/question/${queSet.pdfFileName}" target="_blank"><img src="icon/pdf.png" /> </a> --%>
						<input type="hidden" id="fileName" value="${queSet.pdfFileName}">
						<a type='button' href="download/reviewed/file/${activityDetails.phone}_${activityDetails.emailId}_${activityDetails.fileName}" class="add_question_button" target="_blank">Download File</a>
					</h2>
				</c:when>
			
			</c:choose>
			
		</div>
		</section>
		
		<div class="wrapper content">
			<section id="cta" class="clear"> 
				<label><h2>Review Comments : </h2></label>
				<ol>
					<li style="font-size:20px";><h1>${activityDetails.reviewComment}</h1></li>
				</ol>
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
	<script src="js/question-set.js"></script>
</body>
</html>