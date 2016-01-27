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
		
		<form id="paymentGateWayForm" name="paymentGateWayForm"
			action="${paymentGateWayForm.actionURL }" method="POST">
			<input type="hidden" name="cmd" value="${paymentGateWayForm.cmd }" />
			<input type="hidden" name="business" value="${paymentGateWayForm.business }" /> 
				
				<input type="hidden"	name="password" value="${paymentGateWayForm.password }" /> 
				<input	type="hidden" name="custom" value="${paymentGateWayForm.custom }" />
			<input type="hidden" name="item_name" value="${paymentGateWayForm.itemName }" />
			 <input type="hidden"	name="amount" value="${paymentGateWayForm.amount}" /> 
			 <input type="hidden" name="rm" value="5" /> 
			 <input type="hidden" name="return" value="${paymentGateWayForm.returnURL }" />
		 <input type="hidden"  name="cancel_return" value="${paymentGateWayForm.cancelURL }" />
		  <input type="hidden" name="cert_id" value="API Singature" />
				<!-- <input type="Submit value=" Pay with Paypal"/> -->
		</form>
	</center>
</body>
<script type="text/javascript">
	function submitForm() {

		alert("Submitting form");
		document.getElementById("paymentGateWayForm").submit();
	}
</script>

</html>