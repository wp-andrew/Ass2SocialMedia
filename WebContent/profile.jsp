<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="java.util.List" %>
<%@ page import="web.app.eng.dto.User" %>
<%@ page import="web.app.eng.service.UserService" %>

<html>

<%
User user = (User) session.getAttribute("user");
UserService userService = new UserService();
List<User> friends = userService.getFriendList(user.getUsername());
%>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>headUser</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Armata">
    <link rel="stylesheet" href="assets/css/MUSA_timeline.css">
    <link rel="stylesheet" href="assets/css/MUSA_timeline1.css">
    <link rel="stylesheet" href="assets/css/Responsive-feedback-form.css">
    <link rel="stylesheet" href="assets/css/Responsive-feedback-form1.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <div>
        <div class="container">
        	<h2>PROFILE</h2>
			<form action="control" method="POST">
				<input type="hidden" name="action" value="edit">
				<input type="submit" value="Edit Profile">
			</form>
            <div class="row" style="padding-top:90px;">
                <div class="col-md-12" style="width:300px;"><img src="assets/img/2.jpg" style="width:240px;height:240px;"></div>
                <div class="col-md-12" style="width:620px;">
                    <textarea style="width:600px;">Username : <%=user.getUsername() %></textarea>
                    <textarea style="width:600px;">Firstname : <%=user.getFirstname() %></textarea>
                    <textarea style="width:600px;">Surname : <%=user.getSurname() %></textarea>
                    <textarea style="width:600px;">Gender : <%=user.getGender() %></textarea>
                    <textarea style="width:600px;">Email : <%=user.getEmail() %></textarea>
                    <textarea style="width:600px;">DoB : <%=user.getBirthdate() %>/<%=user.getBirthmonth() %>/<%=user.getBirthyear() %></textarea>
                    <textarea style="width:600px;">
					<%for (User friend : friends) {%>
						<%=friend.getFirstname() %> <%=friend.getSurname() %>
					<%} %>
					</textarea>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>