package br.com.command.client.enums;

public enum OrderStatus {

	CREATED("CRIADO"), PENDING_PAY("PENDENTE_PAGAMENTO"), PENDING("PENDENTE"), WAITING("AGUARDANDO"),
	PREPARING("PREPARANDO"), READY("PRONTO"), SEND_BOX("ENVIADO_CAIXA"),IN_TRANSIT("TRANSITO"), CALLED_OFF("CANCELADO"), PAID_OUT("PAGO");

	private String description;

	OrderStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
