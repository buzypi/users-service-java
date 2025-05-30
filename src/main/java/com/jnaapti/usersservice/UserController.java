package com.jnaapti.usersservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // Initialize with sample data
  @PostConstruct
  public void init() {
    if (userRepository.count() == 0) {
      userRepository.save(new User(1, "John"));
      userRepository.save(new User(2, "George"));
    }
  }

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/user/{userid}")
  public User getUserByUserid(@PathVariable int userid) {
    Optional<User> user = userRepository.findByUserid(userid);
    return user.orElse(null);
  }
}
