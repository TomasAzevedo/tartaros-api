/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.model.Status;
import br.com.tartaroshamburgueria.api.pedido.repository.StatusRepository;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class StatusServiceFacadeImpl implements StatusServiceFacade {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Status> listar() {

		return statusRepository.findAll();

	}

	@Override
	public Status salvar(Status status) {

		return statusRepository.save(status);

	}

	@Override
	public Status buscar(Long id) {

		Status statusBanco = obterStatus(id);

		return statusBanco;

	}

	@Override
	public void excluir(Long id) {

		statusRepository.delete(id);

	}

	@Override
	public Status atualizar(Long id, Status status) {

		Status statusBanco = obterStatus(id);

		BeanUtils.copyProperties(status, statusBanco, "id");

		return statusRepository.save(statusBanco);
	}

	private Status obterStatus(Long id) {

		Status statusBanco = statusRepository.findOne(id);

		if (null == statusBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return statusBanco;

	}

}
