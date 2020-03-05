
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="navbar navbar-default">

	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
	</div>

	<div class="navbar-collapse collapse navbar-responsive-collapse">
		<form class="navbar-form navbar-right">
			<input type="text" class="form-control" placeholder="Search">
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li class="active"><a href="student">Home</a></li>
			<li><a href="student/signup">Signup</a></li>
			<li><a href="student/login">Login</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Explore<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="student">Contact us</a></li>
					<li class="divider"></li>
					<li><a href="student">Further Actions</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- /.nav-collapse -->
</div>
