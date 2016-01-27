app.controller('factoryTestController', function($scope, $http,MyFactory) {
	$scope.testName;
	$scope.names ={};
	
	$scope.show = function() {
		MyFactory.showAlert("Vishnu");
	};
	
	$scope.getData  = function (){
		 var responsePromiseCTRL  = MyFactory.getName($scope.testName);
		 responsePromiseCTRL.success(function(data,status,headers,config){
			// alert("Data in controller   : "+data);
			 $scope.names  =data;
		 });
	};
});