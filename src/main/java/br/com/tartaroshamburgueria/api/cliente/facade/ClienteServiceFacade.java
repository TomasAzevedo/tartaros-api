/**
 * 
 */
package br.com.tartaroshamburgueria.api.cliente.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tartaroshamburgueria.api.cliente.repository.ClienteFilter;
import br.com.tartaroshamburgueria.api.model.Cliente;

/**
 * 
 * Interface de serviço para o repositório.
 * 
 * @author Tomás Azevedo
 *
 */
public interface ClienteServiceFacade {
	
	
	public Page<Cliente> listar(ClienteFilter clienteFilter, Pageable pageable);
	
	public Cliente salvar(Cliente cliente);
	
	public Cliente buscar(Long codigo);
	
	public void excluir(Long codigo);
	
	public Cliente atualizar(Long codigo, Cliente cliente);
	

}
