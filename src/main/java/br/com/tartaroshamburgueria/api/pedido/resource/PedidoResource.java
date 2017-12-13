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
import br.com.tartaroshamburgueria.api.model.Pedido;
import br.com.tartaroshamburgueria.api.pedido.facade.PedidoServiceFacade;

/**
 * @author Tomás
 *
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoServiceFacade pedidoServiceFacade;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PEDIDOS') and #oauth2.hasScope('read')")
	public List<Pedido> listar() {
		
		return pedidoServiceFacade.listar();
		
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PEDIDOS') and #oauth2.hasScope('write')")
	public ResponseEntity<Pedido> criar(@Valid @RequestBody Pedido pedido, HttpServletResponse response) {
		
		Pedido pedidoSalvo = pedidoServiceFacade.salvar(pedido);
		
		//Adiciona o Location do recurso criado
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pedidoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
	}
	
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PEDIDOS') and #oauth2.hasScope('read')")
	public  ResponseEntity<Pedido> buscarPeloId(@PathVariable Long id) {
		
		Pedido pedido = pedidoServiceFacade.buscar(id);
		
		return null==pedido ? ResponseEntity.notFound().build() : ResponseEntity.ok(pedido);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_PEDIDOS') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long id) {
		
		pedidoServiceFacade.excluir(id);
		
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PEDIDOS') and #oauth2.hasScope('write')")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
		
		Pedido pedidoAtualizado = pedidoServiceFacade.atualizar(id, pedido);
		
		return ResponseEntity.ok(pedidoAtualizado);
		
	}
	

}
