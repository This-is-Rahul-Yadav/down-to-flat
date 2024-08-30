package com.mate_matcher;
import com.google.common.base.Strings;
import com.mate_matcher.handlers.LoginHandler;
import com.mate_matcher.storage.MongoStorage;
import com.mate_matcher.storage.DtfUser;
import com.mate_matcher.storage.DftMovie;
import com.mongodb.client.MongoClient;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class MateMatcher{

    private static MongoStorage connect;

    public static void main(String[] args) throws Exception {
        if (Strings.isNullOrEmpty("")){
            System.out.println("Hello, Bazel!");
        }
        Server server = new Server(8000);
        MongoClient mongoClient = null;
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);
        MongoStorage connect = new MongoStorage();
        try{
            mongoClient = connect.connect();
        }
        catch (Exception e){
            System.out.println(e);
        }

        String userId = "5a9427648b0beebeb6957eb4";
        String collectionName = "comments";
        DftMovie user = new DftMovie();
        if (mongoClient != null){
            user =  connect.findUserById(userId,collectionName,mongoClient);
        }
        System.out.println(user.getText());
//         Pretend to create a user here to check bazel dependencies;
        DtfUser user2 = new DtfUser();
        handler.addServlet(new ServletHolder(new LoginHandler()), "/login");

        MongoClient finalMongoClient = mongoClient;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            connect.closeConnection(finalMongoClient);
            System.out.println("connection closed");
        }));

        server.start();
        server.join();
    }

}
