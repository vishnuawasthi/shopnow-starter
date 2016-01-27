// Declaring angular module
app = angular.module("app",[]);

// Creating service and factory for common and  operation because these are reusable components.

app.factory("MyFactory", function($http) {
	var factory = {};
	factory.showAlert = function(name) {
		alert("Hello Mr/Mrs, " + name);
	};

	factory.getName = function(testName) {
	 var responsePromise =  $http.get('http://localhost:8090/shopnow/rest/autoSearch?countryName='+testName);
	 
	 responsePromise.success(function(data,status,headers,config) {
		 alert("success : "+ data);
	 });
	 responsePromise.error(function(data,status,headers,config){
		 alert("error   :  "+data);
		 });
	 
	 return responsePromise;
	};
	return factory;
});

app.service("MathService",function($http){
	var factory={};
	factory.multiply = function(firstNumber,secondNumber){
		return firstNumber*secondNumber;
	};
	
	factory.addition = function(firstNumber,secondNumber){
		return firstNumber + secondNumber;
	};
	
	
	factory.subtraction = function(firstNumber,secondNumber){
		return firstNumber - secondNumber;
	};
	
	factory.division = function(firstNumber,secondNumber){
		return firstNumber /   secondNumber;
	};
	
	return factory;
});


// Creating controllers 


	
