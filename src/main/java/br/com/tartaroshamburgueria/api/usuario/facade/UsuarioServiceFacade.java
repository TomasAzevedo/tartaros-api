/**
 * 
 */
package br.com.tartaroshamburgueria.api.usuario.facade;

import java.util.Optional;

import br.com.tartaroshamburgueria.api.model.Usuario;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface UsuarioServiceFacade {
	
	
	public Optional<Usuario> obterUsuarioPorEmail(String email);
	

}
