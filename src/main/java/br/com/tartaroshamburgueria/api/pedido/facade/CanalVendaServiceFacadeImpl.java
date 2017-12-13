/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.model.CanalVenda;
import br.com.tartaroshamburgueria.api.pedido.repository.CanalVendaRepository;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class CanalVendaServiceFacadeImpl implements CanalVendaServiceFacade {

	@Autowired
	private CanalVendaRepository canalVendaRepository;

	@Override
	public List<CanalVenda> listar() {

		return canalVendaRepository.findAll();

	}

	@Override
	public CanalVenda salvar(CanalVenda canalVenda) {

		return canalVendaRepository.save(canalVenda);

	}

	@Override
	public CanalVenda buscar(Long id) {

		CanalVenda canalVendaBanco = obterCanalVenda(id);

		return canalVendaBanco;

	}

	@Override
	public void excluir(Long id) {

		canalVendaRepository.delete(id);

	}

	@Override
	public CanalVenda atualizar(Long id, CanalVenda canalVenda) {

		CanalVenda canalVendaBanco = obterCanalVenda(id);

		BeanUtils.copyProperties(canalVenda, canalVendaBanco, "id");

		return canalVendaRepository.save(canalVendaBanco);
	}

	private CanalVenda obterCanalVenda(Long id) {

		CanalVenda canalVendaBanco = canalVendaRepository.findOne(id);

		if (null == canalVendaBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return canalVendaBanco;

	}

}
