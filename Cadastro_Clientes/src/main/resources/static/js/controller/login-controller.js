app.controller("loginController", function($scope, $http){

 	$scope.nome = "jão";
 	$scope.login = [];
 	$scope.nUsuario = {};
 	
 	$scope.trazUsuarios = function(){
		$http({method:'GET', url: 'http://localhost:8080/buscarUsuarios'}).then(function(response){
			
			$scope.login = response.data;
			console.log(response.data);
			console.log(response.status);
			
		}, function(response){
		
			console.log(response.data);
			console.log(response.status);
			
		});
	}
	
	$scope.trazUsuarios();
	
	$scope.salvaUsuarios = function(){
		$http({method:'POST', url: 'http://localhost:8080/novoUsuario', data:$scope.nUsuario}).then(function(response){
			
			$scope.trazUsuarios();
			//$scope.login.push(response.data);
			
		}, function(response){
		
			console.log(response.data);
			console.log(response.status);
			
		});
	}
	
	



});