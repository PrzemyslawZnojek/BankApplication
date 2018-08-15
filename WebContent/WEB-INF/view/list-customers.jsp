<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</head>

<body>


	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">

			
			<input type="button" value="Add Account"
				   onclick="window.location.href='showFormForAddAccount'; return false;"
				   class="add-button"
			/>
			
			<!--  add a search box -->
            <form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
			<table>
				<tr>
					<th>customerID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerID" value="${tempCustomer.customerID}" />
					</c:url>
				
				<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerID" value="${tempCustomer.customerID}" />
					</c:url>
				
				<tr>
					<td>${tempCustomer.customerID}</td>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.country}</td>
					
					<td>
					<!-- display the update link -->
					<a href="${updateLink}">Update</a>
					|
					<a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure that you want to delete this user?'))) return false">Delete</a>
					</td>
					
				</tr>
				</c:forEach>
			</table>
				<form:form action="${pageContext.request.contextPath}/logout" 
			   				method="POST">
	
						<input type="submit" value="Logout" />
	
				</form:form>
			
		</div>
	</div>

</body>

</html>









