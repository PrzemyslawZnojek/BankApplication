<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <link rel="stylesheet"
          href="<c:url value="/resources/css/access-denied-styles.css" />">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        function goBack() {
            window.history.back()
        }
    </script>

</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="title">
            <h3>Access Denied</h3>
        </div>
    </div>
</nav>

<div>


    <h1>You do not have permission to that resources.</h1>
    <div class="goBackButton">
        <button onclick="goBack()">Go Back</button>
    </div>
</div>
</body>

</html>








