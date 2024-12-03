package com.jphscdeveloper.cursospring.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1, "Aguardando pagamento"),
	PAID(2, "Pago"),
	SHIPPED(3, "Enviado"),
	DELIVERED(4, "Entregue"),
	CANCELED(5, "Cancelado");
	
	private int code;
	private String descricao;
	
	private OrderStatus(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public int getCode() {
		return this.code;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	public static OrderStatus valueOf(Integer code) {
		OrderStatus[] status = OrderStatus.values();
		
		for(OrderStatus order : status) {
			if(code.equals(order.getCode())) {
				return order;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
