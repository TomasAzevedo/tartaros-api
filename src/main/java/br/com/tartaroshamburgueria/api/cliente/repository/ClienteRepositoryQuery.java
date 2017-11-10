/**
 * 
 */
package br.com.tartaroshamburgueria.api.cliente.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tartaroshamburgueria.api.model.Cliente;

/**
 * @author Tomás
 *
 */
public interface ClienteRepositoryQuery {
	
	public Page<Cliente> filtrar(ClienteFilter pessoaFilter, Pageable pageable);

}
