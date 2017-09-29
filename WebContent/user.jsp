<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

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

<style>
textarea{
	overflow:hidden;
	resize: none;
	width:500px;
}
</style>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>headUser</title>
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
    <div>
        <nav class="navbar navbar-default navbar-fixed-top navigation-clean-search" style="padding-bottom:90;">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand navbar-link" href="#" style="padding-right:20px;"><strong>UNSW Book</strong></a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li role="presentation"><a href="#">Profile </a></li>
                        <li role="presentation"><a href="#">Home </a></li>
                        <li role="presentation"><a href="#">Find friends</a></li>
                        <li class="dropdown" style="width:150px;"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Advance search<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation"><a href="#">Gender </a></li>
                                <li role="presentation"><a href="#">Name </a></li>
                                <li role="presentation"><a href="#">User Name</a></li>
                                <li role="presentation"><a href="#">Date of Birth</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" target="_self">
                        <div class="form-group">
                            <label class="control-label" for="search-field"><i class="glyphicon glyphicon-search" style="padding-left:0px;"></i></label>
                            <input class="form-control search-field" type="search" name="search" autocomplete="on" id="search-field" style="padding-right:200px;">
                        </div><img src="assets/img/1.jpg" style="width:30px;height:30px;padding-left:0px;"><i class="glyphicon glyphicon-globe" style="padding-right:30px;padding-left:30px;"></i><i class="glyphicon glyphicon-log-out" style="padding-left:0px;"></i></form>
                </div>
            </div>
        </nav>
    </div>
    <div>
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
                                            <form action = "UploadServlet" method = "post"
                                                enctype = "multipart/form-data">
                                                <input type = "file" name = "file" size = "50" />
                                                <br />
                                                <input type = "submit" value = "Upload File" />
                                            </form>
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
					<% for (Post post : posts) {%>
						<textarea>
						<%=post.getPoster() %>
						<%=post.getContent() %>
						</textarea>
					<%} %>
                </div>
            </div>
        </div>
    </div>
    <div class="container" style="margin-top:51px;width:700px;"></div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>