/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.cardapio.repository.TipoComplementoRepository;
import br.com.tartaroshamburgueria.api.model.TipoComplemento;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class TipoComplementoServiceFacadeImpl implements TipoComplementoServiceFacade {

	@Autowired
	private TipoComplementoRepository tipoComplementoRepository;

	@Override
	public List<TipoComplemento> listar() {

		return tipoComplementoRepository.findAll();

	}

	@Override
	public TipoComplemento salvar(TipoComplemento tipoComplemento) {

		return tipoComplementoRepository.save(tipoComplemento);

	}

	@Override
	public TipoComplemento buscar(Long id) {

		TipoComplemento tipoComplementoBanco = obterTipoComplemento(id);

		return tipoComplementoBanco;

	}

	@Override
	public void excluir(Long id) {

		tipoComplementoRepository.delete(id);

	}

	@Override
	public TipoComplemento atualizar(Long id, TipoComplemento tipoComplemento) {

		TipoComplemento tipoComplementoBanco = obterTipoComplemento(id);

		BeanUtils.copyProperties(tipoComplemento, tipoComplementoBanco, "id");

		return tipoComplementoRepository.save(tipoComplementoBanco);
	}

	private TipoComplemento obterTipoComplemento(Long id) {

		TipoComplemento tipoComplementoBanco = tipoComplementoRepository.findOne(id);

		if (null == tipoComplementoBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return tipoComplementoBanco;

	}

}
