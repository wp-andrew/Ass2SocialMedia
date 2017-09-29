<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List" %>
<%@ page import="web.app.eng.dto.Post" %>

<html>
<%
String error = (String) request.getAttribute("error");
String isLoggedIn = (String) session.getAttribute("login");
String display = (String) session.getAttribute("display");
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>home</title>
</head>

<body>
	<%if (error != null) { %>
		<script>alert('${error}');</script>
	<%} %>
	
	<img src="https://www.unsw.edu.au/sites/default/files/UNSW_0.png" alt="UNSW Sydney">
	<%if (isLoggedIn == "true") { %>
		<jsp:include page="headerUser.jsp"/>
		<%if (display == "wall") { %>
			<jsp:include page="wall.jsp"/>
		<%} else if (display == "profile") { %>
			<jsp:include page="profile.jsp"/>
		<%} else if (display == "edit") { %>
			<jsp:include page="editProfile.jsp"/>
		<%} else if (display == "result") { %>
			<jsp:include page="result.jsp"/>
		<%} %>
	<%} else { %>
		<jsp:include page="headerLogin.jsp"/>
		<jsp:include page="registration.jsp"/>
	<%} %>
</body>

</html>