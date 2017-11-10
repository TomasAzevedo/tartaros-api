/**
 * 
 */
package br.com.tartaroshamburgueria.api.cliente.repository;

/**
 * 
 * Classe que representa o filtro na busca de clientes.
 * 
 * @author Tomás Azevedo
 *
 */
public class ClienteFilter {
	
	private String nome;

	private String telefone;

	private String email;

	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
