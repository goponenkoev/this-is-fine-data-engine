package com.thisisfine.entity;

import lombok.Data;

@Data
public class User {
  private String name;

  public static User of(String name) {
    User user = new User();
    user.setName(name);

    return user;
  }
}
