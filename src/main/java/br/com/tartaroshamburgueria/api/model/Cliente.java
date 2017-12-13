/**
 * 
 */
package br.com.tartaroshamburgueria.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * Classe que representa um cliente da hamburgueria.
 * 
 * @author Tomás Azevedo
 *
 */
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String telefone;

	private String email;

	private String cpf;

	@Column(name="data_nascimento")
	private LocalDateTime dataNascimento;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos;

	public Cliente() {
		this.enderecos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
		if(null != this.dataNascimento) {
			this.dataNascimento = this.dataNascimento.withHour(12);
		}
	}

	public void setEnderecos(List<Endereco> enderecos) {
		enderecos.forEach(e -> e.setCliente(this));
		this.enderecos.clear();
		if (null != enderecos) {
			this.enderecos.addAll(enderecos);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
