<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
		<spring:message code="user.success" />
	</h3>
</body>
</html>
