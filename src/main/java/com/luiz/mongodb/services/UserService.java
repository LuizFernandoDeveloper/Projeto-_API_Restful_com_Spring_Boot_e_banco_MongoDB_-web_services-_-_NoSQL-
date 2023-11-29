package com.luiz.mongodb.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.luiz.mongodb.domain.User;
import com.luiz.mongodb.dto.UserDTO;
import com.luiz.mongodb.repository.UserRepository;
import com.luiz.mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty()) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return user.get();
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User update(User obj) {
		User newObjt = findById(obj.getId());
		updateData(newObjt , obj);
		return repository.save(newObjt);
	}
	
	private void updateData(User newObjt, User obj) {
		newObjt.setName(obj.getName());
		newObjt.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
