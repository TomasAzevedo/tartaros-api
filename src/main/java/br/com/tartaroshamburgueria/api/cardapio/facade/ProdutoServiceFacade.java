/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.facade;

import java.util.List;

import br.com.tartaroshamburgueria.api.model.Produto;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface ProdutoServiceFacade {
	
	
	public List<Produto> listar();
	
	public Produto salvar(Produto produto);
	
	public Produto buscar(Long id);
	
	public void excluir(Long id);
	
	public Produto atualizar(Long id, Produto produto);
	

}
