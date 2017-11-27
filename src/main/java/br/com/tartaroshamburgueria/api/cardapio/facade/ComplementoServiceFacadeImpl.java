/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.cardapio.repository.ComplementoRepository;
import br.com.tartaroshamburgueria.api.model.Complemento;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class ComplementoServiceFacadeImpl implements ComplementoServiceFacade {

	@Autowired
	private ComplementoRepository complementoRepository;

	@Override
	public List<Complemento> listar() {

		return complementoRepository.findAll();

	}

	@Override
	public Complemento salvar(Complemento complemento) {

		return complementoRepository.save(complemento);

	}

	@Override
	public Complemento buscar(Long id) {

		Complemento complementoBanco = obterComplemento(id);

		return complementoBanco;

	}

	@Override
	public void excluir(Long id) {

		complementoRepository.delete(id);

	}

	@Override
	public Complemento atualizar(Long id, Complemento complemento) {

		Complemento complementoBanco = obterComplemento(id);

		BeanUtils.copyProperties(complemento, complementoBanco, "id");

		return complementoRepository.save(complementoBanco);
	}

	private Complemento obterComplemento(Long id) {

		Complemento complementoBanco = complementoRepository.findOne(id);

		if (null == complementoBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return complementoBanco;

	}

}
