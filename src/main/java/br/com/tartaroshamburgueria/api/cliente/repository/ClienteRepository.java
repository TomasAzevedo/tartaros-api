/**
 * 
 */
package br.com.tartaroshamburgueria.api.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tartaroshamburgueria.api.model.Cliente;

/**
 * 
 * Interface de acesso ao banco de dados.
 * 
 * @author Tomás Azevedo
 *
 */
public interface ClienteRepository  extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery {	
	

}
