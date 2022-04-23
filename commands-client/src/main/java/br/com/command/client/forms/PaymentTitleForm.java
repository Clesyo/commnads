package br.com.command.client.forms;

import java.math.BigDecimal;

import br.com.command.client.enums.PaymentMethod;
import br.com.command.client.models.PaymentTitle;

public class PaymentTitleForm {

	private String howPay;
	private BigDecimal amountPaid;
	
	public PaymentTitle toTitle() {
		var title = new PaymentTitle();
		
		title.setMethodPay(PaymentMethod.valueOf(howPay));
		title.setAmountPaid(amountPaid);
		return title;
	}

	public String getHowPay() {
		return howPay;
	}

	public void setHowPay(String howPay) {
		this.howPay = howPay;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	
}
