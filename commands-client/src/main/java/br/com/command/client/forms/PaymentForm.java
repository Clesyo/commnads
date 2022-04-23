package br.com.command.client.forms;

import java.math.BigDecimal;
import java.util.List;

import br.com.command.client.models.Payment;

public class PaymentForm {

	private String orderPublicId;
	private BigDecimal discount;
	private BigDecimal paid;
	private List<PaymentTitleForm> titles;

	public Payment toPayment() {
		var payment = new Payment();
		payment.setDiscount(discount);
		payment.setPaid(paid);
		return payment;
	}

	public String getOrderPublicId() {
		return orderPublicId;
	}

	public void setOrderPublicId(String orderPublicId) {
		this.orderPublicId = orderPublicId;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getPaid() {
		return paid;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

	public List<PaymentTitleForm> getTitles() {
		return titles;
	}

	public void setTitles(List<PaymentTitleForm> titles) {
		this.titles = titles;
	}
}
