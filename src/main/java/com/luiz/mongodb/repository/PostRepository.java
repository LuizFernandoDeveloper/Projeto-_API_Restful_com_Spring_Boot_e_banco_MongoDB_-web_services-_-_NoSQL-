package com.luiz.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.luiz.mongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	

}
