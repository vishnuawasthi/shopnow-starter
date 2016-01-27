app.controller('methematicsController', function($scope, $http,MathService) {
	$scope.firstValue;
	$scope.secondValue;
	$scope.result ;
	$scope.names ={};
	$scope.multiply = function(){
		$scope.result = MathService.multiply(	$scope.firstValue,	$scope.secondValue);
	};
	
	$scope.addition = function(){
		$scope.result = MathService.addition(	$scope.firstValue,	$scope.secondValue);
	};
	$scope.subtraction = function(){
		$scope.result = MathService.subtraction(	$scope.firstValue,	$scope.secondValue);
	};
	
	$scope.division = function(){
		$scope.result = MathService.division(	$scope.firstValue,	$scope.secondValue);
	};
});
