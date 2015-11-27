<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to PayPal</title>
</head>
<body onload="submitForm()">
	<center>
		<img alt="" src="resources/images/InternetSlowdown_Day.gif">
		<form action="${paymentGateWayForm.paymentGateWayURL}" method="GET"
			id="paymentGateWayForm"></form>
	</center>
</body>
<script type="text/javascript">
	function submitForm() {

		alert("Submitting form");
		document.getElementById("paymentGateWayForm").submit();
	}
</script>

</html>