/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tartaroshamburgueria.api.model.Pedido;

/**
 * 
 * Interface de acesso ao banco de dados.
 * 
 * @author Tomás Azevedo
 *
 */
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {	
	

}
