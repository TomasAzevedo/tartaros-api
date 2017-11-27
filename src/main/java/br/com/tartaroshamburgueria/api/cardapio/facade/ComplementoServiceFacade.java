/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.facade;

import java.util.List;

import br.com.tartaroshamburgueria.api.model.Complemento;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface ComplementoServiceFacade {
	
	
	public List<Complemento> listar();
	
	public Complemento salvar(Complemento complemento);
	
	public Complemento buscar(Long id);
	
	public void excluir(Long id);
	
	public Complemento atualizar(Long id, Complemento complemento);
	

}
