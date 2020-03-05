<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<jsp:include page="/WEB-INF/views/student/include/head-include.jsp" />
</head>
<body>

	<jsp:include page="/WEB-INF/views/student/include/nav-include.jsp" />

	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>List Students</h1>
			</div>
		</div>

		<div>
        	<table border="1">
        		<tr>
		        	<th>No</th>
		        	<th>Username</th>
		        	<th>Email</th>
		        	<th>First Name</th>
		        	<th>Last Name</th>
		        	<th>DOB</th>
		        	<th>Actions</th>
	        	</tr>
	        	
				<c:forEach var="student" items="${allStudents}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${student.userName}</td>
					<td>${student.emailAddress}</td>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.dateOfBirth}</td>
					<td>
						<a href="student/edit?id=${student.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="student/delete?id=${student.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/student/include/script-include.jsp" />

</body>
</html>
