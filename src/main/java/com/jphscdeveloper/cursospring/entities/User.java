package com.jphscdeveloper.cursospring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_phone")
	private String phone;
	
	@Column(name = "user_password")
	private String password;
	
	//necessário quando for uma mapeamento bidirecional, ou seja, quando um ordem pode obter o clinte e um cliente pode obter a ordem
	//pode ficar de qualquer lado, porém, deve ficar do lado que não queremos que retorne os dados associados, se aqui, na obtenção
	//do(s) user só vai listar user, ou seja, no json vai ignorar a lista de perdidos mas em order vai listar o user, se em order, 
	//vai ignorar o user do pedido, mas no user vai listar as orders dele
	@JsonIgnore	
	@OneToMany(mappedBy = "client") //mappedBy = "client" >> está mapeado na outra entidade pelo atributo client
	private List<Order> orders = new ArrayList<>(); // >>> É instanciado para garantir que a lista comece vazia, mas não seja nula
	
	public User() {}

	public User(Integer id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
