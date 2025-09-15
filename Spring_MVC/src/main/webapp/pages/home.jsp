<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home - TKA</title>

<!-- Bootstrap 5 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

main {
	flex: 1;
	padding: 40px;
	background: #f8f9fa;
}

.alert-msg {
	text-align: center;
	margin-bottom: 15px;
	color: red;
	font-weight: 500;
}

footer {
	background: #343a40;
	color: #fff;
	text-align: center;
	padding: 12px 0;
}
</style>
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<!-- Brand -->
			<a class="navbar-brand fw-bold" href="#">TKA</a>

			<!-- Right aligned items -->
			<div class="d-flex">
				<a href="logout" class="btn btn-outline-light btn-sm">Logout</a>
			</div>
		</div>
	</nav>

	<!-- Main content -->
	<main class="container">


		<c:if test="${not empty msg}">
			<div class="alert-msg">${msg}</div>
		</c:if>
		<div class="table-responsive">
			<table
				class="table table-striped table-bordered table-hover align-middle">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Username</th>
						<th>Password</th>
						<th>DOB</th>
						<th>Gender</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${users}" var="u">
						<tr>
							<td>${u.id}</td>
							<td>${u.firstName}</td>
							<td>${u.lastName}</td>
							<td>${u.username}</td>
							<td>${u.password}</td>
							<td>${u.dob}</td>
							<td>${u.gender}</td>
							<td><a class="btn btn-danger" href="/delete/${u.id}">Delete</a>
								<a class="btn btn-primary" href="/show?id=${u.id}">Show</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>


	</main>

	<!-- Footer -->
	<footer>
		<p>&copy; 2025 TKA. All rights reserved.</p>
	</footer>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
