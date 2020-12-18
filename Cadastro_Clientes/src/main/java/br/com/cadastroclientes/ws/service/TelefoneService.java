package br.com.cadastroclientes.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastroclientes.ws.model.Telefone;
import br.com.cadastroclientes.ws.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	public Telefone cadastrar(Telefone telefone){
		return telefoneRepository.save(telefone);
	}
	
	public Collection<Telefone> buscarTodos(){
		return telefoneRepository.findAll();
	}

}
