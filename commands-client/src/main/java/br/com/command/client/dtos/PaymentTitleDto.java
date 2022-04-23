package br.com.command.client.dtos;

import java.math.BigDecimal;
import java.util.List;

import br.com.command.client.models.PaymentTitle;

public class PaymentTitleDto {

	private String howPaid;
	private BigDecimal amountPaid;

	public PaymentTitleDto(PaymentTitle title) {
		this.howPaid = title.getMethodPay().name();
		this.amountPaid = title.getAmountPaid();
	}

	public static List<PaymentTitleDto> convertTo(List<PaymentTitle> titles) {
		return titles.stream().map(PaymentTitleDto::new).toList();
	}
	public String getHowPaid() {
		return howPaid;
	}

	public void setHowPaid(String howPaid) {
		this.howPaid = howPaid;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amoutPaid) {
		this.amountPaid = amoutPaid;
	}

}
