package org.example;

import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.TransactionBody;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.inc;

public class TransactionDemo {
    private static final MongoClient client = Connection.getClient();
    private static final ClientSession session = client.startSession();

    public static void transferMoneyDemo() {

        TransactionBody<String> txnBody = () -> {
            MongoDatabase db = Connection.getDatabase("test");

            Bson fromAccountFilter = eq("name", "checking");
            Bson withdrawUpdate = inc("balance", -100);

            Bson toAccountFilter = eq("name", "savings");
            Bson depositUpdate = inc("balance", 100);


            db.getCollection("accounts").updateOne(session, fromAccountFilter, withdrawUpdate);
            db.getCollection("accounts").updateOne(session, toAccountFilter, depositUpdate);

            System.out.println("Transfer successful");
            return "success";
        };

        try {
            session.withTransaction(txnBody);
        } catch (Exception e) {
            System.out.println("Transfer failed");
        }
        finally {
            session.close();
        }


    }


}
