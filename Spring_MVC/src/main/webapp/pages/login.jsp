<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>

  <!-- Bootstrap 5 CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      background: linear-gradient(135deg, #6a11cb, #2575fc);
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .login-card {
      background: #fff;
      border-radius: 12px;
      padding: 30px;
      box-shadow: 0 6px 18px rgba(0, 0, 0, 0.2);
      width: 100%;
      max-width: 400px;
    }
    .login-card h3 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }
    .form-control:focus {
      border-color: #2575fc;
      box-shadow: 0 0 5px rgba(37, 117, 252, 0.5);
    }
    .btn-primary {
      background: #2575fc;
      border: none;
      border-radius: 8px;
      padding: 10px;
      font-size: 16px;
    }
    .btn-primary:hover {
      background: #1e63d5;
    }
    .extra-links {
      text-align: center;
      margin-top: 15px;
    }
    .extra-links a {
      color: #2575fc;
      text-decoration: none;
      font-weight: 500;
    }
    .extra-links a:hover {
      text-decoration: underline;
    }
    .alert-msg {
      text-align: center;
      margin-bottom: 15px;
      color: red;
      font-weight: 500;
    }
  </style>
</head>
<body>

  <div class="login-card">
    <!-- Display message from backend -->
    <c:if test="${not empty msg}">
      <div class="alert-msg">${msg}</div>
    </c:if>

    <h3>Login</h3>
    <form action="login" method="post">
      <div class="mb-3">
        <label class="form-label">Username</label>
        <input type="text" class="form-control" name="username" placeholder="Enter username" required>
      </div>
      <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" class="form-control" name="password" placeholder="Enter password" required>
      </div>
      <button type="submit" class="btn btn-primary w-100">Login</button>
    </form>

    <div class="extra-links">
      <p>Don’t have an account? <a href="/register-page">Register</a></p>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
