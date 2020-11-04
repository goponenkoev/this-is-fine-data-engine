package com.thisisfine.controllers;

import com.thisisfine.entity.Cluster;
import com.thisisfine.service.ClusterService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import javax.inject.Inject;

@Controller("/clusters")
public class ClusterController {

  private final ClusterService clusterService;

  @Inject
  public ClusterController(ClusterService clusterService) {
    this.clusterService = clusterService;
  }

  @Post
  public void save(Cluster cluster) {
    clusterService.createCluster(cluster);
  }

}
