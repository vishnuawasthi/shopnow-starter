<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jpaSearchFilter</title>
</head>
<body>


	<table align="center" border="2">

		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>AddressLine1</th>
			<th>AddressLine2</th>
			<th>City</th>
			<th>State</th>
			<th>Country</th>
		</tr>
		<c:forEach items="${dtoList}" var="sampleDTO">
			<tr>
				<td>${sampleDTO.id }</td>
				<td>${sampleDTO.firstName }</td>
				<td>${sampleDTO.lastName }</td>
				<td>${sampleDTO.mobile }</td>
				<td>${sampleDTO.email }</td>
				<td>${sampleDTO.addressLine1 }</td>
				<td>${sampleDTO.addressLine2 }</td>
				<td>${sampleDTO.city }</td>
				<td>${sampleDTO.state}</td>
				<td>${sampleDTO.country}</td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>