<%--
  Created by IntelliJ IDEA.
  User: jgleg
  Date: 10/23/2018
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello ${username}!

<div class="col-xs-9 main">
    <!--  add a search box -->


    <div class="table-container">



        <!-- Table -->
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">

            <!-- need to associate this data with customer id -->

            <table>
                <tbody>


                <tr>
                    <td><label>Username:</label></td>
                    <td>${username}</td>
                </tr>

                <tr>
                    <td><label>Password:</label></td>
                    <td>${password}</td>
                </tr>

                </tbody>
            </table>


        </form:form>

        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>

    </div>

</div>
</body>
</html>
