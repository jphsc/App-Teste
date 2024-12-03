package com.jphscdeveloper.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jphscdeveloper.cursospring.entities.Product;
import com.jphscdeveloper.cursospring.repositories.ProductRepository;

@Service // registra a classe como serviço no spring, para poder ser injetado com o @Autowired
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findByid(Integer id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
