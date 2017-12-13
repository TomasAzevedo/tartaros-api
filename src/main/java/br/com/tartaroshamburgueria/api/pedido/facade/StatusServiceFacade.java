/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.facade;

import java.util.List;

import br.com.tartaroshamburgueria.api.model.Status;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface StatusServiceFacade {
	
	
	public List<Status> listar();
	
	public Status salvar(Status status);
	
	public Status buscar(Long id);
	
	public void excluir(Long id);
	
	public Status atualizar(Long id, Status status);
	

}
