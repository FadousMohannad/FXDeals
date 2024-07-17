package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private static final String CONNECTION_STRING = "mongodb+srv://mohannedfds:MEX9h88XeINUVvaZ@cluster0.nuvuyxn.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"; // Replace with your MongoDB URI
    private static final String DATABASE_NAME = "ProgressSoft";
    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
        }
        return database;
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
