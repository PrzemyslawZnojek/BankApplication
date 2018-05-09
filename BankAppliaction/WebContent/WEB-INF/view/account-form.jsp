<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Account</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Account</h3>
	
		<form:form action="saveAccount" modelAttribute="account" method="POST">

		
			<!-- need to associate this data with customer id -->
			<form:hidden path="accountID" />
					
			<table>
				<tbody>
				
					<tr>
						<td><label>Id Of Customer:</label></td>
						<td><form:input path="idOfCustomer" /></td>
					</tr>
				
					<tr>
						<td><label>Balance:</label></td>
						<td><form:input path="balance" /></td>
					</tr>
					
					<tr>
						<td><label>AccountNumber:</label></td>
						<td><form:input path="accountNumber" /></td>
					</tr>
					
					<tr>
						<td><label>Username:</label></td>
						<td><form:input path="username" /></td>
					</tr>
					
				

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
		
		
		<form:form action="saveAccount" modelAttribute="account" method="POST">

		
			<!-- need to associate this data with customer id -->
			<form:hidden path="accountID" />
					
			<table>
				<tbody>
				
					<tr>
						<td><label>Id Of Customer:</label></td>
						<td><form:input path="idOfCustomer" /></td>
					</tr>
					</tbody>
			</table>
		</form:form>
		
		
		
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










