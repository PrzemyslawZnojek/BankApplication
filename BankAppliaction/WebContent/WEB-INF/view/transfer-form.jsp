<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Make Transfer</title>

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
		<h3>Make Transfer</h3>
	
		<form:form action="saveTransfer" modelAttribute="orderitem" method="POST">
		
		<!-- need to associate this data with customer id -->
			<form:hidden path="orderItemID" />
		
		<table>
				<tbody>
				
					<tr>
						<td><label>Amount:</label></td>
						<td><form:input path="amount" /></td>
					</tr>
					
					<tr>
						<td><label>Your Account Number:</label></td>
						<td><form:input path="accountNumberSender" /></td>
					</tr>
					
					<tr>
						<td><label>Receiver Account Number:</label></td>
						<td><form:input path="accountNumberReceiver" /></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
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