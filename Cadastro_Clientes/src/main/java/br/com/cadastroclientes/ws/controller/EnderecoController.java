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

import br.com.cadastroclientes.ws.model.Endereco;
import br.com.cadastroclientes.ws.service.EnderecoService;

@RestController
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;

	@RequestMapping(method=RequestMethod.POST, value="/cadastrarEndereco", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco) {
		Endereco enderecoCadastrado = enderecoService.cadastrar(endereco);
		return new ResponseEntity<>(enderecoCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscarEnderecos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Endereco>> buscarEnderecos() {
		Collection<Endereco> todosEnderecos = enderecoService.buscarTodos();
		return new ResponseEntity<>(todosEnderecos, HttpStatus.OK);
	}

}
