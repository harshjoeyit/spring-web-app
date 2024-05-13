<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Add Todo Page</title>
</head>
<body>

	<div class="container">
		<h1>Login</h1>
		<pre>${errorMessage}</pre>
		
		<%-- <form method="post">
			Description: <input type="text" name="description">
			<input class="btn btn-primary" type="submit">
		</form> --%>
		
		<!-- Using form backing object -->
		<form:form method="post" modelAttribute="deafultTodo">
			Description: <form:input type="text" path="description" required="required" />
			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="username" />
			<form:input type="hidden" path="done" />
			<form:input type="hidden" path="targetDate" />
			<input type="submit" class="btn btn-primary">
		</form:form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

</body>
</html>