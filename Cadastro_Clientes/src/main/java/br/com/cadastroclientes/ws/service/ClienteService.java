package br.com.cadastroclientes.ws.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastroclientes.ws.model.Cliente;
import br.com.cadastroclientes.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public Cliente cadastrar(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
}
