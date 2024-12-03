package com.jphscdeveloper.cursospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jphscdeveloper.cursospring.entities.User;
import com.jphscdeveloper.cursospring.repositories.UserRepository;
import com.jphscdeveloper.cursospring.resources.exceptions.DatabaseException;
import com.jphscdeveloper.cursospring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service // registra a classe como serviço no spring, para poder ser injetado com o @Autowired
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findByid(Integer id) {
		Optional<User> obj = repository.findById(id);
//		return obj.get();
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {

		try {
			repository.delete(findByid(id));
//			repository.deleteById(id);
			
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Integer id, User obj) {
		try {
			User user = repository.getReferenceById(id); // melhor que usar o findById, pois monitora um objeo que será manipulado, ao invés do findById que vai na base e utiliza de mais processamento
			updateData(user, obj);
			return repository.save(user);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(User user, User obj){
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPhone(obj.getPhone());
	}
}
