package com.moriarty.couchdb_ca;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class CouchDbConfig {

    @Bean
    public CouchDbConnector couchDbConnector() {
        HttpClient authenticatedHttpClient = null;
        try {
            authenticatedHttpClient = new StdHttpClient.Builder()
                    .url("http://localhost:5984")
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // create database handle for the couchdb instance being connected to
        CouchDbInstance dbInstance = new StdCouchDbInstance(authenticatedHttpClient);
        // if the second parameter is true, the database will be created if it doesn't exists
        // provides an interface for manipulating documents
        CouchDbConnector db = dbInstance.createConnector("test", false);
        return db;
    }
}
