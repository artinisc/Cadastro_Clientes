app.controller("loginController", function($scope, $http){

	$scope.usuario = {};
 	
 	$scope.autenticar = function(){
 	
 		console.log("entro" + $scope.usuario.login);
 		
		$http.post("/autenticar", $scope.usuario).then(function(response){
			console.log("sucesso"+response);
		}, function(response){
			console.log("falha"+response);
		});
		
		
		
		
			
	}
 			
});