package com.jphscdeveloper.cursospring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jphscdeveloper.cursospring.entities.Category;
import com.jphscdeveloper.cursospring.services.CategoryService;

@RestController // quando for um webservice, se for uma aplicação completa seria um @Controller
@RequestMapping(value = "/categories") // caminho no navegar que "cairá" nesse controller	
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
//	@GetMapping
//	public ResponseEntity<User> findAll(){
//		User u = new User(1, "Fulano", "rafahsc@live.com", "48996481879", "abcd");
//		return ResponseEntity.ok().body(u);
//	}	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findByid(@PathVariable Integer id){
		Category obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
}
