package com.luiz.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.mongodb.domain.User;
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
}
