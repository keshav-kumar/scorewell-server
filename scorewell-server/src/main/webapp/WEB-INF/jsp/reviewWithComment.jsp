	
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

		<div class="one_third first">
			<h2 class="heading">
				<B><font color="blue">Course Name : </font></B> ${questionFile.course}
			</h2>
		</div>
		<div class="one_third">
			<h2 class="heading">
				<B><font color="blue">Subject Name : </font></B> ${questionFile.subjectName}
			</h2>
		</div>
		<div class="one_third">
			<h2 class="heading">
				<B><font color="blue">Set Name :</font></B> ${questionFile.setName}
			</h2>
		</div>
	</section>

	<section id="cta" class="clear">
		<div class="one_half first">
			<h2 class="heading">
				<font color="blue"><B>Question Set : </B></font>
				<ol>
					<c:forEach var="questionDetail" items="${questionFile.questions}">
						<li style="font-size: 20px";><h1>${questionDetail.question}</h1></li>
					</c:forEach>
				</ol>
			</h2>
			<h2 class="heading">
				<font color="blue"><B>Answer : </B></font> 
				<a href="download/answer/file/${activityDetails.fileName}" target="_blank"><font color="black">Click To Download</font></a>
			</h2>

			<c:choose>
				<c:when test="${activityDetails.reviwedUploaded == true }">
					<h2 class="heading">
						<font color="blue"><B>Reviewed : </B></font>
						<a href="download/reviewed/file/${activityDetails.fileName}" target="_blank"><font color="black">Click To Download</font></a>
					</h2>
				</c:when>

			</c:choose>

		</div>
	</section>

	<!-- <div class="wrapper content"> -->
			<section id="cta" class="clear"> 
				<label><h2><B><font color="blue">Review Comments :</font></B> </h2></label>
				<ol>
					<li style="font-size:20px";><h1>${activityDetails.reviewComment}</h1></li>
				</ol>
			</section>
		<!-- </div> -->
		
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