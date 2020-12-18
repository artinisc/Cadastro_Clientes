app.controller("cadastroclienteController", function($scope, $http, $window){

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
 	$scope.ddd = "";
 	$scope.ddds = [];
 	$scope.telefone = "";
 	$scope.telefones = [];
 	$scope.nEnd = [];
 	$scope.cEnd = 0;
 	$scope.nTel = [];
 	$scope.cTel = 0;
 	$scope.sucesso = 'Cadastro efetuado com sucesso!';
	$scope.falha = 'Falha ao realizar cadastro!';
 	
 	$scope.addEndereco = function(){
 		
 		$scope.ruas.push($scope.rua);
 		$scope.numeros.push($scope.numero);
 		$scope.cidades.push($scope.cidade);
 		$scope.estados.push($scope.estado);
 		$scope.ceps.push($scope.cep);
 		
 		$scope.nEnd.push($scope.cEnd);
 		$scope.cEnd++;
 		
 	}
 	
 	$scope.addTelefone = function(){
 		
 		$scope.ddds.push($scope.ddd);
 		$scope.telefones.push($scope.telefone);
 		
 		$scope.nTel.push($scope.cTel);
 		$scope.cTel++;
 		
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
	 		
	 		$http.post("/cadastrarEndereco", $scope.endereco).then(function(response){

			}, function(response){

			});

		}
		
		for ($scope.contt = 0; $scope.contt < $scope.telefones.length; $scope.contt++) {
			
			$scope.tele = {};

			$scope.tele.cpf = $scope.cliente.cpf;
	 		$scope.tele.ddd = $scope.ddds[$scope.contt];
	 		$scope.tele.numero = $scope.telefones[$scope.contt];
	 		
	 		$http.post("/cadastrarTelefone", $scope.tele).then(function(response){

			}, function(response){

			});

		}
 		
		$http.post("/cadastrarCliente", $scope.cliente).then(function(response){
			$window.alert($scope.sucesso);
		}, function(response){
			$window.alert($scope.falha);
		});

	}
	

});