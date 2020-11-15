package com.thisisfine.controllers;

import com.thisisfine.entity.Cluster;
import com.thisisfine.service.ClusterService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import net.ravendb.client.documents.queries.facets.FacetResult;

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

  @Get("/facets/{field}")
  public Map<String, FacetResult> getFacets(String field) {
    return clusterService.getFacets(field);
  }

}
