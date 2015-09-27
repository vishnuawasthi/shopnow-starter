
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
		<ul>
			<li ng-repeat="record in records ">
				<ul>
					<li>{{record.productId}}</li>
					<li>{{record.productName}}</li>
					<li>{{record.price}}</li>
					<li ng-repeat="ref in record.links"><a href={{ref.href}}> See </a></li>
				</ul>
			</li>
		</ul>
		<hr>
		{{name}}
	</div>
	<script>

app = angular.module("productApp",[]);
var productController =  app.controller("productController",function($scope,$http){
	$scope.records={};			
	 $http.get('http://localhost:8090/shopnow/rest/getProducts')
     .then(function(res){
        $scope.records = res.data;                
      });
});
</script>

</body>
</html>