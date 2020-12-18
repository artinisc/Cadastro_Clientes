package br.com.cadastroclientes.ws.controller;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastroclientes.ws.model.Cliente;
import br.com.cadastroclientes.ws.service.ClienteService;

@RestController
//@RequestMapping(value="/privado")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;

	@RequestMapping(method=RequestMethod.POST, value="/cadastrarCliente", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscarClientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarClientes() {
		Collection<Cliente> todosClientes = clienteService.buscarTodos();
		return new ResponseEntity<>(todosClientes, HttpStatus.OK);
	}
	
}
