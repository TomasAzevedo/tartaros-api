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
import br.com.tartaroshamburgueria.api.model.CanalVenda;
import br.com.tartaroshamburgueria.api.pedido.facade.CanalVendaServiceFacade;

/**
 * @author Tomás
 *
 */
@RestController
@RequestMapping("/pedidos/canais-venda")
public class CanalVendaResource {
	
	@Autowired
	private CanalVendaServiceFacade canalVendaServiceFacade;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CANAL_VENDA') and #oauth2.hasScope('read')")
	public List<CanalVenda> listar() {
		
		return canalVendaServiceFacade.listar();
		
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANAL_VENDA') and #oauth2.hasScope('write')")
	public ResponseEntity<CanalVenda> criar(@Valid @RequestBody CanalVenda canalVenda, HttpServletResponse response) {
		
		CanalVenda canalVendaSalvo = canalVendaServiceFacade.salvar(canalVenda);
		
		//Adiciona o Location do recurso criado
		publisher.publishEvent(new RecursoCriadoEvent(this, response, canalVendaSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(canalVendaSalvo);
	}
	
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CANAL_VENDA') and #oauth2.hasScope('read')")
	public  ResponseEntity<CanalVenda> buscarPeloId(@PathVariable Long id) {
		
		CanalVenda canalVenda = canalVendaServiceFacade.buscar(id);
		
		return null==canalVenda ? ResponseEntity.notFound().build() : ResponseEntity.ok(canalVenda);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CANAL_VENDA') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long id) {
		
		canalVendaServiceFacade.excluir(id);
		
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CANAL_VENDA') and #oauth2.hasScope('write')")
	public ResponseEntity<CanalVenda> atualizar(@PathVariable Long id, @Valid @RequestBody CanalVenda canalVenda) {
		
		CanalVenda canalVendaAtualizado = canalVendaServiceFacade.atualizar(id, canalVenda);
		
		return ResponseEntity.ok(canalVendaAtualizado);
		
	}
	

}
