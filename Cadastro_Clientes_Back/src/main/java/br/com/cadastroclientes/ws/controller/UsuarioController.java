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
import br.com.cadastroclientes.ws.model.Usuario;
import br.com.cadastroclientes.ws.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST, value="/novoUsuario", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> novoUsuario(@RequestBody Usuario usuario) {
		usuarioService.cadastrar(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscarUsuarios", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Usuario>> buscarUsuarios(@RequestBody Usuario usuario) {
		Collection<Usuario> todosUsuarios = usuarioService.buscarTodos();
		return new ResponseEntity<>(todosUsuarios, HttpStatus.OK);
	}

}
