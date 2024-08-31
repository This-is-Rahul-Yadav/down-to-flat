package com.mate_matcher.storage;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import com.mate_matcher.storage.DtfUser;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.InputStream;

public class MongoStorage {
    public MongoClient mongoClient;
    public MongoClient connect(){
        Properties prop = new Properties();
        try (InputStream input = MongoStorage.class.getClassLoader().getResourceAsStream("com/config/config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }
            prop.load(input);
        }
        catch (Exception e){
            System.out.println(e);
        }


        String uri = prop.getProperty("database.url");

        ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();

        mongoClient = MongoClients.create(settings);


        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        try {
            // Send a ping to confirm a successful connection
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        } catch (MongoException me) {
            System.err.println(me);
        }
        return mongoClient;
    }

    public void closeConnection(MongoClient mongoClient) {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed.");
        }
    }

    public DftMovie findUserById(String id, String collectionName, MongoClient mongoClientv2) {
        MongoDatabase database = mongoClientv2.getDatabase("sample_mflix");
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document doc = collection.find(Filters.eq("_id", new ObjectId(id))).first();
        if (doc != null) {
            DftMovie user = new DftMovie();
            user.setId(doc.getObjectId("_id"));
            user.setName(doc.getString("name"));
            user.setEmail(doc.getString("email"));
            user.setMovieId(doc.getObjectId("movie_id"));
            user.setText(doc.getString("text"));
            user.setDate(doc.getDate("date"));
            return user;
        }
        else{
            System.out.println("Something else");
        }
        return null;
    }

}
