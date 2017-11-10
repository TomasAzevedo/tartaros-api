/**
 * 
 */
package br.com.tartaroshamburgueria.api.usuario.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.model.Usuario;
import br.com.tartaroshamburgueria.api.usuario.repository.UsuarioRepository;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class UsuarioServiceFacadeImpl implements UsuarioServiceFacade {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Optional<Usuario> obterUsuarioPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

}
