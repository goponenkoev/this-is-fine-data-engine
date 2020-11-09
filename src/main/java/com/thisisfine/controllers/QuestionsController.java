package com.thisisfine.controllers;

import com.thisisfine.entity.Cluster;
import com.thisisfine.service.ClusterService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.List;
import javax.inject.Inject;

@Controller("/questions")
public class QuestionsController {

  private final ClusterService clusterService;

  @Inject
  public QuestionsController(ClusterService clusterService) {
    this.clusterService = clusterService;
  }

  @Get("/{lang}")
  public List<Cluster> retrieveQuestionsByLang(String lang) {
    return clusterService.retrieveQuestions(lang);
  }

}
