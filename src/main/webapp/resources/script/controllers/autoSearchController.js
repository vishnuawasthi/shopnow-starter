app.controller('autoSearchController',function($scope,$http){
	$scope.countryName ;
	    $scope.complete=function(){
	     $scope.ajaxCall();
	     console.log($scope.availableTags);
	    $( "#tags" ).autocomplete({
	   //   source: $scope.availableTags
	    	source:$scope.texts
	    });
	    }; 
	    $scope.texts ={};
	    $scope.ajaxCall = function() {
			$http
					.get(
							'http://localhost:8090/shopnow/rest/autoSearch?countryName='+$scope.countryName)
					.then(function(res) {
						$scope.texts = res.data;
					});
		};
	    
	  });

