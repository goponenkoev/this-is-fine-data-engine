package com.thisisfine.repository;

import com.thisisfine.configuration.RavenDBConfiguration;
import com.thisisfine.entity.Cluster;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.ravendb.client.documents.session.IDocumentSession;

@Singleton
public class ClusterRepository extends EntityRepository<Cluster> {

  @Inject
  public ClusterRepository(RavenDBConfiguration configuration) {
    super(configuration);
  }

  @Override
  public Cluster load(String id) {
    try (IDocumentSession session = store.openSession()) {
      return session.load(Cluster.class, id);
    }
  }

  /**
   * Gets a list of questions that matches condition
   *
   * @param lang {@link String} cluster's lang
   * @return {@link List}
   */
  public List<Cluster> retrieveQuestionsByLang(String lang) {
    return retrieveEntitiesByField("lang", lang, Cluster.class);
  }
}
