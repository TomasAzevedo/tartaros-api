/**
 * 
 */
package br.com.tartaroshamburgueria.api.cliente.facade;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.cliente.repository.ClienteFilter;
import br.com.tartaroshamburgueria.api.cliente.repository.ClienteRepository;
import br.com.tartaroshamburgueria.api.model.Cliente;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class ClienteServiceFacadeImpl implements ClienteServiceFacade {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Page<Cliente> listar(ClienteFilter clienteFilter, Pageable pageable) {

		return clienteRepository.filtrar(clienteFilter, pageable);

	}

	@Override
	public Cliente salvar(Cliente cliente) {

		return clienteRepository.save(cliente);

	}

	@Override
	public Cliente buscar(Long codigo) {

		Cliente clienteBanco = obterCliente(codigo);

		return clienteBanco;

	}

	@Override
	public void excluir(Long id) {

		clienteRepository.delete(id);

	}

	@Override
	public Cliente atualizar(Long codigo, Cliente cliente) {

		Cliente clienteBanco = obterCliente(codigo);

		BeanUtils.copyProperties(cliente, clienteBanco, "id");

		return clienteRepository.save(clienteBanco);
	}

	private Cliente obterCliente(Long codigo) {

		Cliente clienteBanco = clienteRepository.findOne(codigo);

		if (null == clienteBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return clienteBanco;

	}

}
