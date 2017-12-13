/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.facade;

import java.util.List;

import br.com.tartaroshamburgueria.api.model.CanalVenda;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface CanalVendaServiceFacade {
	
	
	public List<CanalVenda> listar();
	
	public CanalVenda salvar(CanalVenda canalVenda);
	
	public CanalVenda buscar(Long id);
	
	public void excluir(Long id);
	
	public CanalVenda atualizar(Long id, CanalVenda canalVenda);
	

}
