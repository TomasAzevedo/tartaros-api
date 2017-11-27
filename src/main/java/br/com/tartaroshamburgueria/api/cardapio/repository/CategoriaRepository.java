/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tartaroshamburgueria.api.model.Categoria;

/**
 * 
 * Interface de acesso ao banco de dados.
 * 
 * @author Tomás Azevedo
 *
 */
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {	
	

}
