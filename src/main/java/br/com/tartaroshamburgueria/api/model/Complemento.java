/**
 * 
 */
package br.com.tartaroshamburgueria.api.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * Classe que representa um complemento de um produto.
 * 
 * @author Tomás
 *
 */
@Entity
@Table(name = "complemento")
public class Complemento {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String nome;
	
	private String descricao;
	
	private BigDecimal valor;
	
	@ManyToOne
    @JoinColumn(name = "id_tipo_complemento")	
	private TipoComplemento tipoComplemento;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoComplemento getTipoComplemento() {
		return tipoComplemento;
	}

	public void setTipoComplemento(TipoComplemento tipoComplemento) {
		this.tipoComplemento = tipoComplemento;
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
		Complemento other = (Complemento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
