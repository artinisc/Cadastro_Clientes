app.controller("loginController", function($scope, $http, $location, $state){

	$scope.usuario = {};
	$scope.token = "";
	$scope.erro = "";
 	
 	$scope.autenticar = function(){
 	

 		
		$http.post("/aut", $scope.usuario).then(function(response){
			$scope.token = response.data.token;
			$scope.erro = "";
			$state.go('clientes');
		}, function(response){
			$scope.erro = "Login ou senha invalidos!";
		});

	}
 			
});