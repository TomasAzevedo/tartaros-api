/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.model.FormaPagamento;
import br.com.tartaroshamburgueria.api.pedido.repository.FormaPagamentoRepository;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class FormaPagamentoServiceFacadeImpl implements FormaPagamentoServiceFacade {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@Override
	public List<FormaPagamento> listar() {

		return formaPagamentoRepository.findAll();

	}

	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {

		return formaPagamentoRepository.save(formaPagamento);

	}

	@Override
	public FormaPagamento buscar(Long id) {

		FormaPagamento formaPagamentoBanco = obterFormaPagamento(id);

		return formaPagamentoBanco;

	}

	@Override
	public void excluir(Long id) {

		formaPagamentoRepository.delete(id);

	}

	@Override
	public FormaPagamento atualizar(Long id, FormaPagamento formaPagamento) {

		FormaPagamento formaPagamentoBanco = obterFormaPagamento(id);

		BeanUtils.copyProperties(formaPagamento, formaPagamentoBanco, "id");

		return formaPagamentoRepository.save(formaPagamentoBanco);
	}

	private FormaPagamento obterFormaPagamento(Long id) {

		FormaPagamento formaPagamentoBanco = formaPagamentoRepository.findOne(id);

		if (null == formaPagamentoBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return formaPagamentoBanco;

	}

}
