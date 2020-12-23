package com.thisisfine.repository;

import com.thisisfine.configuration.RavenDBConfiguration;
import com.thisisfine.entity.Answer;
import com.thisisfine.entity.Cluster;
import com.thisisfine.entity.Question;
import com.thisisfine.repository.aggregation.Clusters_ByFieldName;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.text.AbstractWriter;

import net.ravendb.client.documents.queries.facets.FacetResult;
import net.ravendb.client.documents.session.IDocumentSession;

@Singleton
public class ClusterRepository extends EntityRepository<Cluster> {

  @Inject
  public ClusterRepository(RavenDBConfiguration configuration) {
    super(configuration);
    // create index in DB
    new Clusters_ByFieldName().execute(store);
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

  /**
   * Add test fake cluster with question
   */
  public void addFakeQuestion() {

    Cluster cluster = new Cluster();
    cluster.setTitle("Initial");
    cluster.setLoc("RU");
    cluster.setHeader("Header");
    cluster.setLang("Java");
    Answer answer = new Answer();
    answer.setPlainText("Answer rly");
    Question question = new Question();
    question.setQuestion("Why?");
    question.setAnswer(answer);
    cluster.setData(Set.of(question));
    create(cluster);
  }

  /**
   * Gets an aggregation result by field name
   *
   * @param fieldName {@link String} name
   * @return {@link Map}
   */
  public Map<String, FacetResult> aggregationByField(String fieldName) {
    return aggregationByField(fieldName, Cluster.class, "Clusters/ByFieldName");
  }
}
