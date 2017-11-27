/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.facade;

import java.util.List;

import br.com.tartaroshamburgueria.api.model.TipoComplemento;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface TipoComplementoServiceFacade {
	
	
	public List<TipoComplemento> listar();
	
	public TipoComplemento salvar(TipoComplemento tipoComplemento);
	
	public TipoComplemento buscar(Long id);
	
	public void excluir(Long id);
	
	public TipoComplemento atualizar(Long id, TipoComplemento tipoComplemento);
	

}
