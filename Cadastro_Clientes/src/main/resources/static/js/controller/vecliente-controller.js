app.controller("veclienteController", function($scope, $stateParams, $http){
	
	$scope.clientes = {};
	$scope.enderecos = {};
	$scope.telefones = {};
	$scope.idAtual = $stateParams.id;

	$scope.nomeAtual = "";
 	
 	$scope.trazClientes = function(){
 		
		$http({method:'GET', url: 'http://localhost:8080/buscarClientes'}).then(function(response){
			
			console.log("sucesso bc"+response);
			$scope.clientes = response.data;
			
		}, function(response){
		
			console.log("falha bc"+response);
			
		});
	
	}
	
	$scope.trazEnderecos = function(){
 		
		$http({method:'GET', url: 'http://localhost:8080/buscarEnderecos'}).then(function(response){
			
			console.log("sucesso bc"+response);
			$scope.enderecos = response.data;
			
		}, function(response){
		
			console.log("falha bc"+response);
			
		});
	
	}
	
	$scope.trazTelefones = function(){
 		
		$http({method:'GET', url: 'http://localhost:8080/buscarTelefones'}).then(function(response){
			
			console.log("sucesso bc"+response);
			$scope.telefones = response.data;
			
		}, function(response){
		
			console.log("falha bc"+response);
			
		});
	
	}
	
	$scope.trazClientes();
	$scope.trazEnderecos();
	$scope.trazTelefones();
	
});