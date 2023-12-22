package org.example;

import com.mongodb.client.MongoDatabase;

public class Main {

    public static void main(String[] args) {
        MongoDatabase db = Connection.getDatabase("test");
        CRUDDemo CRUDDemo = new CRUDDemo(db);
//        insertDemo.insertOne();
        CRUDDemo.insertMany();
    }
}