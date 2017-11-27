/**
 * 
 */
package br.com.tartaroshamburgueria.api.config.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tartaroshamburgueria.api.config.event.RecursoCriadoEvent;

/**
 * 
 * Listener responsável por adicionar o Location do recurso criado.
 * 
 * @author Tomás Azevedo
 *
 */
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
		
		HttpServletResponse response = recursoCriadoEvent.getHttpServletResponse();
		Long codigo = recursoCriadoEvent.getCodigo();
		
		adicionarHeaderLocation(response, codigo);
		
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{codigo}")
				.buildAndExpand(codigo)
				.toUri();
		
		response.setHeader("Location", uri.toASCIIString());
	}
	
	

}
