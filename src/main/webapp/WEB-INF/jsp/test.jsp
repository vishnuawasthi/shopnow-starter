<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<title>Validation-Example</title>
<style type="text/css">
.error {
	color: red;
}
;
</style>
</head>
<body>
	<form:form action="doValidation" method="POST"
		modelAttribute="registrationForm">
		<table>
			<tr>
				<td colspan="3">It is an validation form : <span> Label
				</span>
				</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /> </br>  <form:errors path="firstName" cssClass="error"></form:errors></td>
				<td></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /> </br><form:errors path="lastName" cssClass="error"></form:errors></td>
				<td>
				</td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><form:input path="mobile" /></br> <form:errors path="mobile" cssClass="error"></form:errors></td>
				<td></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></br> <form:errors path="email" cssClass="error"></form:errors></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>