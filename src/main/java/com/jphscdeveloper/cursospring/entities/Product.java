package com.jphscdeveloper.cursospring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;
	
	@Column(name = "product_name", length = 50)
	private String name;
	
	@Column(name = "product_description", length = 50)
	private String description;

	@Column(name = "product_price", scale = 3)
	private Double price;

	@Column(name = "product_imgUrl")
	private String imgUrl;

	@ManyToMany
	@JoinTable( // cria uma tabela que associa esta entidade com category
			name = "tb_product_category", //name é o nome da tabela
			joinColumns = @JoinColumn(name = "pproduct_id"), // informa que a fk que relaciona a nova entidade associativa a esta entidade
			foreignKey = @ForeignKey(name = "fk_productcategory_product_01"),
			inverseJoinColumns = @JoinColumn(name = "ccategory_id"), // informa que a fk que relaciona a nova entidade associativa a outra entidade
			inverseForeignKey = @ForeignKey(name = "fk_productcategory_category_01"))
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {}

	public Product(Integer id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	@JsonIgnore
	public Set<Order> getOrders(){
		Set<Order> orders = new HashSet<>();
		for(OrderItem o : this.items) {
			orders.add(o.getOrder());
		}
		return orders;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
}
