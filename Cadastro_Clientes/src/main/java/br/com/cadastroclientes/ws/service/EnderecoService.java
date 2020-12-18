package br.com.cadastroclientes.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastroclientes.ws.model.Endereco;
import br.com.cadastroclientes.ws.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Endereco cadastrar(Endereco endereco){
		return enderecoRepository.save(endereco);
	}
	
	public Collection<Endereco> buscarTodos(){
		return enderecoRepository.findAll();
	}
	

}
