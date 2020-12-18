app.controller("usuarioController", function($scope, $http, $window){

	$scope.usuario = {};
	$scope.sucesso = 'Cadastro efetuado com sucesso!';
	$scope.falha = 'Falha ao realizar cadastro!';

 	$scope.cadastrar = function(){
 		
		$http.post("/cadastrarUsuario", $scope.usuario).then(function(response){
			$window.alert($scope.sucesso);
		}, function(response){
			$window.alert($scope.falha);
		});
		
	}
 			
});