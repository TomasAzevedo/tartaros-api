/**
 * 
 */
package br.com.tartaroshamburgueria.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author Tomás
 *
 */
@ConfigurationProperties("tartaros")
public class TartarosApiProperty {

	private final Seguranca seguranca = new Seguranca();

	private String origemPermitida = "http://localhost:4200";
	//private String origemPermitida = "http://tartaros-ui.s3-website-sa-east-1.amazonaws.com";
	

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOrigemPermitida() {
		return origemPermitida;
	}

	public void setOrigemPermitida(String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}

	public static class Seguranca {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}

}
