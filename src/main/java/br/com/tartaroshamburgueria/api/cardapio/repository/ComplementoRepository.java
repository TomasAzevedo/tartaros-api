/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tartaroshamburgueria.api.model.Complemento;

/**
 * 
 * Interface de acesso ao banco de dados.
 * 
 * @author Tomás Azevedo
 *
 */
public interface ComplementoRepository  extends JpaRepository<Complemento, Long> {	
	

}
