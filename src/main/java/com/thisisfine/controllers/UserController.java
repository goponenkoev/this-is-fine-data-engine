package com.thisisfine.controllers;

import com.thisisfine.entity.User;
import com.thisisfine.service.UserService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.List;
import javax.inject.Inject;

@Controller("/users")
public class UserController {

  private final UserService userService;

  @Inject
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Post("/{name}")
  public void saveUser(String name) {
    userService.createUser(name);
  }

  @Get("/{name}")
  public List<User> retrieveUsers(String name) {
    return userService.retrieveUsers(name);
  }

}
