/**
 * 
 */
package br.com.tartaroshamburgueria.api.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tartaroshamburgueria.api.model.Usuario;

/**
 * 
 * Interface de acesso ao banco de dados.
 * 
 * @author Tomás Azevedo
 *
 */
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
	
	
	public Optional<Usuario> findByEmail(String email);
	

}
