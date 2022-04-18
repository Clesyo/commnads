package br.com.command.client.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.command.client.enums.PaymentMethod;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymento;


	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal troco = BigDecimal.ZERO;

	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal discount = BigDecimal.ZERO;

	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal total = BigDecimal.ZERO;
	
	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal paid = BigDecimal.ZERO;
	
/*	Formula:
 * Sem disconto
 * TROCO =  paid - total;
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

	public PaymentMethod getPaymento() {
		return paymento;
	}

	public void setPaymento(PaymentMethod paymento) {
		this.paymento = paymento;
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
}