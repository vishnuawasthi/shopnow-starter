
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<!-- Angular JS dependencies -->
<script src="resources/script/angular.js"></script>
<script src="resources/script/angular.min.js"></script>
<script src="resources/script/angular-route.js"></script>
<script src="resources/script/angular-route.min.js"></script>
<script src="resources/script/angular-resource.js"></script>
<script src="resources/script/angular-resource.min.js"></script>

<!--CUSTOM JS  -->

<script src="resources/script/common.js"></script>
<script src="resources/script/controllers/registrationController.js"></script>


<title>Registration</title>
</head>
<body ng-app="userApp" ng-controller="registrationController as regctrl"
	onload="loadReg()">
	<form name="registrationForm" novalidate>
		<table>
			<tr>
				<td colspan="3" id="resultArea">{{result}}</td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" id="firstName"
					ng-model="firstName" required="required"></td>
				<td>
					<div
						ng-show="registrationForm.$submitted || registrationForm.firstName.$touched ">
						<span ng-show="registrationForm.firstName.$error.required">Please
							enter first name</span>
					</div>
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" id="lastName"
					ng-model="lastName"></td>
				<td></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" id="mobile"
					ng-model="mobile"></td>
				<td></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id="email" ng-model="email">
				</td>
				<td></td>
			</tr>

			<tr>
				<td>City</td>
				<td><input type="text" name="city" id="city" ng-model="city">
				</td>
				<td></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state" id="state" ng-model="state">
				</td>
				<td></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><input type="text" name="country" id="country"
					ng-model="country"></td>
				<td></td>
			</tr>
			<tr>
				<td>Agree To Terms and Conditions</td>
				<td colspan="2"><input type="checkbox"
					name="termsAndConditions" ng-model="termsAndConditions"></td>

			</tr>

			<tr>

				<td colspan="3"><input type="button" ng-click="submitForm()"
					value="Submit"></td>

			</tr>

		</table>


	</form>



</body>
</html>