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
@Table(name = "payment_titles")
public class PaymentTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@Enumerated(EnumType.STRING)
	private PaymentMethod methodPay;

	@Column(columnDefinition = "decimal(19,2) default '0.00'")
	private BigDecimal amountPaid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public PaymentMethod getMethodPay() {
		return methodPay;
	}

	public void setMethodPay(PaymentMethod methodPay) {
		this.methodPay = methodPay;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

}
