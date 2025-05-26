<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        background-color: #f7f9fc;
        min-height: 100vh;
    }

    /* Navbar (menu.jsp styling) */
    .navbar {
        background-color: #007bff;
        padding: 15px 20px;
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
        display: flex;
        justify-content: center;
        padding: 40px 20px;
    }

    form {
        background: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        width: 100%;
        max-width: 500px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: 600;
        color: #555;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 16px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #218838;
    }

    .message {
        text-align: center;
        margin-top: 15px;
        color: blue;
        font-weight: bold;
    }

    @media (max-width: 480px) {
        form {
            padding: 20px;
        }

        .navbar a {
            display: block;
            margin: 10px 0;
        }
    }
</style>
</head>
<body>

    <!-- Top-aligned menu -->
    <div class="navbar">
        <a href="RegistrationController">Create Registration</a>
        <a href="ReadRegistration">Show Registrations</a>
    </div>

    <!-- Centered registration form -->
    <div class="container">
        <form action="RegistrationController" method="post">
            <h2>Registration Page</h2>

            <label for="name">Name</label>
            <input type="text" name="name" id="name" required />

            <label for="course">Course</label>
            <input type="text" name="course" id="course" required />

            <label for="email">Email</label>
            <input type="text" name="email" id="email" required />

            <label for="mobile">Mobile</label>
            <input type="text" name="mobile" id="mobile" required />

            <input type="submit" value="Submit" />

            <% if(request.getAttribute("message") != null) { %>
                <div class="message">
                    <%= request.getAttribute("message") %>
                </div>
            <% } %>
        </form>
    </div>

</body>
</html>
