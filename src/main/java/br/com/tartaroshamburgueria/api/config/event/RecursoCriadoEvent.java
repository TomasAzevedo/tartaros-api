/**
 * 
 */
package br.com.tartaroshamburgueria.api.config.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

/**
 * @author Tomás
 *
 */
public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = -4428976486822864172L;
	
	private HttpServletResponse httpServletResponse;
	private Long codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse httpServletResponse, Long codigo) {
		super(source);
		this.httpServletResponse = httpServletResponse;
		this.codigo = codigo;
	}

	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
