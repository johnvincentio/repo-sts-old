<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title><spring:message code="user.title" /></title>
<jsp:include page="/WEB-INF/views/i18/include/head-include.jsp" />
</head>

<body bgcolor="<spring:theme code='background'/>">
	Change language:
	<a href="i18/user?mylocale=en">English </a> | <a href="i18/user?mylocale=de">German </a>
	<br />
	<br /> Change theme:
	<a href="i18/user?mytheme=theme1">Theme 1 </a> | <a href="i18/user?mytheme=theme2"> Theme 2 </a>

	<h3>
		<spring:message code="user.title" />
	</h3>
	<table>
		<form:form action="i18/save" method="post" commandName="user">
			<tr>
				<td><spring:message code="user.name" />:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.age" /> :</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td colspan=2><spring:message code="user.submit" var="valSubmit"></spring:message> <input type="submit" value="${valSubmit}"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>
