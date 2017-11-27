/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.facade;

import java.util.List;

import br.com.tartaroshamburgueria.api.model.Categoria;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface CategoriaServiceFacade {
	
	
	public List<Categoria> listar();
	
	public Categoria salvar(Categoria categoria);
	
	public Categoria buscar(Long id);
	
	public void excluir(Long id);
	
	public Categoria atualizar(Long id, Categoria categoria);
	

}
