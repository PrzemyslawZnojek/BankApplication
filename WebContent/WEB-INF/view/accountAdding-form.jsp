<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>

	<link rel="stylesheet"
		  href="<c:url value="/resources/css/styles.css" />" >

	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<meta http-equiv="refresh" content="<%=session.getMaxInactiveInterval()%>;url=showMyLoginPage"/>
</head>

<body>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">
				<span id="logo">CRM</span>
			</a>
		</div>
		<div class="title">
			<h3>Customer Relationship Manager</h3>
			<form:form action="${pageContext.request.contextPath}/logout"
					   method="POST"
					   id="logout">
				<div id="clockdiv"></div>
				<input type="submit" value="Logout" class="btn btn-secondary btn-sm"/>
			</form:form>
		</div>
	</div>
</nav>

<div class="col-xs-9 main">
	<!--  add a search box -->


	<div class="table-container">

		<form:form action="saveAccount" modelAttribute="registerObject" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="account.accountID" />

			<table>
				<tbody>

				<tr>
					<td><label>Balance:</label></td>
					<td><form:input path="account.balance" /></td>
				</tr>

				<tr>
					<td><label>Username:</label></td>
					<td><form:input path="account.username" /></td>
				</tr>

				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="customer.firstName" /></td>
				</tr>

				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="customer.lastName" /></td>
				</tr>

				<tr>
					<td><label>Country:</label></td>
					<td><form:input path="customer.country" /></td>
				</tr>

				<tr>
					<td><label>User Enable:</label></td>
					<td><form:select path="users.enabled">
						<form:options items="${enable}" />
					</form:select>
					</td>
				</tr>

				<tr>
					<td><label>User Role:</label></td>
					<td><form:select path="authorities.authority">
						<form:options items="${role}" />
					</form:select>
					</td>
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>


				</tbody>
			</table>


		</form:form>

		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>

	</div>

</div>
<script src="<c:url value="/resources/javaScript/logoutTimer.js" />"></script>
</body>


</html>

