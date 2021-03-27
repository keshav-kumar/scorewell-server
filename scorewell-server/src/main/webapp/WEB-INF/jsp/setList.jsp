
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
					<li><a href="/set-list">Set List</a></li>
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
				<form action="/set-list" method="get">
					
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
			
			<div id="gen_study">
				<div id="comments">
					
					<h2>Question Sets</h2>
					<ul>
						<div class="scrollable">
							<table>
								<thead>
									<tr>
										<th>User Name</th>
						              	<th>Set Name</th>
						              	<th>Submitted Answer</th>
						              	<th>Reviewed</th>
						            </tr>
						            <c:forEach var="sets" items="${sets}">
				            			<tr>
				            				<td>${sets.userName}</td>
							              	<td>${sets.setName}</td>
							              	<td><a type='button' href="download/answer/file/${sets.phone}_${sets.emailId}_${sets.fileName}" class="add_question_button" target="_blank">Download Answer</a></td>
						              		<c:choose>
							              		<c:when test="${sets.evaluated == true }">
							              			<c:choose>
							              				<c:when test="${empty sets.reviewComment}">
							              				<td><a type='button' href="download/reviewed/file/${sets.phone}_${sets.emailId}_${sets.fileName}" class="add_question_button" target="_blank"><font color="green">Download Review</font></a></td>
							              				</c:when>
							              				<c:otherwise>
															<td><a
																href="/reviewcomment?name=${sets.userName}&phone=${sets.phone}&email=${sets.emailId}&setName=${sets.setName}"><font
																	color="green">View Comment</font></a></td>
														</c:otherwise>
							              			</c:choose>
								              	</c:when>
								              	<c:otherwise>
										            <td>Review Pending.</td>
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
<!-- 	<script src="js/setList.js"></script> -->
	
</body>
</html>