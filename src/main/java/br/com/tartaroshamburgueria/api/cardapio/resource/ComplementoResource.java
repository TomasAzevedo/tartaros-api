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

import br.com.tartaroshamburgueria.api.cardapio.facade.ComplementoServiceFacade;
import br.com.tartaroshamburgueria.api.config.event.RecursoCriadoEvent;
import br.com.tartaroshamburgueria.api.model.Complemento;

/**
 * @author Tomás
 *
 */
@RestController
@RequestMapping("/cardapio/complementos")
public class ComplementoResource {
	
	@Autowired
	private ComplementoServiceFacade complementoServiceFacade;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COMPLEMENTOS') and #oauth2.hasScope('read')")
	public List<Complemento> listar() {
		
		return complementoServiceFacade.listar();
		
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_COMPLEMENTOS') and #oauth2.hasScope('write')")
	public ResponseEntity<Complemento> criar(@Valid @RequestBody Complemento complemento, HttpServletResponse response) {
		
		Complemento complementoSalvo = complementoServiceFacade.salvar(complemento);
		
		//Adiciona o Location do recurso criado
		publisher.publishEvent(new RecursoCriadoEvent(this, response, complementoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(complementoSalvo);
	}
	
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COMPLEMENTOS') and #oauth2.hasScope('read')")
	public  ResponseEntity<Complemento> buscarPeloId(@PathVariable Long id) {
		
		Complemento complemento = complementoServiceFacade.buscar(id);
		
		return null==complemento ? ResponseEntity.notFound().build() : ResponseEntity.ok(complemento);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_COMPLEMENTOS') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long id) {
		
		complementoServiceFacade.excluir(id);
		
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_COMPLEMENTOS') and #oauth2.hasScope('write')")
	public ResponseEntity<Complemento> atualizar(@PathVariable Long id, @Valid @RequestBody Complemento complemento) {
		
		Complemento complementoAtualizado = complementoServiceFacade.atualizar(id, complemento);
		
		return ResponseEntity.ok(complementoAtualizado);
		
	}
	

}
