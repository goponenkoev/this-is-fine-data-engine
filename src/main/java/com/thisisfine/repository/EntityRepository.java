package com.thisisfine.repository;

import com.thisisfine.configuration.RavenDBConfiguration;
import java.util.List;
import java.util.Map;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.queries.Query;
import net.ravendb.client.documents.queries.facets.Facet;
import net.ravendb.client.documents.queries.facets.FacetResult;
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
   * Returns aggregation result by field name
   *
   * @param fieldName to aggregate by
   * @param clazz type of class<T>
   * @param index name of index
   * @return {@link Map} aggregation result
   */
  protected Map<String, FacetResult> aggregationByField(String fieldName, Class<T> clazz,
      String index) {
    try (IDocumentSession session = store.openSession()) {
      Facet facet = new Facet();
      facet.setFieldName(fieldName);
      return session.query(clazz, Query.index(index))
          .aggregateBy(facet)
          .execute();
    }
  }

  /**
   * Get entity by ID
   *
   * @param id input
   */
  abstract public T load(String id);
}
