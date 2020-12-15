package com.thisisfine.service;

import com.thisisfine.entity.Cluster;
import com.thisisfine.repository.ClusterRepository;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.ravendb.client.documents.queries.facets.FacetResult;

@Singleton
public class ClusterService {

  private final ClusterRepository clusterRepository;

  @Inject
  public ClusterService(ClusterRepository clusterRepository) {
    this.clusterRepository = clusterRepository;
  }

  /**
   * Save in DB Cluster instance
   *
   * @param cluster {@link Cluster}
   */
  public void createCluster(Cluster cluster) {
    clusterRepository.create(cluster);
  }

  /**
   * Gets a list of questions that matches condition
   * @param lang {@link String} cluster's lang
   * @return {@link List}
   */
  public List<Cluster> retrieveQuestions(String lang) {
    return clusterRepository.retrieveQuestionsByLang(lang);
  }

  /**
   * Add test fake cluster with question
   */
  public void addQuestion() {
    clusterRepository.addFakeQuestion();
  }

  /**
   * Gets an aggregation result by field name
   *
   * @param fieldName {@link String} name
   * @return {@link Map}
   */
  public Map<String, FacetResult> getFacets(String fieldName) {
    return clusterRepository.aggregationByField(fieldName);
  }
}