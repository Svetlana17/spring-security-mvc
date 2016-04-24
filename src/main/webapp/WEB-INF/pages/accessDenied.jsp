<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<html>
<body>
	<h1>Access Denied</h1>	
	<h2>${message}</h2>
	
	<a href='<c:url value="/home" />'>Home Page</a>

</body>
</html>