package org.example;

import com.mongodb.client.MongoDatabase;

public class Main {

    public static void main(String[] args) {
        MongoDatabase db = Connection.getDatabase("test");
        InsertDemo insertDemo = new InsertDemo(db);
//        insertDemo.insertOne();
        insertDemo.insertMany();
    }
}