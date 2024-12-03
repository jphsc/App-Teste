package com.jphscdeveloper.cursospring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jphscdeveloper.cursospring.entities.Order;
import com.jphscdeveloper.cursospring.services.OrderService;

@RestController // quando for um webservice, se for uma aplicação completa seria um @Controller
@RequestMapping(value = "/orders") // caminho no navegar que "cairá" nesse controller	
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findByid(@PathVariable Integer id){
		Order obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
}
