var app = angular.module('CadastroClientes', ['ui.router']);

app.config(["$stateProvider","$urlRouterProvider", routes]);

function routes($stateProvider, $urlRouterProvider) {
	
	$urlRouterProvider.otherwise('/login');
	
    $stateProvider
      .state("login", {
        url: "/login",
        templateUrl: "view/login.html",
      })
      .state("clientes", {
        url: "/clientes",
        templateUrl: "view/clientes.html"
      });

  }