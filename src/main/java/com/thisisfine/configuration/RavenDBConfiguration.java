package com.thisisfine.configuration;

import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.Getter;
import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;

@Getter
@Singleton
public class RavenDBConfiguration {

  private final IDocumentStore store;

  @Inject
  public RavenDBConfiguration(DatabaseConfiguration configuration) {
    this.store = new DocumentStore(configuration.getUrl(), configuration.getName());
    this.store.initialize();
  }
}
