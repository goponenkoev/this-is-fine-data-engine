package com.thisisfine.service;

import com.thisisfine.entity.User;
import com.thisisfine.repository.UserRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserService {

  private final UserRepository userRepository;

  @Inject
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Gets a list of users that matches condition
   * @param name {@link String} user's name
   * @return {@link List}
   */

  public List<User> retrieveUsers(String name) {
    return userRepository.retrieveUsers(name);
  }

  /**
   * Save in DB User instance
   *
   * @param name {@link String} user's name
   */
  public void createUser(String name) {
    userRepository.create(User.of(name));
  }
}