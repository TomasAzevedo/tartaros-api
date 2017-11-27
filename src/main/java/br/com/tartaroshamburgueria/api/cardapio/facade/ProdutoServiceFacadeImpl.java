/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.facade;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.tartaroshamburgueria.api.cardapio.repository.ProdutoRepository;
import br.com.tartaroshamburgueria.api.model.Produto;

/**
 * @author Tomás Azevedo
 *
 */
@Service
public class ProdutoServiceFacadeImpl implements ProdutoServiceFacade {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ComplementoServiceFacade complementoServiceFacade;

	@Override
	public List<Produto> listar() {

		return produtoRepository.findAll();

	}

	@Override
	public Produto salvar(Produto produto) {
		
		produto.getListaComplementos().replaceAll(complemento ->
			complemento = complementoServiceFacade.buscar(complemento.getId())
		);

		return produtoRepository.save(produto);

	}

	@Override
	public Produto buscar(Long id) {

		Produto produtoBanco = obterProduto(id);

		return produtoBanco;

	}

	@Override
	public void excluir(Long id) {

		produtoRepository.delete(id);

	}

	@Override
	public Produto atualizar(Long id, Produto produto) {

		Produto produtoBanco = obterProduto(id);

		BeanUtils.copyProperties(produto, produtoBanco, "id");

		return produtoRepository.save(produtoBanco);
	}

	private Produto obterProduto(Long id) {

		Produto produtoBanco = produtoRepository.findOne(id);

		if (null == produtoBanco) {
			throw new EmptyResultDataAccessException(1);
		}

		return produtoBanco;

	}

}
