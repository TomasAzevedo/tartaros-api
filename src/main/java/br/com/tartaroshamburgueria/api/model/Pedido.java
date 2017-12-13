/**
 * 
 */
package br.com.tartaroshamburgueria.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "data")
	private LocalDateTime data;

	@NotNull
	private BigDecimal valorItens;

	private BigDecimal valorTaxaEntrega;

	@NotNull
	private BigDecimal valorTotal;

	private BigDecimal valorPago;

	private BigDecimal valorTroco;

	private String observacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_forma_pagamento")
	private FormaPagamento formaPagamento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_canal_venda")
	private CanalVenda canalVenda;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HistoricoPedido> listaHistoricoPedido;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> listaItem;
	
	public Pedido() {
		this.listaHistoricoPedido = new ArrayList<>();
		this.listaItem = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getValorItens() {
		return valorItens;
	}

	public void setValorItens(BigDecimal valorItens) {
		this.valorItens = valorItens;
	}

	public BigDecimal getValorTaxaEntrega() {
		return valorTaxaEntrega;
	}

	public void setValorTaxaEntrega(BigDecimal valorTaxaEntrega) {
		this.valorTaxaEntrega = valorTaxaEntrega;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getValorTroco() {
		return valorTroco;
	}

	public void setValorTroco(BigDecimal valorTroco) {
		this.valorTroco = valorTroco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public CanalVenda getCanalVenda() {
		return canalVenda;
	}

	public void setCanalVenda(CanalVenda canalVenda) {
		this.canalVenda = canalVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<HistoricoPedido> getListaHistoricoPedido() {
		return listaHistoricoPedido;
	}

	public void setListaHistoricoPedido(List<HistoricoPedido> listaHistoricoPedido) {
		listaHistoricoPedido.forEach(h -> h.setPedido(this));
		this.listaHistoricoPedido.clear();
		if (null != listaHistoricoPedido) {
			this.listaHistoricoPedido.addAll(listaHistoricoPedido);
		}
	}

	public List<Item> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<Item> listaItem) {
		listaItem.forEach(h -> h.setPedido(this));
		this.listaItem.clear();
		if (null != listaItem) {
			this.listaItem.addAll(listaItem);
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
