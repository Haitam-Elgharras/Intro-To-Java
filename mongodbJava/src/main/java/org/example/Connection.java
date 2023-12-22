package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {

    private static MongoClient mongoClient = null;

    private Connection() {
        // private constructor to prevent instantiation
    }

    private static void connect() {
        // set the VM options in the main class to include:
        // -Dmongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/test?retryWrites=true&w=majority
        String connectionString = System.getProperty("mongodb.uri");
        mongoClient = MongoClients.create(connectionString);
    }

    private static MongoClient getClient() {
        if (mongoClient == null) {
            connect();
        }
        return mongoClient;
    }

    public static MongoDatabase getDatabase(String dbName) {
        return getClient().getDatabase(dbName);
    }
}