
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>

<!-- Angular JS dependencies -->
<script src="resources/script/angular.js"></script>
<script src="resources/script/angular.min.js"></script>
<script src="resources/script/angular-route.js"></script>
<script src="resources/script/angular-route.min.js"></script>
<script src="resources/script/angular-resource.js"></script>
<script src="resources/script/angular-resource.min.js"></script>


<!--CUSTOM JS  -->

<script src="resources/script/common.js"></script>

</head>
<body onload="load()" ng-app="productApp">
	<div ng-controller="productController">
		<div ng-include="'common.html'"></div>
		<ul>
			<li ng-repeat="record in records  ">
				<ul>
					<li>{{record.productId }}</li>
					<li>{{record.productName | orderBy:record.productName:false }}</li>
					<li>{{record.price | currency : "INR " : 2}}</li>
					<li ng-repeat="ref in record.links"><a href={{ref.href}}>
							See </a></li>
				</ul>
			</li>
		</ul>

		{{name}}
	</div>
	<hr>
	<div ng-controller="sample1Controller">
		<ul>
			<li ng-repeat=" x in data ">{{x.id }} &nbsp; {{ x.name}}</li>
		</ul>
	</div>
	<hr>
	<div ng-controller="searchAutoCompleteController">
		<input ng-keypress="ajaxCall()" ng-model="name">

		<ul>

			<li ng-repeat=" x in texts track by $index">{{x}}</li>

		</ul>

	</div>

	<script>
		app = angular.module("productApp", []);
		var productController = app.controller("productController", function(
				$scope, $http) {
			$scope.records = {};
			$http.get('http://localhost:8090/shopnow/rest/getProducts').then(
					function(res) {
						$scope.records = res.data;
					});
		});

		var sample1Controller = app.controller("sample1Controller", function(
				$scope) {
			$scope.data = [ {
				name : "Sample -1",
				id : "9876"
			}, {
				name : "Sample -2",
				id : "0000"
			}

			];
		});

		var searchAutoCompleteController = app
				.controller(
						"searchAutoCompleteController",
						function($scope, $http) {
							$scope.searchField;
							$scope.searchFieldValue;
							$scope.entityName;
							$scope.name;
							//$scope.values ={} ;

							//$scope.texts =["One","One"] ;
							$scope.texts = {};
							$scope.ajaxCall = function() {
								$http
										.get(
												'http://localhost:8090/shopnow/rest/autoSearch')
										.then(function(res) {
											$scope.texts = res.data;
										});
							};
						});
	</script>
	<div ng-include="WEB-INF/jps/header.jsp"></div>
</body>
</html>