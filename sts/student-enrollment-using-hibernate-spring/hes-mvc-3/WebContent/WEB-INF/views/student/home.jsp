<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<jsp:include page="/WEB-INF/views/student/include/head-include.jsp" />

	<style>
	body {
		height: 100%;
		margin: 0;
		background: url(resources/assets/img/books.jpg);
		background-size: 1440px 800px;
		background-repeat: no-repeat;
		display: compact;
	}
	</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/student/include/nav-include.jsp" />

	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>Welcome ${student.userName} to Online Student Enrollment!</h1>
				<p>To get started, you need to enter your details to enroll with
					us. Or login to access your details, if you are already enrolled.</p>
			</div>

			<a class="btn btn-primary" href="student/signup">Signup » </a>
			<a class="btn btn-primary" href="student/login">Login » </a>
			<a class="btn btn-primary" href="student/list">List » </a>
		</div>

		<div></div>
	</div>

	<jsp:include page="/WEB-INF/views/student/include/script-include.jsp" />

</body>
</html>
