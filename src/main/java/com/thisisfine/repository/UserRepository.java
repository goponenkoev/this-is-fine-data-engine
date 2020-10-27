package com.thisisfine.repository;

import com.thisisfine.configuration.RavenDBConfiguration;
import com.thisisfine.entity.User;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.ravendb.client.documents.session.IDocumentSession;

@Singleton
public class UserRepository extends EntityRepository<User> {

  @Inject
  public UserRepository(RavenDBConfiguration configuration) {
    super(configuration);
  }

  @Override
  public User load(String id) {
    try (IDocumentSession session = store.openSession()) {
      return session.load(User.class, id);
    }
  }

  /**
   * Gets a list of users that matches condition
   *
   * @param name {@link String} user's name
   * @return {@link List}
   */
  public List<User> retrieveUsers(String name) {
    return retrieveEntitiesByField("name", name, User.class);
  }
}
