package com.thisisfine.service;

import com.thisisfine.configuration.DocumentStoreHolder;
import com.thisisfine.entity.User;
import java.util.List;
import javax.inject.Singleton;
import net.ravendb.client.documents.session.IDocumentSession;

@Singleton
public class UserService {

  /**
   * Gets a list of users that matches condition
   * @param name {@link String} user's name
   * @return {@link List}
   */
  public List<User> retrieveUsers(String name) {
    try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
      return session.query(User.class)
          .whereEquals("name", name)
          .toList();
    }
  }

  /**
   * Save in DB User instance
   *
   * @param name {@link String} user's name
   */
  public void createUser(String name) {
    try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
      User user = new User();
      user.setName(name);
      session.store(user);

      session.saveChanges();
    }
  }
}