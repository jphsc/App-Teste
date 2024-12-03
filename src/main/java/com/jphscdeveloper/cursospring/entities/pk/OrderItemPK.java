package com.jphscdeveloper.cursospring.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.jphscdeveloper.cursospring.entities.Order;
import com.jphscdeveloper.cursospring.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // informa que a classe é auxiliar, que serve para relacionar outras entidades e seus atributos são referencias as entidades ralacionadas
public class OrderItemPK implements Serializable { // classe/entidade de associação, não tem constructor e os atributos são apenas referênias para as demais entidades
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_orderitem_order_01"))
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_orderitem_product_01"))
	private Product product;

	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	

}
