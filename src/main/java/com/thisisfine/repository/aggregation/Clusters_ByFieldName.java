package com.thisisfine.repository.aggregation;

import net.ravendb.client.documents.indexes.AbstractIndexCreationTask;

public class Clusters_ByFieldName extends AbstractIndexCreationTask {

  public Clusters_ByFieldName() {
    map = "from cluster in docs.Clusters\n"
        + "select new\n"
        + "{\n"
        + "    cluster.lang,\n"
        + "    cluster.loc\n"
        + "}";
  }
}