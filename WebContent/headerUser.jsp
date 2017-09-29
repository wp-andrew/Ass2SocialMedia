<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<style>
body {
	margin:0;
}

.top-navigation {
	background-color: #FFD833;
	padding: 15px;
	border: 1px solid black;
}

.inline-form {
	display: inline-block;
}

.box {
	background-color: #FFD833;
	color: White;
	font-size: 16px;
	height: 50px;
	cursor: pointer;
}

.box:hover {
	background-color: #FFC833;
}

.dropdown {
	overflow: visible;
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: white;
	width: 400px;
	box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	z-index: 1;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>headerUser</title>
</head>

<body>
	<div class="top-navigation">
		<form class="inline-form" action="control" method="POST">
			<input type="hidden" name="action" value="search">
			<select class="box" name="tagName">
				<option value="firstname">Firstname</option>
				<option value="surname">Surname</option>
				<option value="gender">Gender</option>
				<option value="dob">DoB</option>
			</select>
			<input name="searchValue" class="box" type="text">
			<input class="box" type="submit" value="Search">
		</form>
		<form class="inline-form" action="control" method="POST">
			<input type="hidden" name="action" value="profile">
			<input class="box" type="submit" value="Profile">
		</form>
		<form class="inline-form" action="control" method="POST">
			<input type="hidden" name="action" value="home">
			<input class="box" type="submit" value="Home">
		</form>
		<div class="dropdown">
			<button class="box">Notifications</button>
			<div class="dropdown-content">
				Notification 1<br/>
				Notification 2<br/>
				Notification 3
			</div>
		</div>
		<form class="inline-form" action="control" method="POST">
			<input type="hidden" name="action" value="logout">
			<input class="box" type="submit" value="Log Out">
		</form>
	</div>
</body>

</html>