/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.facade;

import java.util.List;

import br.com.tartaroshamburgueria.api.model.FormaPagamento;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface FormaPagamentoServiceFacade {
	
	
	public List<FormaPagamento> listar();
	
	public FormaPagamento salvar(FormaPagamento formaPagamento);
	
	public FormaPagamento buscar(Long id);
	
	public void excluir(Long id);
	
	public FormaPagamento atualizar(Long id, FormaPagamento formaPagamento);
	

}
