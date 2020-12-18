app.controller("loginController", function($scope, $http){

	$scope.usuario = {};
	$scope.token = "";
	$scope.autorizado = "clientes";
 	
 	$scope.autenticar = function(){
		$http.post("/aut", $scope.usuario).then(function(response){
			console.log("sucesso ddd"+response);
			$scope.token = response.data.token;
		}, function(response){
			console.log("falha ddd"+response);
		});
		
		console.log("ttt"+$scope.token);
		
		if(!token.equals(null)){
			$scope.autorizado = "clientes";
		}
	}
 			
});