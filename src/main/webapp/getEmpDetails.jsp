<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="com.ems.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<jsp:include page="/common/meta.jsp" />
	<jsp:include page="/common/stylesheets.jsp" />
</head>
<body>
	<jsp:include page="/common/topNav.jsp"></jsp:include>
	<div class="grid-x grid-padding-x align-center" style="padding:30px;">
		<div class="small-12 medium-6 small-4">
			<h3 class="align-center"> ${title}</h3>
			<h4> ${message}</h4>
			<%
				String name = "";
				String dob = "";
				String salary = "";
				
				if(request.getAttribute("empData")!=null){
					Employee emp = (Employee) request.getAttribute("empData");
					name = emp.getEmpName();
					dob = emp.getDob().toString();
					salary = String.valueOf(emp.getSalary());
				}
			%>
			
			<form action="<%= request.getAttribute("action") %>" method="post">
				<%@ page import="java.util.HashMap" %>
				<% if(request.getAttribute("hiddenParam")!=null){
					HashMap<String, String> hiddenParam = ( HashMap<String, String> )request.getAttribute("hiddenParam");
					for(String key:hiddenParam.keySet()){
						out.print("<input name='"+key+"' value='"+hiddenParam.get(key)+"' style='display:none'>");
					}
				}%>
			
				<% if(request.getAttribute("details")=="all"){ %>
				<div class="grid-x grid-padding-x">
			       <div class="small-12 cell">
			         <label>Employee Name</label>
			         <input type="text" placeholder="Employee Name ..." name="empName" value="<%=name %>">
			       </div>
			    </div>
			    <div class="grid-x grid-padding-x">
			       <div class="small-12 cell">
			         <label>Employee Dob</label>
			         <input type="date" id="datepicker" placeholder="Employee date of birth ..." name="dob" value="<%=dob %>">
			       </div>
			    </div>
			    <div class="grid-x grid-padding-x">
			       <div class="small-12 cell">
			         <label>Salary</label>
			         <input type="text" placeholder="Employee Id ..." name="salary" value="<%=salary %>">
			       </div>
			    </div>
			    <%} %>
			    <% if(request.getAttribute("details")=="id"){ %>
			    <div class="grid-x grid-padding-x">
			       <div class="small-12 cell">
			         <label>Employee Id</label>
			         <input type="text" placeholder="Employee Id ..." name="empId">
			       </div>
			    </div>
			    <%} %>
			    <div class="grid-x grid-padding-x">
			       <div class="small-12 cell align-center">
			         <button type="submit" class="button uppercase"> ${title}</button>
			       </div>
			    </div>
		    </form>
		</div>
		<style>
			.hide{
				display:none;
			}
			.uppercase{
				text-transform:uppercase;
			}
		</style>
	</div>
	<jsp:include page="/common/scripts.jsp"></jsp:include>
</body>
</html>