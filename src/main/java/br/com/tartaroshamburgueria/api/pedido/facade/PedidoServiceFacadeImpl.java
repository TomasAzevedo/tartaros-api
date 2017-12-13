/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.model.Pedido;
import br.com.tartaroshamburgueria.api.pedido.repository.PedidoRepository;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class PedidoServiceFacadeImpl implements PedidoServiceFacade {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public List<Pedido> listar() {

		return pedidoRepository.findAll();

	}

	
	@Override
	public Pedido salvar(Pedido pedido) {

		return pedidoRepository.save(pedido);

	}

	@Override
	public Pedido buscar(Long id) {

		Pedido pedidoBanco = obterPedido(id);

		return pedidoBanco;

	}

	@Override
	public void excluir(Long id) {

		pedidoRepository.delete(id);

	}

	@Override
	public Pedido atualizar(Long id, Pedido pedido) {

		Pedido pedidoBanco = obterPedido(id);

		BeanUtils.copyProperties(pedido, pedidoBanco, "id");

		return pedidoRepository.save(pedidoBanco);
	}

	private Pedido obterPedido(Long id) {

		Pedido pedidoBanco = pedidoRepository.findOne(id);

		if (null == pedidoBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return pedidoBanco;

	}

}
