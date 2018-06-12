<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "e" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<% if(session.getAttribute("error") != null){ %>
			<h3><%= session.getAttribute("error") %></h3>
		<% } %>
<h1>What is code ?</h1>
<form action="/" method="post">
<input type="text" name="codeName">
<input type="submit" value="Try Code"/>
</form>
</body>
</html>