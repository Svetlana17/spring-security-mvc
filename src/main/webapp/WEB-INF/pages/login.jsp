<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Spring Security</title>
</head>
<body>
	<div>
		<form action="login" method="post">
			<fieldset>
				<legend>Please Login</legend>
				<c:if test="${param.error != null}">
					<div>
						<p>Authentication Failed : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div>
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
				<label for="username">Username</label> <input type="text"
					id="username" name="username" /> <br> <label for="password">Password</label>
				<input type="password" id="password" name="password" /> <br>
				<div>
					<button type="submit">Log in</button>
				</div>
			</fieldset>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>