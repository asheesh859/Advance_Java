<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Data</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
    }

    .navbar {
        background-color: #007bff;
        padding: 15px;
        text-align: center;
    }

    .navbar a {
        color: white;
        text-decoration: none;
        margin: 0 15px;
        font-weight: bold;
        font-size: 16px;
    }

    .navbar a:hover {
        text-decoration: underline;
    }

    .container {
        padding: 30px 20px;
    }

    h2 {
        text-align: center;
        margin-bottom: 30px;
        color: #333;
    }

    table {
        width: 100%;
        max-width: 1000px;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        overflow: hidden;
    }

    th, td {
        padding: 12px 15px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #007bff;
        color: white;
        font-weight: 600;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    .delete-icon , .update-icon {
        color: red;
        font-weight: bold;
        font-size: 18px;
        cursor: pointer;
        text-decoration: none;
    }

    .delete-icon:hover {
        color: darkred;
    }
    .update-icon:hover {
        color: darkred;
    }
    

    @media (max-width: 600px) {
        table, th, td {
            font-size: 14px;
        }

        .navbar a {
            display: block;
            margin: 10px 0;
        }
    }
</style>
</head>
<body>

    <div class="navbar">
        <a href="RegistrationController">Create Registration</a>
        <a href="ReadRegistration">Show Registrations</a>
    </div>

    <div class="container">
        <h2>Registered Users</h2>

        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Course</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Action</th>
            </tr>

            <%
                ResultSet result = (ResultSet) request.getAttribute("registration");
                if (result != null) {
                    while (result.next()) {
                        int id = result.getInt(1);
            %>
            <tr>
                <td><%= id %></td>
                <td><%= result.getString(2) %></td>
                <td><%= result.getString(3) %></td>
                <td><%= result.getString(4) %></td>
                <td><%= result.getString(5) %></td>
                <td>
                    <a class="delete-icon" href="DeleteRegistration?id=<%=id%>" onclick="return confirm('Are you sure you want to delete this record?');">
                        ❌
                    </a>
                    <a class="update-icon" href="UpdateRegistration?id=<%=id%>">
                        ✏️
                    </a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
