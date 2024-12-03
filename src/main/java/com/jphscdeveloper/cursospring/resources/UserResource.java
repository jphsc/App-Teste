package com.jphscdeveloper.cursospring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jphscdeveloper.cursospring.entities.User;
import com.jphscdeveloper.cursospring.services.UserService;

@RestController // quando for um webservice, se for uma aplicação completa seria um @Controller
@RequestMapping(value = "/users") // caminho no navegar que "cairá" nesse controller	
public class UserResource {
	
	@Autowired
	private UserService service;
	
//	@GetMapping
//	public ResponseEntity<User> findAll(){
//		User u = new User(1, "Fulano", "rafahsc@live.com", "48996481879", "abcd");
//		return ResponseEntity.ok().body(u);
//	}	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findByid(@PathVariable Integer id){
		User obj = service.findByid(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri(); // 201 esperar um uri
		return ResponseEntity.created(uri).body(obj); // forma adequada de retornar uma inclusão é um http 201, usando created
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); // retorna um 204 que é o status http esperado para deleções
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
