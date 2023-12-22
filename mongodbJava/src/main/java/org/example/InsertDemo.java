package org.example;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;

public class InsertDemo {
    private static MongoDatabase db = null;

    public InsertDemo(MongoDatabase db){
        InsertDemo.db = db;
    }

    // insertOne
    public void insertOne(){
        Document doc = new Document("name", "Red")
                .append("town", "Kanto")
                .append("badges", 8);
        db.getCollection("gymLeaders").insertOne(doc);
    }

    // insertMany
    public void insertMany(){
        Document doc1 = new Document("name", "Brock")
                .append("town", "Kanto")
                .append("badges", 8);
        Document doc2 = new Document("name", "Misty")
                .append("town", "Kanto")
                .append("badges", 8);
        Document doc3 = new Document("name", "Lt. Surge")
                .append("town", "Kanto")
                .append("badges", 8);
        db.getCollection("gymLeaders").insertMany(List.of(doc1, doc2, doc3));
    }

}
