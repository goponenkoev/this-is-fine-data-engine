package com.thisisfine.configuration;

import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;

public class DocumentStoreHolder {

  private static class DocumentStoreContainer {

    // TODO: make it configurable
    public static final IDocumentStore store =
        new DocumentStore("http://localhost:8090", "thisisfine");

    static {
      store.initialize();
    }
  }

  public static IDocumentStore getStore() {
    return DocumentStoreContainer.store;
  }
}
