
<%@ include file="admin-menu.jsp"%>

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2">
	<div class="overlay">
		<div id="breadcrumb" class="clear">
			<ul>
				<li><a href="/home">Home</a></li>
				<li><a href="/ias-daily-questions">IAS question</a></li>
				<li><a href="/create-question">Create Question set</a></li>
			</ul>
		</div>
	</div>

</div>

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
	<section id="cta" class="clear">
		
		<div id="content">
			<h2>Create Your Question Set</h2>

			<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
			
				<div class="one_quarter first">
					<label for="course">Course <span>*</span></label> 
					<select name="course" id="course">
			           <option>IAS</option>
			           <option>Professional</option>   
			           <option>Medical</option>
			       </select>
				</div>
				<div class="one_quarter">
					<label for="name">Subject <span>*</span></label> 
					<input type="text" name="subject" id="subject" value="" size="22" required="required">
				</div>
				<div class="one_quarter">
					<label for="phone">Set Name<span>*</span></label> 
					<input type="text" name="setName" id="setName" value="" size="22" required="required">
				</div>
				<div class="one_quarter">
					<label for="email">Release date<span>*</span></label> 
					<input type="text" id="datepicker"></p>
				</div>
					
				<!-- <div class="one_quarter first"> -->
				<div class="block clear">
					&nbsp;<label for="name">Question 1. <span>*</span></label> 

					<textarea name="que1" id="que1" cols="100" rows="3"></textarea>
				</div>
				<!-- <div class="one_quarter"> -->
				<div class="block clear">
					&nbsp;<label for="phone">Question 2. <span>*</span></label> 
					<textarea name="que2" id="que2" cols="100" rows="3"></textarea>
					
				</div>
				<!-- <div class="one_quarter"> -->
				<div class="block clear">
					&nbsp;<label for="email">Question 3. <span>*</span></label> 
					<textarea name="que3" id="que3" cols="100" rows="3"></textarea>
					
				</div>
				<!-- <div class="one_quarter"> -->
				<div class="block clear">
					&nbsp;<label for="upload">Upload <span>*</span></label> <input id="upload"
						type="file" name="file" value="Upload File">
				</div>
				<div>
					&nbsp; <input type="submit" value="Submit" id="submit"> <span
						id="result"></span>
				</div>
			</form>
		</div>
	</section>

</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
	<section id="cta"></section>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->

<%@ include file="footer.jsp"%>
<script src="js/create_question.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</body>
</html>