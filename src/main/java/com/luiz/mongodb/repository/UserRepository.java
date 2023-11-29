package com.luiz.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.luiz.mongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
