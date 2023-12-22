package org.example;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class CRUDDemo {
    private static MongoDatabase db = null;

    public CRUDDemo(MongoDatabase db){
        CRUDDemo.db = db;
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

    // find and find.first with filters
    public void find(){
        Document doc = db.getCollection("gymLeaders").find().first();//only returns the first document
        assert doc != null;
        System.out.println(doc.toJson());
    }

    // find with filters
    public void findWithFilters(){
        Document doc = db.getCollection("gymLeaders").find(and(eq("town", "Kanto"), gt("badges", 0))).first();
        assert doc != null;
        System.out.println(doc.toJson());
    }
    // return a cursor
    public void findWithFiltersCursor(){
          try (var cursor = db.getCollection("gymLeaders").find(and(eq("town", "Kanto"),
                                                                    gt("badges", 0))).iterator()
          ) {
              while (cursor.hasNext()) {
                  System.out.println(cursor.next().toJson());
              }
          }
    }

    // updateOne with $set and increment
    public void updateOne(){
        db.getCollection("gymLeaders").updateOne(eq("name", "Brock"), new Document("$set", new Document("badges", 10)));
        // or
        var query = eq("name", "Brock");
        var update = new Document("$inc", new Document("badges", 1));
        db.getCollection("gymLeaders").updateOne(query, update);
    }

    // updateMany with $set and increment
    public void updateMany(){
        db.getCollection("gymLeaders").updateMany(eq("town", "Kanto"), new Document("$set", new Document("badges", 10)));
        // or
        var query = eq("town", "Kanto");
        var update = new Document("$inc", new Document("badges", 1));
        db.getCollection("gymLeaders").updateMany(query, update);
    }

}
