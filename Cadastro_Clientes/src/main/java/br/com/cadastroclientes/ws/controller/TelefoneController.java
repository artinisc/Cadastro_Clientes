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

import br.com.cadastroclientes.ws.model.Telefone;
import br.com.cadastroclientes.ws.service.TelefoneService;

@RestController
public class TelefoneController {
	
	@Autowired
	TelefoneService telefoneService;

	@RequestMapping(method=RequestMethod.POST, value="/cadastrarTelefone", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Telefone> telefoneEndereco(@RequestBody Telefone telefone) {
		Telefone telefoneCadastrado = telefoneService.cadastrar(telefone);
		return new ResponseEntity<>(telefoneCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscarTelefones", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Telefone>> buscarTelefones() {
		Collection<Telefone> todosTelefones = telefoneService.buscarTodos();
		return new ResponseEntity<>(todosTelefones, HttpStatus.OK);
	}

}
