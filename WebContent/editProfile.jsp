<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="web.app.eng.dto.User" %>

<html>

<%
User user = (User) session.getAttribute("user");
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>editProfile</title>
</head>

<body>
	<h1>Edit Profile</h1>
	<%=user.getUsername() %><br/><br/>
	
	<form action="control" method="POST">
		<input type="hidden" name="action" value="update">
		
		<%=user.getFirstname() %> <%=user.getSurname() %><br/>
		<input type="text" name="firstname" placeholder="New Firstname"><!--
		--><input type="text" name="surname" placeholder="New Surname"><br/>
		
		<%=user.getEmail() %><br/>
		<input type="text" name="email" placeholder="New Email address" size="45"><br/>
		<input type="password" name="password" placeholder="New password" size="45"><br/><br/>
		
		DoB: <%=user.getBirthdate() %>/<%=user.getBirthmonth() %>/<%=user.getBirthyear() %><br/>
		<select name="birthdate">
			<%for (int i=31; i>=1; i--) { %>
				<option value="<%=i %>"><%=i %></option>
			<%} %>
		</select><!--
		--><select name="birthmonth">
			<%for (int i=12; i>=1; i--) { %>
				<option value="<%=i %>"><%=i %></option>
			<%} %>
		</select><!--
		--><select name="birthyear">
			<%for (int i=2017; i>=1905; i--) { %>
				<option value="<%=i %>"><%=i %></option>
			<%} %>
		</select><br/><br/>
		
		<%=user.getGender() %><br/>
		<input type="radio" name="gender" value="male">Male
		<input type="radio" name="gender" value="female">Female<br/><br/>
		
		<input type="submit" value="Save">
	</form>
</body>

</html>