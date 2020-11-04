package com.thisisfine.service;

import com.thisisfine.entity.Cluster;
import com.thisisfine.repository.ClusterRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

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
}