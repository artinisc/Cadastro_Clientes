app.controller("usuarioController", function($scope, $http){

	$scope.usuario = {};
 	
 	$scope.cadastrar = function(){
 	
 		console.log("entro" + $scope.usuario.login);
 		
		$http.post("/cadastrarUsuario", $scope.usuario).then(function(response){
			console.log("sucesso"+response);
		}, function(response){
			console.log("falha"+response);
		});
		
	}
 			
});