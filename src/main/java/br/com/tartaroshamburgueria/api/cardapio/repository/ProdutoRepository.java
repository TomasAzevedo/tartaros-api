/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tartaroshamburgueria.api.model.Produto;

/**
 * 
 * Interface de acesso ao banco de dados.
 * 
 * @author Tomás Azevedo
 *
 */
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {	
	

}
