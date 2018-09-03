<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>

	<!-- reference our style sheet -->

	<!--  link type="text/css"
		  rel="stylesheet"
		  href="styles.css" /-->

	<style>#logo {
		border: 2px solid black;
		border-radius: 15px;
		color: black;
		padding: 2px;
		font-size: 25px;
	}

	#clockdiv {
		color: red;
	}

	.navbar {
		margin-bottom: 0 !important;
		background-color: #d9edf7 !important;
	}
	.navbar-header {
		margin-top: 10px;
	}
	h3 {
		text-align: center;
	}
	.panel-heading {
		text-align: center;
	}
	#logout {
		margin-top: -15px;
		margin-bottom: 5px;
		float: right;
	}

	.sidebar {
		background-color: #f8f8f8;
		height: 100vh;
	}
	.sidebar-container {
		width: 80%;
		margin: 30px auto;
	}
	.table-container {
		width: 70vw;
	}

	.table {
		width: 95%;
		margin: 5px auto;
	}
	.table-button {
		font-size: 10px !important;
	}

	.panel {
		margin-top: 80px;
		width: 100%;
		margin: 80px auto;
	}

	.search {
		width: 300px;
		float: right;
		margin: 15px 0;
	}

	.btn-primary {
		margin: 5px;
		width: 80%;
		min-width: 115px;
	}

	.btn-secondary {
		border: 1px solid black !important;
	}
	</style>
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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

