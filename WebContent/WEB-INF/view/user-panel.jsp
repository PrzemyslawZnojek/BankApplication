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
                <span id="logo">CP</span>
            </a>
        </div>
        <div class="title">
            <h3>Client Panel</h3>
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
        <input type="button" value="Make Transfer"
               onclick="window.location.href='makeTransfer'; return false;"
               class="btn btn-primary"
        />
        <input type="button" value="Incoming Transfers"
               onclick="window.location.href='receiverOrderItemList'; return false;"
               class="btn btn-primary"
        />
        <input type="button" value="Outgoing Transfers"
               onclick="window.location.href='senderOrderItemList'; return false;"
               class="btn btn-primary"
        />
    </div>
</div>

<div class="col-xs-9 main">
    <div class="table-container">
        <form:form action="saveCustomer" modelAttribute="account" method="POST">
            <table>
                <tbody>

                <tr>
                    <td><label>Username:</label></td>
                    <td>${account.username}</td>
                </tr>

                <tr>
                    <td><label>First Name:</label></td>
                    <td>${account.customer.firstName}</td>
                </tr>

                <tr>
                    <td><label>Last Name:</label></td>
                    <td>${account.customer.lastName}</td>
                </tr>

                <tr>
                    <td><label>Account Number:</label></td>
                    <td>${account.accountNumber}</td>
                </tr>

                <tr>
                    <td><label>Balance:</label></td>
                    <td>${account.balance}</td>
                </tr>

                </tbody>
            </table>
        </form:form>
    </div>
</div>
<script src="<c:url value="/resources/javaScript/logoutTimer.js" />"></script>
</body>

</html>
