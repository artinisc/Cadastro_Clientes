app.controller("clientesController", function($scope, $http, $state, $stateParams){

 	$scope.cliente = {};
 	$scope.clientes = {};
 	
 	$scope.trazClientes = function(){
 		
		$http({method:'GET', url: 'http://localhost:8080/buscarClientes'}).then(function(response){
			
			console.log("sucesso bc"+response);
			$scope.clientes = response.data;
			
		}, function(response){
		
			console.log("falha bc"+response);
			
		});
	
	}
	
	$scope.trazClientes();

});