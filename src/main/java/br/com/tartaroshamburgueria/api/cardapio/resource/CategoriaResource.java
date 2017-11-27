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

import br.com.tartaroshamburgueria.api.cardapio.facade.CategoriaServiceFacade;
import br.com.tartaroshamburgueria.api.config.event.RecursoCriadoEvent;
import br.com.tartaroshamburgueria.api.model.Categoria;

/**
 * @author Tomás
 *
 */
@RestController
@RequestMapping("/cardapio/produtos/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaServiceFacade categoriaServiceFacade;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIAS') and #oauth2.hasScope('read')")
	public List<Categoria> listar() {
		
		return categoriaServiceFacade.listar();
		
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIAS') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		
		Categoria categoriaSalvo = categoriaServiceFacade.salvar(categoria);
		
		//Adiciona o Location do recurso criado
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalvo);
	}
	
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIAS') and #oauth2.hasScope('read')")
	public  ResponseEntity<Categoria> buscarPeloId(@PathVariable Long id) {
		
		Categoria categoria = categoriaServiceFacade.buscar(id);
		
		return null==categoria ? ResponseEntity.notFound().build() : ResponseEntity.ok(categoria);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CATEGORIAS') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long id) {
		
		categoriaServiceFacade.excluir(id);
		
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIAS') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
		
		Categoria categoriaAtualizado = categoriaServiceFacade.atualizar(id, categoria);
		
		return ResponseEntity.ok(categoriaAtualizado);
		
	}
	

}
