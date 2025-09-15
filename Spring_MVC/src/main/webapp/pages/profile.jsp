<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile</title>

<!-- Bootstrap 5 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

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
	max-width: 600px;
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

.alert-msg-red {
	text-align: center;
	margin-bottom: 15px;
	color: red;
	font-weight: 500;
}

.alert-msg-green {
	text-align: center;
	margin-bottom: 15px;
	color: green;
	font-weight: 500;
}
</style>
</head>
<body>



	<div class="login-card">
		<!-- Display message from backend -->
		<%
		Object obj = request.getAttribute("status");
		if (obj != null) {
			int status = (int) obj;
			if (status == 0) {
		%>

		<div class="alert-msg-red">Something went wrong while update
			profile</div>
		<%
		} else {
		%>
		<div class="alert-msg-green">User Updated Successfully !!</div>
		<%
		}

		}
		%>

		<h3>Update Profile</h3>
		<form action="update" method="post">
			<div class="row">
				<!-- Left column -->
				<div class="col-md-6">

					<div class="mb-3">
						<label class="form-label">ID</label> <input type="text"
							class="form-control" name="id"
							placeholder="Enter ID" required value="${user.id}">
					</div>
					<div class="mb-3">
						<label class="form-label">First Name</label> <input type="text"
							class="form-control" name="firstName"
							placeholder="Enter First Name" required value="${user.firstName}">
					</div>
					<div class="mb-3">
						<label class="form-label">Username</label> <input type="text"
							class="form-control" name="username" placeholder="Enter Username"
							required value="${user.username}">
					</div>
					<div class="mb-3">
						<label class="form-label">DOB</label> <input type="date"
							class="form-control" name="dob" required value="${user.dob}">
					</div>
				</div>

				<!-- Right column -->
				<div class="col-md-6">
					<div class="mb-3">
						<label class="form-label">Last Name</label> <input type="text"
							class="form-control" name="lastName"
							placeholder="Enter Last Name" required value="${user.lastName}">
					</div>
					<div class="mb-3">
						<label class="form-label">Password</label> <input type="password"
							class="form-control" name="password" placeholder="Enter Password"
							required value="${user.password}">
					</div>
					<div class="mb-3">
						<label class="form-label">Gender</label><br>

						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" name="gender"
								value="Male" required
								<c:if test="${user.gender == 'Male'}">checked</c:if>> <label
								class="form-check-label">Male</label>
						</div>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" name="gender"
								value="Female" required
								<c:if test="${user.gender == 'Female'}">checked</c:if>>
							<label class="form-check-label">Female</label>
						</div>

					</div>
				</div>
			</div>

			<!-- Button row -->
			<div class="row">
				<div class="col-12">
					<button type="submit" class="btn btn-primary w-100">Update</button>
				</div>
			</div>
		</form>


	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
