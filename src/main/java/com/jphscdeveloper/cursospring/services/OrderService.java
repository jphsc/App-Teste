package com.jphscdeveloper.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jphscdeveloper.cursospring.entities.Order;
import com.jphscdeveloper.cursospring.repositories.OrderRepository;

@Service // registra a classe como serviço no spring, para poder ser injetado com o @Autowired
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findByid(Integer id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
