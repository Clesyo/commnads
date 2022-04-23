package br.com.command.client.dtos;

import java.math.BigDecimal;
import java.util.List;

import br.com.command.client.models.Payment;

public class PaymentDto {

	private Long id;

	private String order;

	private BigDecimal troco;

	private BigDecimal discount;

	private BigDecimal total;

	private BigDecimal paid;

	private BigDecimal subTotal;

	private List<PaymentTitleDto> titles;

	public PaymentDto(Payment payment) {
		this.id = payment.getId();
		this.order = payment.getOrder().getPublicId();
		this.troco = payment.getTroco();
		this.discount = payment.getDiscount();
		this.total = payment.getTotal();
		this.paid = payment.getPaid();
		this.subTotal = payment.getSubTotal();
		this.titles = PaymentTitleDto.convertTo(payment.getTitles());
	}

	public static PaymentDto convertTo(Payment pay) {
		return new PaymentDto(pay);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
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

	public List<PaymentTitleDto> getTitles() {
		return titles;
	}

	public void setTitles(List<PaymentTitleDto> titles) {
		this.titles = titles;
	}

}
