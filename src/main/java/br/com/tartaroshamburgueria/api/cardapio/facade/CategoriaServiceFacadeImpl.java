/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.cardapio.repository.CategoriaRepository;
import br.com.tartaroshamburgueria.api.model.Categoria;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class CategoriaServiceFacadeImpl implements CategoriaServiceFacade {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> listar() {

		return categoriaRepository.findAll();

	}

	@Override
	public Categoria salvar(Categoria categoria) {

		return categoriaRepository.save(categoria);

	}

	@Override
	public Categoria buscar(Long id) {

		Categoria categoriaBanco = obterCategoria(id);

		return categoriaBanco;

	}

	@Override
	public void excluir(Long id) {

		categoriaRepository.delete(id);

	}

	@Override
	public Categoria atualizar(Long id, Categoria categoria) {

		Categoria categoriaBanco = obterCategoria(id);

		BeanUtils.copyProperties(categoria, categoriaBanco, "id");

		return categoriaRepository.save(categoriaBanco);
	}

	private Categoria obterCategoria(Long id) {

		Categoria categoriaBanco = categoriaRepository.findOne(id);

		if (null == categoriaBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return categoriaBanco;

	}

}
