
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
<body onload="load()">
<div ng-app="productApp" ng-controller="productController">
<span ng-bind="name" >



</span>
{{name}}
</div>


<script >

app = angular.module("productApp",[]);
var productController =  app.controller("productController",function($scope,$http){
	/* $scope.id ;
	$scope.name ="Vishnu";
	$scope.mobile;
	$scope.email ;
	$scope.address;
	$scope.city; */
	$scope.items = [
					$scope.id,
					$scope.name,
					$scope.mobile,
					$scope.email,
					$scope.address,
					$scope.city
	                ],
	
	$http.get("http://localhost:8090/shopnow/suppliers/1").success(
						function(response) {
							alert(response);
							$scope.items=response; 
							});
};
</script>

</body>
</html>