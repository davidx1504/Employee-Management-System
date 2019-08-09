<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<jsp:include page="/common/meta.jsp" />
	<jsp:include page="/common/stylesheets.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/common/topNav.jsp"></jsp:include>
	
	<div class="grid-x" id="land">
		<div class="cell small-12">
			<div class="grid-x align-right">
				<div class="cell small-12 medium-6 large-4">
					<h1 style="color:#c50011;font-weight:bold;letter-spacing:8px;font-family:techno;font-size:4rem">TRONIX</h1>
					<a href="/employee" class="text-center">
						<div class="card hvr-grow animated fadeIn" style="margin-top:50px;background:transparent;border:none;outline:none">
							<div class="card-context text-center">
								<img src="/image/group.png">
							</div>
							<div class="card-context text-center">
								<h4>Manage Employee</h4>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>	

	<style>
		#land{
			padding:0px;
		}
		#land>.cell{
			background: url("/image/langbg.jpg");
			background-position: right;
			background-size: cover;
			height:100vh;
		}
		.grid-x{
			padding:30px;
		}
		.card img{
			height:75px;
			width:auto;
		}
	</style>
	<jsp:include page="/common/scripts.jsp"></jsp:include>
</body>
</html>