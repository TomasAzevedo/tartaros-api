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
import br.com.tartaroshamburgueria.api.model.FormaPagamento;
import br.com.tartaroshamburgueria.api.pedido.facade.FormaPagamentoServiceFacade;

/**
 * @author Tomás
 *
 */
@RestController
@RequestMapping("/pedidos/formas-pagamento")
public class FormaPagamentoResource {
	
	@Autowired
	private FormaPagamentoServiceFacade formaPagamentoServiceFacade;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_FORMA_PGTO') and #oauth2.hasScope('read')")
	public List<FormaPagamento> listar() {
		
		return formaPagamentoServiceFacade.listar();
		
	}
	
	
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_FORMA_PGTO') and #oauth2.hasScope('write')")
	public ResponseEntity<FormaPagamento> criar(@Valid @RequestBody FormaPagamento formaPagamento, HttpServletResponse response) {
		
		FormaPagamento formaPagamentoSalvo = formaPagamentoServiceFacade.salvar(formaPagamento);
		
		//Adiciona o Location do recurso criado
		publisher.publishEvent(new RecursoCriadoEvent(this, response, formaPagamentoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamentoSalvo);
	}
	
	
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_FORMA_PGTO') and #oauth2.hasScope('read')")
	public  ResponseEntity<FormaPagamento> buscarPeloId(@PathVariable Long id) {
		
		FormaPagamento formaPagamento = formaPagamentoServiceFacade.buscar(id);
		
		return null==formaPagamento ? ResponseEntity.notFound().build() : ResponseEntity.ok(formaPagamento);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_FORMA_PGTO') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long id) {
		
		formaPagamentoServiceFacade.excluir(id);
		
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_FORMA_PGTO') and #oauth2.hasScope('write')")
	public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long id, @Valid @RequestBody FormaPagamento formaPagamento) {
		
		FormaPagamento formaPagamentoAtualizado = formaPagamentoServiceFacade.atualizar(id, formaPagamento);
		
		return ResponseEntity.ok(formaPagamentoAtualizado);
		
	}
	

}
