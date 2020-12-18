app.controller("cadastroclienteController", function($scope, $http){

 	$scope.cliente = {};
 	$scope.rua = "";
 	$scope.ruas = [];
 	$scope.numero = "";
 	$scope.numeros = [];
 	$scope.cidade = "";
 	$scope.cidades = [];
 	$scope.estado = "";
 	$scope.estados = [];
 	$scope.cep = "";
 	$scope.ceps = [];
 	
 	$scope.retorno = {};
 	
 	$scope.addEndereco = function(){
 		
 		$scope.ruas.push($scope.rua);
 		$scope.numeros.push($scope.numero);
 		$scope.cidades.push($scope.cidade);
 		$scope.estados.push($scope.estado);
 		$scope.ceps.push($scope.cep);
 		
 	}
 	
 	$scope.add = function(){
 		
 		$scope.endereco.cpf = $scope.cliente.cpf;
 		$scope.endereco.rua = $scope.rua;
 		
 	}

	$scope.cadastrar = function(){
		
		for ($scope.cont = 0; $scope.cont < $scope.ruas.length; $scope.cont++) {
			
			$scope.endereco = {};

			$scope.endereco.cpf = $scope.cliente.cpf;
	 		$scope.endereco.rua = $scope.ruas[$scope.cont];
	 		$scope.endereco.numero = $scope.numeros[$scope.cont];
	 		$scope.endereco.cidade = $scope.cidades[$scope.cont];
	 		$scope.endereco.estado = $scope.estados[$scope.cont];
	 		$scope.endereco.cep = $scope.ceps[$scope.cont];
	 		
	 		console.log($scope.endereco.rua);
	 		
	 		$http.post("/cadastrarEndereco", $scope.endereco).then(function(response){
				console.log("sucesso ce"+response);
			}, function(response){
				console.log("falha ce"+response);
			});

		}
 		
		$http.post("/cadastrarCliente", $scope.cliente).then(function(response){
			console.log("sucesso cc"+response);
		}, function(response){
			console.log("falha cc"+response);
		});
		

		$http({method:'GET', url: 'http://localhost:8080/buscarEnderecos'}).then(function(response){
			
			console.log("sucesso bc"+response);
			$scope.retorno = response.data;
			
		}, function(response){
		
			console.log("falha bc"+response);
			
		});

		
		console.log($scope.retorno.rua);
		
		
	}
	

});