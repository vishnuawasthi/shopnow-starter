<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autocomplete -Example</title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css">



</head>
<body ng-app="app">
	<div ng-controller="autoSearchController">
		<div class="ui-widget">
			<label for="tags">Tags: </label> <input id="tags" ng-model="countryName" ng-keyup="complete()" />
		</div>
	</div>
	<hr>

	<!--  Factory sample controller  -->

	<div ng-controller="factoryTestController">
		<input type="text" ng-model="testName"> <button ng-click="getData()">Click me</button>
		<ul>
			<li>Data should come below...</li>
			<li ng-repeat=" name in names track by $index">{{name}}</li>
		</ul>
	</div>
	<hr>

	<div ng-controller="methematicsController">
		<input type="text" ng-model="firstValue">
		&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" ng-model="secondValue">
		<br /> 
		<div class="default-heading">
		
		<span ng-bind="result" > </span> <br />
</div>
		<button ng-click="addition()">Addition</button>
		&nbsp;&nbsp;&nbsp;
		<button ng-click="subtraction()">Subtraction</button>
		&nbsp;&nbsp;&nbsp;
		<button ng-click="multiply()">Multiply</button>
		&nbsp;&nbsp;&nbsp;
		<button ng-click="division()">Division</button>
		&nbsp;&nbsp;&nbsp;

	</div>

	<!-- Angular JS dependencies -->
	<script src="resources/script/angular.js"></script>
	<script src="resources/script/angular.min.js"></script>
	<script src="resources/script/angular-route.js"></script>
	<script src="resources/script/angular-route.min.js"></script>
	<script src="resources/script/angular-resource.js"></script>
	<script src="resources/script/angular-resource.min.js"></script>


	<script src="resources/script/app.js"></script>
	
	<!--  imported controllers -->
	
	<script src="resources/script/controllers/autoSearchController.js"></script>
	<script src="resources/script/controllers/factoryTestController.js"></script>
	<script src="resources/script/controllers/mathController.js"></script>

	
	

	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css" />
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

</body>
</html>