<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Score Well Home</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<!-- <link href="css/about.css" rel="stylesheet" type="text/css" media="all"> -->
<!-- <link rel="stylesheet" type="text/css" href="css/bootstrap4/bootstrap.min.css"> -->
<link rel="stylesheet" type="text/css" href="css/custom.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">

</head>
<body id="top">
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row0">
		<header id="header" class="hoc">
			<div id="logo" class="fl_left">
				<h1>
					<a href="/home">Score Well</a>
				</h1>
			</div>
			<!-- <div id="logo" class="fl_left">
						<img src="img/logo.png" alt="">
					</div> -->
			<div class="fl_right">
				<ul class="nospace heading">
					<li><a href="#"><font color="blue"><B>Login</B></font></a></li>
				</ul>
			</div>
		</header>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<div class="wrapper row1">
		<div id="topbar" class="clear">
			<nav id="mainav" class="fl_left">
				<ul class="clear">
					<li><a href="/home">Home</a></li>
					<li><a href="/admin">Admin</a></li>
					<li><a href="/create-question">Create Set</a></li>
					<li><a href="/admin-answer-list">Review Answers</a></li>
				</ul>
			</nav>
			<div id="search" class="fl_right">
				<form class="clear" method="post" action="#">
					<fieldset>
						<legend>Search:</legend>
						<input type="text" value="" placeholder="Search Here">
						<button class="fa fa-search" type="submit" title="Search">
							<em>Search</em>
						</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	