package br.com.command.client.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal troco = BigDecimal.ZERO;

	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal discount = BigDecimal.ZERO;

	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal total = BigDecimal.ZERO;

	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal paid = BigDecimal.ZERO;

	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal subTotal = BigDecimal.ZERO;
	
	@OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
	private List<PaymentTitle> titles;

	/*
	 * Formula: Sem disconto TROCO = paid - total;
	 * 
	 * Com disconto
	 * 
	 * TROCO = paid - (total - discount);
	 * 
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getPaid() {
		return paid;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public List<PaymentTitle> getTitles() {
		return titles;
	}

	public void setTitles(List<PaymentTitle> titles) {
		this.titles = titles;
	}

}