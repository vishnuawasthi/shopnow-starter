userApp = angular.module("userApp", []);
userApp
		.controller(
				"registrationController",
				function($scope, $http) {
					$scope.firstName;
					$scope.lastName;
					$scope.mobile;
					$scope.email;
					$scope.city;
					$scope.state;
					$scope.country;
					$scope.termsAndConditions;
					$scope.result;
					$scope.error =false;
					$scope.firstNameError;
					$scope.lastNameError;
					$scope.mobileError ;

					// $http.post(url, data, config)
					$scope.submitForm = function() {
						alert("submitForm - called  " + $scope.firstName);

						if ($scope.firstName ==  "" || $scope.firstName==null ) {
							error = true;
							$scope.firstNameError = "Please enter firstNme";
						} 
						
						if ($scope.lastName == "" || $scope.lastName ==null ) {
							error = true;
							$scope.lastNameError = "Please enter lastName";
						}
						
						if ($scope.mobile == "" || $scope.mobile ==null ) {
							error = true;
							$scope.mobileError = "Please enter mobile"
						}
						
						if (error != true) {
							alert("AJAX cALLED");
							var request = $http({
								method : "post",
								url : "http://localhost:8090/shopnow/doRegistration",
								// transformRequest: transformRequestAsFormPost,
								data : {
									firstName : $scope.firstName,
									lastName : $scope.lastName,
									mobile : $scope.mobile,
									email : $scope.email,
									city : $scope.city,
									state : $scope.state,
									country : $scope.country,
									termsAndConditions : $scope.termsAndConditions
								}
							});
							request
									.success(function(data, status, headers,
											config) {
										console
												.log("Submited successfully...!!!!")
										$scope.result = "Form submitted successfully, HTTP STATUS CODE : "
												+ status;
									});
							request
									.error(function(data, status, headers,
											config) {
										console
												.log("Ooopsss some error occured...!!!!")
										$scope.result = "Error occured while submitting the form,  HTTP STATUS CODE : "
												+ status;
									});
						}

					};
				});

function toPostService(baseURL, postfixURL) {

}

function loadReg() {
	alert("java script loaded successfully");
}