package com.jphscdeveloper.cursospring.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jphscdeveloper.cursospring.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@EmbeddedId // >> necessário para ser a chave primária composta, sendo o item que relaciona as entidades
	private OrderItemPK id = new OrderItemPK(); // >>> Quando for uma chave composta é necessário instanciar a classe
	private Integer quantity;
	private Double price;
	
	public OrderItem() {}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		this.id.setOrder(order);
		this.id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return this.id.getOrder();
	}
	
	public void setOrder(Order order) {
		this.id.setOrder(order);;
	}
	
	public Product getProduct() {
		return this.id.getProduct();
	}
	
	public void setProduct(Product product) {
		this.id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSubTotal() {
		return this.price * this.quantity;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
}
