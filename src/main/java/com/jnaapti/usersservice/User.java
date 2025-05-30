package com.jnaapti.usersservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
  @Id
  private String id;
  private int userid;
  private String name;

  // Constructors
  public User() {
  }

  public User(int userid, String name) {
    this.userid = userid;
    this.name = name;
  }

  // Getters and Setters
  public String getId() {
    return id;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
