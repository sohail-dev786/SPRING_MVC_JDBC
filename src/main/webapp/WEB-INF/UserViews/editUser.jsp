<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>EDIT USER</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>

							
		
	<main class="d-flex align-items-center mt-5" style="height: 70vh">
	
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4" >
				<div class="card">
				<form action="editUser" method="post">
						
		
					<div class="card-header text-center mt-5">
		
						<h3>EDIT USER</h3>
		
		
					</div>
					<div class="card-body">
		
		
						<div class="form-group">
							<label>ID</label>
							<input type="text" class="form-control" required name="uid" readonly="readonly" value="${getrecord.getId()}">
						</div>
						
						<div class="form-group">
							<label>Name</label>
							<input type="text" class="form-control" required name="uname" value="${getrecord.getName()}">
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" class="form-control" required name="uemail" value="${getrecord.getEmail()}">
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="text" class="form-control" required name="upass" value="${getrecord.getPassword()}"> 

						</div>
						<div class="form-group">
							<label>Address</label>
							<input type="text" class="form-control" required name="uaddress" value="${getrecord.getAddre()}">
						</div>		
		
					</div>
					
					<div class="card-footer">
					
					
					<input type="submit" class="btn btn-info" value="Save">
					
					
					</div>
	
	
		</form>
				</div>
		
		
		
			</div>
		
		
		</div>
	
	</div>
	
	</main>
	
			

</body>
</html>