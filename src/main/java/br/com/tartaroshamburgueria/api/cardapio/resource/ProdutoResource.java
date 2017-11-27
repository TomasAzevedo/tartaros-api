/**
 * 
 */
package br.com.tartaroshamburgueria.api.cardapio.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tartaroshamburgueria.api.cardapio.facade.ProdutoServiceFacade;
import br.com.tartaroshamburgueria.api.config.event.RecursoCriadoEvent;
import br.com.tartaroshamburgueria.api.model.Produto;

/**
 * @author Tomás
 *
 */
@RestController
@RequestMapping("/cardapio/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoServiceFacade produtoServiceFacade;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PRODUTOS') and #oauth2.hasScope('read')")
	public List<Produto> listar() {
		
		return produtoServiceFacade.listar();
		
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PRODUTOS') and #oauth2.hasScope('write')")
	public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		
		Produto produtoSalvo = produtoServiceFacade.salvar(produto);
		
		//Adiciona o Location do recurso criado
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PRODUTOS') and #oauth2.hasScope('read')")
	public  ResponseEntity<Produto> buscarPeloId(@PathVariable Long id) {
		
		Produto produto = produtoServiceFacade.buscar(id);
		
		return null==produto ? ResponseEntity.notFound().build() : ResponseEntity.ok(produto);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_PRODUTOS') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long id) {
		
		produtoServiceFacade.excluir(id);
		
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PRODUTOS') and #oauth2.hasScope('write')")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		
		Produto produtoAtualizado = produtoServiceFacade.atualizar(id, produto);
		
		return ResponseEntity.ok(produtoAtualizado);
		
	}
	

}
