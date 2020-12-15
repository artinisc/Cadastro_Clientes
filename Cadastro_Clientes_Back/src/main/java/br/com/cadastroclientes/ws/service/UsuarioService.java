package br.com.cadastroclientes.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastroclientes.ws.model.Usuario;
import br.com.cadastroclientes.ws.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	public Collection<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}

}
