var app = angular.module('CadastroClientes', ['ui.router']);

app.config(["$stateProvider","$urlRouterProvider", routes]);

function routes($stateProvider, $urlRouterProvider) {
	
	$urlRouterProvider.otherwise('/login');
	
    $stateProvider
      .state("login", {
        url: "/login",
        templateUrl: "view/login.html",
      })
      .state("usuario", {
        url: "/usuario",
        templateUrl: "view/usuario.html"
      })
	  .state("clientes", {
        url: "/clientes",
        templateUrl: "view/clientes.html"
      })
      .state("cadastra", {
        url: "/cadastra",
        templateUrl: "view/cadastrocliente.html"
      })
      .state("ve", {
        url: "/ve",
        templateUrl: "view/vecliente.html"
      });

  }