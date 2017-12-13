/**
 * 
 */
package br.com.tartaroshamburgueria.api.pedido.resource;

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

import br.com.tartaroshamburgueria.api.config.event.RecursoCriadoEvent;
import br.com.tartaroshamburgueria.api.model.Status;
import br.com.tartaroshamburgueria.api.pedido.facade.StatusServiceFacade;

/**
 * @author Tomás
 *
 */
@RestController
@RequestMapping("/pedidos/status")
public class StatusResource {
	
	@Autowired
	private StatusServiceFacade statusServiceFacade;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_STATUS') and #oauth2.hasScope('read')")
	public List<Status> listar() {
		
		return statusServiceFacade.listar();
		
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_STATUS') and #oauth2.hasScope('write')")
	public ResponseEntity<Status> criar(@Valid @RequestBody Status status, HttpServletResponse response) {
		
		Status statusSalvo = statusServiceFacade.salvar(status);
		
		//Adiciona o Location do recurso criado
		publisher.publishEvent(new RecursoCriadoEvent(this, response, statusSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(statusSalvo);
	}
	
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_STATUS') and #oauth2.hasScope('read')")
	public  ResponseEntity<Status> buscarPeloId(@PathVariable Long id) {
		
		Status status = statusServiceFacade.buscar(id);
		
		return null==status ? ResponseEntity.notFound().build() : ResponseEntity.ok(status);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_STATUS') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long id) {
		
		statusServiceFacade.excluir(id);
		
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_STATUS') and #oauth2.hasScope('write')")
	public ResponseEntity<Status> atualizar(@PathVariable Long id, @Valid @RequestBody Status status) {
		
		Status statusAtualizado = statusServiceFacade.atualizar(id, status);
		
		return ResponseEntity.ok(statusAtualizado);
		
	}
	

}
