package com.jnaapti.usersservice;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByUserid(int userid);
}
