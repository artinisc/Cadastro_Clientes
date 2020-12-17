package br.com.cadastroclientes.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastroclientes.ws.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value="Select u from Usuario u where u.login=:plogin")
	public Usuario buscarUsuario(@Param("plogin") String login);
	
}
