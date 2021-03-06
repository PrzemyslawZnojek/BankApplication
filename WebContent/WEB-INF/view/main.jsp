<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <link rel="stylesheet"
          href="<c:url value="/resources/css/styles.css" />">

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

<div class="col-xs-3 sidebar">
    <div class="sidebar-container">

        <input type="button" value="Add Account"
               onclick="window.location.href='showFormForAddAccount'; return false;"
               class="btn btn-primary"
        />

    </div>
</div>
<div class="col-xs-9 main">
    <!--  add a search box -->


    <div class="table-container">

        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">Panel heading</div>

            <!-- Table -->
            <table class="table">
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
                        <c:param name="customerID" value="${tempCustomer.customerID}"/>
                    </c:url>

                    <!-- construct an "delete" link with customer id -->
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerID" value="${tempCustomer.customerID}"/>
                    </c:url>

                    <tr>
                        <td>${tempCustomer.customerID}</td>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.country}</td>

                        <td>
                            <!-- display the update link -->
                            <a href="${updateLink}" class="btn btn-success btn-sm table-button">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure that you want to delete this user?'))) return false"
                               class="btn btn-danger btn-sm table-button">Delete</a>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>

</div>
<script src="<c:url value="/resources/javaScript/logoutTimer.js" />"></script>
</body>

</html>








