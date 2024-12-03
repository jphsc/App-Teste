package com.jphscdeveloper.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jphscdeveloper.cursospring.entities.Category;
import com.jphscdeveloper.cursospring.repositories.CategoryRepository;

@Service // registra a classe como serviço no spring, para poder ser injetado com o @Autowired
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findByid(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
