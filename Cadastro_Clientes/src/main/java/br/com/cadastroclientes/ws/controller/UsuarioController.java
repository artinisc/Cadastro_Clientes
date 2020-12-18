package br.com.cadastroclientes.ws.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastroclientes.ws.model.Usuario;
import br.com.cadastroclientes.ws.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST, value="/aut", consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse aut(@RequestBody Usuario usuario) throws ServletException {
		Usuario retornoBusca = usuarioService.buscarUsuario(usuario.getLogin());
		
		if(!retornoBusca.getSenha().equals(usuario.getSenha()) || !retornoBusca.getLogin().equals(usuario.getLogin())) {
			throw new ServletException("Usuario ou senha invalidos!");
		}
		
		String token = Jwts.builder().setSubject(retornoBusca.getLogin()).signWith(SignatureAlgorithm.HS512, "cript").compact();
		return new LoginResponse(token);
	}

	@RequestMapping(method=RequestMethod.POST, value="/usuario", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> usuario(@RequestBody Usuario usuario) {
		Usuario retornoBusca = usuarioService.buscarUsuario(usuario.getLogin());
		return new ResponseEntity<>(retornoBusca, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cadastrarUsuario", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}
	
	private class LoginResponse{
		public String token;
		public LoginResponse(String token) {
			this.token=token;
		}
	}
	
	
}
