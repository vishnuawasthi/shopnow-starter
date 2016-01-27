<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>AngularJS - Views</title>
</head>
<body>
	<h2>AngularJS Sample Application</h2>
	<div ng-app="mainApp">
		<p>
			<a href="#addStudent">Add Student</a>
		</p>
		<p>
			<a href="#viewStudents">View Students</a>
		</p>
		<div ng-view></div>

		</hr>
		<!-- Form validation using service -->

		<div ng-controller="validationController">
			<form action="listProducts" method="GET" id="loginForm">

				<input type="text" name="username" ng-model="username"> <span
					id="usernameError"> {{usernameError}} </span> <br> <input
					type="password" name="password" ng-model="password"> <span
					id="passwordError">{{passwordError}} </span> <br> <input
					type="button" ng-click="validateForm()" value="Submit">
			</form>
		</div>
		<!--  ng-temple using script -->

		<script type="text/ng-template" id="addStudent.htm">
            <h2> Add Student </h2>
            {{message}}
<br>
{{common}}

         </script>

		<script type="text/ng-template" id="viewStudents.htm">
            <h2> View Students </h2>
            {{message}}
<br>
{{common}}
         </script>
	</div>
	<script>
		var mainApp = angular.module("mainApp", [ 'ngRoute' ]);

		mainApp.config([ '$routeProvider', function($routeProvider) {
			$routeProvider.

			when('/addStudent', {
				templateUrl : 'tempView.jsp',
				controller : 'AddStudentController'
			}).

			when('/viewStudents', {
				templateUrl : 'viewStudents.htm',
				controller : 'ViewStudentsController'
			}).

			otherwise({
				redirectTo : '/addStudent'
			});
		} ]);

		/*  controllers */

		mainApp
				.controller(
						'AddStudentController',
						function($scope) {
							$scope.message = "This page will be used to display add student form";
							$scope.common = "This is common message for all !!!!!!";
						});

		mainApp
				.controller(
						'ViewStudentsController',
						function($scope) {
							$scope.message = "This page will be used to display all the students";

						});

		mainApp.controller('validationController', function($scope) {
			$scope.username;
			$scope.password;
			$scope.usernameError;
			$scope.passwordError;

			$scope.validateForm = function() {
				$scope.result = true;
				if ($scope.result) {
					$scope.usernameError = "";
					$scope.passwordError = "";
				}
				if ($scope.username == null || $scope.username == "") {
					$scope.usernameError = "Please enter username";
					$scope.result = false;
				}
				;
				if ($scope.password == null || $scope.password == "") {
					$scope.passwordError = "Please enter password";
					$scope.result = false;
				}
				;
				if ($scope.result != false) {
					document.getElementById('loginForm').submit();
				}
				;
			};
		});
	</script>

</body>
</html>