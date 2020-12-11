package com.thisisfine.configuration;

import lombok.Getter;
import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.operations.GetStatisticsOperation;
import net.ravendb.client.exceptions.database.DatabaseDoesNotExistException;
import net.ravendb.client.serverwide.DatabaseRecord;
import net.ravendb.client.serverwide.operations.CreateDatabaseOperation;
import org.apache.commons.lang3.ObjectUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Getter
@Singleton
public class RavenDBConfiguration {

    private final IDocumentStore store;

    @Inject
    public RavenDBConfiguration(DatabaseConfiguration configuration) {
        this.store = new DocumentStore(configuration.getUrl(), configuration.getName());
        this.store.initialize();
        createDatabase(configuration.getName());
    }

    private void createDatabase(String database) {
        database = ObjectUtils.firstNonNull(database, store.getDatabase());

        try {
            store.maintenance().forDatabase(database).send(new GetStatisticsOperation());
        } catch (DatabaseDoesNotExistException e) {
            DatabaseRecord databaseRecord = new DatabaseRecord();
            databaseRecord.setDatabaseName(database);
            store.maintenance().server().send(new CreateDatabaseOperation(databaseRecord));
        }
    }
}
