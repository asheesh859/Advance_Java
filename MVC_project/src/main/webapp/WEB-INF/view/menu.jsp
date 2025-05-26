<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
    }

    body {
        background-color: #f0f2f5;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .menu-container {
        background: #fff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 90%;
        max-width: 400px;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    .menu-link {
        display: block;
        text-decoration: none;
        color: white;
        background-color: #007bff;
        padding: 12px 20px;
        margin: 10px 0;
        border-radius: 6px;
        font-size: 16px;
        transition: background-color 0.3s ease;
    }

    .menu-link:hover {
        background-color: #0056b3;
    }

    @media (max-width: 480px) {
        .menu-container {
            padding: 20px;
        }

        .menu-link {
            font-size: 15px;
            padding: 10px 15px;
        }
    }
</style>
</head>
<body>
    <div class="menu-container">
        <h2>Menu</h2>
        <a class="menu-link" href="RegistrationController">Create Registration</a>
        <a class="menu-link" href="ReadRegistration">Show Registrations</a>
    </div>
</body>
</html>
	