
	<%@ include file="admin-menu.jsp"%>

	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row2">
		<div class="overlay">
			<div id="breadcrumb" class="clear">
				<ul>
					<li><a href="/home">Home</a></li>
					<!-- <li><a href="/ias-daily-questions?course=IAS">IAS question</a></li> -->
					<!-- <li><a href="/set-list">Set List</a></li> -->
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
			<div class="sdb_holder">
				<h6>Evaluated Answer Sheets</h6>
				<form action="/admin-answer-list" method="get">
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
						&nbsp;<input type="submit" value="Submit" id="search">
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
			<h1 class="text-center"><B>Review Answers</B></h1>
			
			<div id="gen_study">
				<div id="comments">
					
					<h2>Answer Sets</h2>
					<ul>
						<div class="scrollable">
							<table>
								<thead>
									<tr>
										<th>User Name</th>
										<th>Set Name</th>
						              	<th>Submit Answer</th>
						              	<th>Reviewed</th>
						            </tr>
						            <c:forEach var="sets" items="${answerSheet}">
				            			<tr>
				            				<td>${sets.userName}</td>
							              	<td>${sets.setName}</td>
							              	<td>${sets.uploadDateTime} 
							              		<%-- <a href="/pdf/answer/${sets.phone}_${sets.emailId}_${sets.fileName}" target="_blank"><img src="icon/pdf.png" /> </a> --%>
							              		<a type='button' href="download/answer/file/${sets.phone}_${sets.emailId}_${sets.fileName}" class="add_question_button" target="_blank">Download Answer</a>
							              	</td>
							                  
						              		<c:choose>
							              		<c:when test="${sets.evaluated == true }">
									              	<td>
									              		<!-- <font color="green">Reviewed.</font> -->
									              		<%-- <a href="/pdf/reviewed/${sets.phone}_${sets.emailId}_${sets.fileName}" target="_blank"><img src="icon/pdf.png" /> </a> --%>
									              		<a type='button' href="download/reviewed/file/${sets.phone}_${sets.emailId}_${sets.fileName}" class="add_question_button" target="_blank"><font color="green">Download Review</font></a>
									              	</td>
								              	</c:when>
								              	<c:otherwise>
										            <td>
										            	<form action="/upload-review" method="get">
											            	<font color="red">Review Pending.</font>
											            	<input type="hidden" name="userName" id="userName" value="${sets.userName}">
											            	<input type="hidden" name="phone" id="phone" value="${sets.phone}">
											            	<input type="hidden" name="emailId" id="emailId" value="${sets.emailId}">
											            	<input type="hidden" name="setName" id="setName" value="${sets.setName}">
											            	<input type="hidden" name="fileName" id="fileName" value="${sets.fileName}">
															<!-- <input type="submit" value="Upload Review" id="submit"> -->
															<div>
																&nbsp;<input type="submit" value="Upload Review" id="submit">
															</div>
														</form>
										            </td>
										         </c:otherwise>
								              </c:choose>
						            	</tr>
						            </c:forEach>
								</thead>
							</table>
						</div>
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
	<!-- <script src="js/review-page.js"></script> -->
	
</body>
</html>