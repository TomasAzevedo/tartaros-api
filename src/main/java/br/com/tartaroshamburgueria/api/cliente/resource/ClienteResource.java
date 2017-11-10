/**
 * 
 */
package br.com.tartaroshamburgueria.api.cliente.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.tartaroshamburgueria.api.cliente.facade.ClienteServiceFacade;
import br.com.tartaroshamburgueria.api.cliente.repository.ClienteFilter;
import br.com.tartaroshamburgueria.api.config.event.RecursoCriadoEvent;
import br.com.tartaroshamburgueria.api.model.Cliente;

/**
 * @author Tomás
 *
 */
@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteServiceFacade clienteServiceFacade;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTES') and #oauth2.hasScope('read')")
	public Page<Cliente> listar(ClienteFilter clienteFilter, Pageable pageable) {
		
		return clienteServiceFacade.listar(clienteFilter, pageable);
		
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CLIENTES') and #oauth2.hasScope('write')")
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		
		Cliente clienteSalvo = clienteServiceFacade.salvar(cliente);
		
		//Adiciona o Location do recurso criado
		publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
	}
	
	
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CLIENTES') and #oauth2.hasScope('read')")
	public  ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long codigo) {
		
		Cliente cliente = clienteServiceFacade.buscar(codigo);
		
		return null==cliente ? ResponseEntity.notFound().build() : ResponseEntity.ok(cliente);
		
	}
	
	
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CLIENTES') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long codigo) {
		
		clienteServiceFacade.excluir(codigo);
		
	}
	
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CLIENTES') and #oauth2.hasScope('write')")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @Valid @RequestBody Cliente cliente) {
		
		Cliente clienteAtualizado = clienteServiceFacade.atualizar(codigo, cliente);
		
		return ResponseEntity.ok(clienteAtualizado);
		
	}
	

}
