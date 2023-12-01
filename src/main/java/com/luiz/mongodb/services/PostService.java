package com.luiz.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.mongodb.domain.Post;
import com.luiz.mongodb.domain.User;
import com.luiz.mongodb.dto.UserDTO;
import com.luiz.mongodb.repository.PostRepository;
import com.luiz.mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		if(post.isEmpty()) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return post.get();
	}
	
	public  List<Post> findByTitle (String text){
		return repository.searchTitle(text);
	}
}
