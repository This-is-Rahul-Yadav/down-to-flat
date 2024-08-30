package com.mate_matcher.storage;

import com.mongodb.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class MongoStorage {

        public void connect(){
            String uri = "mongodb+srv://agrawal99sanskar:<pass>@cluster0.9myihrx.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(uri))
                    .serverApi(serverApi)
                    .build();

            try (MongoClient mongoClient = MongoClients.create(settings)) {
                MongoDatabase database = mongoClient.getDatabase("admin");
                try {
                    // Send a ping to confirm a successful connection
                    Bson command = new BsonDocument("ping", new BsonInt64(1));
                    Document commandResult = database.runCommand(command);
                    System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
                } catch (MongoException me) {
                    System.err.println(me);
                }
            }


        }


}
