/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.facade;

import java.util.List;

import br.com.tartaroshamburgueria.api.model.Pedido;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface PedidoServiceFacade {
	
	public List<Pedido> listar();
	
	public Pedido salvar(Pedido pedido);
	
	public Pedido buscar(Long codigo);
	
	public void excluir(Long codigo);
	
	public Pedido atualizar(Long codigo, Pedido pedido);
	

}
