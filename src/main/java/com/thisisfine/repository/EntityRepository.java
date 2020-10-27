package com.thisisfine.repository;

import com.thisisfine.configuration.RavenDBConfiguration;
import java.util.List;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.session.IDocumentSession;

public abstract class EntityRepository<T> {

  protected final IDocumentStore store;

  public EntityRepository(RavenDBConfiguration configuration) {
    this.store = configuration.getStore();
  }

  /**
   * Save entity in DB
   *
   * @param entity input
   */
  public void create(T entity) {
    try (IDocumentSession session = store.openSession()) {
      session.store(entity);
      session.saveChanges();
    }
  }

  /**
   * Delete entity in DB
   *
   * @param entity input
   */
  public void delete(T entity) {
    try (IDocumentSession session = store.openSession()) {
      session.delete(entity);
      session.saveChanges();
    }
  }

  /**
   * Gets a list of entities that matches condition
   *
   * @param name fieldName
   * @param value of field
   * @param clazz type of class<T>
   *
   * @return {@link List} of entities
   */
  protected List<T> retrieveEntitiesByField(String name, Object value, Class<T> clazz) {
    try (IDocumentSession session = store.openSession()) {
      return session.query(clazz)
          .whereEquals(name, value)
          .toList();
    }
  }

  /**
   * Get entity by ID
   *
   * @param id input
   */
  abstract public T load(String id);
}
