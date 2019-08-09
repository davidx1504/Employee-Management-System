<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<jsp:include page="/common/meta.jsp"/>
	<jsp:include page="/common/stylesheets.jsp"/>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%@ page import="com.ems.model.Employee" %>
	<%@ page import="com.ems.utility.JSPUtility" %>
	<jsp:include page="/common/topNav.jsp"></jsp:include>
	
	<div style="padding:30px;">
	
		<h3>${ message }</h3>
		
		<% if(request.getAttribute("type")!=null && request.getAttribute("empData")!=null ){ %>
		<div class="table-scroll">
			<table class="hover">
				<thead>
					<tr>
						<th>Sno</th>
						<th>Emp Id</th>
						<th>Name</th>
						<th>Dob</th>
						<th>Salary</th>
						<th>Options</th>
					</tr>
				</thead>
				<tbody id="data">
				 <% 
				 	JSPUtility utility = new JSPUtility();
				 	if(request.getAttribute("type")=="list" && request.getAttribute("empData")!=null){
				 		List<Object> data = (List<Object>) request.getAttribute("empData");
				 		out.print(utility.formatToTable((List<Object>)data));
				 	}
				 	if(request.getAttribute("type")=="object" && request.getAttribute("empData")!=null){
				 		Object data = (Object) request.getAttribute("empData");
				 		out.print(utility.formatToTable(data));
				 	}
				 %>
			 	</tbody>
			 </table>
		 </div>
		 <% } %>
	 </div>
	 <jsp:include page="/common/scripts.jsp"></jsp:include>
	 <script>
	 	$("#data tr").each(function(){
	 		let empId = $(this).find("td:nth-child(2)").text();
	 		$(this).attr("empId",empId);
	 		$(this).append("<td><span class='delEmp hyperlink button alert small'>Delete</span><span class='updEmp hyperlink button small primary'>Update</span></td>");
	 	})
	 	
	 	$(document).on("click",".delEmp", function(){
	 		let empId = $(this).parents('tr').attr("empId");
	 		if(confirm("Are you sure want to delete employee with ID " + empId))
	 			window.location.href="/employee/delete?empId="+empId;
	 	})
	 	
	 	$(document).on("click",".updEmp", function(){
	 		let empId = $(this).parents('tr').attr("empId");
 			window.location.href="/employee/search?empId="+empId;
	 	})
	 </script>
	 <style>
	 	td{
	 		padding:0.5rem 0rem 0rem 0rem!important;
	 	}
	 	.hyperlink:hover{
	 		cusror:pointer;
	 	}
	 	.hyperlink{
	 		transition:0.2s;
	 		margin-left:3px;
	 		margin-right:3px;
	 	}
	 </style>
</body>
</html>