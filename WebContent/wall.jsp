<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List" %>
<%@ page import="web.app.eng.dto.Post" %>
<%@ page import="web.app.eng.dto.User" %>
<%@ page import="web.app.eng.service.PostService" %>

<html>

<%
User user = (User) session.getAttribute("user");
PostService postService = new PostService();
List<Post> posts = postService.getPostList(user.getUsername());
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>wall</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Armata">
	<link rel="stylesheet" href="assets/css/MUSA_timeline.css">
	<link rel="stylesheet" href="assets/css/MUSA_timeline1.css">
	<link rel="stylesheet" href="assets/css/Navigation-with-Search1.css">
	<link rel="stylesheet" href="assets/css/Responsive-feedback-form.css">
	<link rel="stylesheet" href="assets/css/Responsive-feedback-form1.css">
	<link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
		<div class="container">
		<div class="row">
			<div class="col-md-6" style="padding-top:90px;">
				<div id="form-div" style="margin-right:50px;margin-left:50px;width:500px;">
					<form method="post" style="width:500px;">
						<div class="form-group" style="width:500px;">
							<div class="row">
								<div class="col-md-12">
									<h1 class="text-center" style="font-family:Armata, sans-serif;font-size:30px;"><strong>Post Board</strong></h1></div>
							</div>
							<hr id="hr" style="background-color:#c3bfbf;">
							<div class="row">
								<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1">
									<p style="font-family:Armata, sans-serif;font-size:22px;">Topic: </p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1">
									<input class="form-control" type="email" name="email" style="font-size:15px;font-family:Armata, sans-serif;">
								</div>
							</div>
							<div class="row" style="font-family:Armata, sans-serif;margin-top:10px;">
								<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1">
									<p style="font-family:Armata, sans-serif;font-size:22px;"><strong>Content: </strong></p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1">
									<textarea class="form-control" rows="7" name="feedback" maxlength="250" style="font-family:Armata, sans-serif;font-size:15px;"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1">
									<p class="text-right" style="font-family:Armata, sans-serif;">Max length 250 characters</p>
									<p style="font-family:Armata, sans-serif;font-size:22px;">File-upload: </p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 col-md-offset-5 col-sm-5 col-sm-offset-4 col-xs-9 col-xs-offset-1" style="width:300px;">
									<button class="btn btn-warning" type="reset" style="font-family:Armata, sans-serif;font-size:14px;color:rgb(0,0,0);">Reset </button>
									<button class="btn btn-success" type="submit" id="submit-btn" style="font-family:Armata, sans-serif;font-size:14px;color:rgb(0,0,0);">Submit </button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-6" style="padding-top:90px;">
				<%if (posts != null) { %>
					<%for (Post post : posts) {%>
					<li class="list-group-item">
						<textarea class="input-lg" readonly="" style="min-height:200px;min-width:500px;height:0px;max-height:none;"><%=post.getPoster() %><br/>
						<%=post.getContent() %></textarea>
					</li>
					<%} %>
				<%} %>
			</div>
			<div class="col-md-12"></div>
		</div>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>

	<%--
	<div class="container">
		<h2>WALL</h2>
		<ul class="list-group">
			<%if (posts != null) { %>
				<%for (Post post : posts) {%>
					<li class="list-group-item">
					<%=post.getPoster() %><br/>
					<%=post.getContent() %>
					</li>
				<%} %>
			<%} %>
		</ul>
	</div>
	--%>
</body>

</html>
