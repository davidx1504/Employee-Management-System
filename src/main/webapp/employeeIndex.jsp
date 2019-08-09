<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<jsp:include page="/common/meta.jsp" />
	<jsp:include page="/common/stylesheets.jsp" />
</head>
<body>
	<jsp:include page="/common/topNav.jsp" />
	<div id="land" class="grid-x grid-padding-x">
		<div class="cell small-12 medium-4 large-6">
			<img src="/image/bg.jpg" />
		</div>
		<div class="cell small-12 medium-9 large-6" style="padding-top:30px">
			<h3>Employee Management System</h3>
			<br>
			<div class="grid-x grid-padding-x align-center">
				<div class="cell small-6 medium-4">
					<a href="/employee/newEmployee">
						<div class="card hvr-grow animated fadeIn" style="animation-delay:0s">
						  <div class="card-section text-center">
						    <img src="/image/add.png">
						  </div>
						  <div class="card-section">
						    <h4 class="text-center">Add Employee</h4>
						  </div>
						</div>
					</a>
				</div>
				<div class="cell small-6 medium-4">
					<a href="/employee/findEmployee">
						<div class="card hvr-grow animated fadeIn" style="animation-delay:0.1s">
						  <div class="card-section text-center">
						    <img src="/image/find.png">
						  </div>
						  <div class="card-section">
						    <h4 class="text-center">Find Employee</h4>
						  </div>
						</div>
					</a>
				</div>
				<div class="cell small-6 medium-4">
					<a href="/employee/all">
						<div class="card hvr-grow animated fadeIn" style="animation-delay:0.2s">
						  <div class="card-section text-center">
						    <img src="/image/all.png">
						  </div>
						  <div class="card-section">
						    <h4 class="text-center">All Employees</h4>
						  </div>
						</div>
					</a>
				</div>
				<div class="cell small-6 medium-4">
					<a href="/employee/updateEmployee">
						<div class="card hvr-grow animated fadeIn" style="animation-delay:0.3s">
						  <div class="card-section text-center">
						    <img src="/image/edit.png">
						  </div>
						  <div class="card-section">
						    <h4 class="text-center">Update Employee</h4>
						  </div>
						</div>
					</a>
				</div>
				<div class="cell small-6 medium-4">
					<a href="/employee/deleteEmployee">
						<div class="card hvr-grow animated fadeIn" style="animation-delay:0.4s">
						  <div class="card-section text-center">
						    <img src="/image/remove.png">
						  </div>
						  <div class="card-section">
						    <h4 class="text-center">Delete Employee</h4>
						  </div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<style>
		.card img{
			height:75px;
			width:auto;
		}
		.card .card-section{
			padding:10px;
		}
		body{
			background: #f7f7f7;		
		}
	</style>
	<jsp:include page="/common/scripts.jsp" />
</body>
</html>