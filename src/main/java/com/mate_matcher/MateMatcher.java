package com.mate_matcher;
import com.google.common.base.Strings;
import com.mate_matcher.handlers.LoginHandler;
import com.mate_matcher.storage.MongoStorage;
import com.mate_matcher.storage.DtfUser;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class MateMatcher{

    public static void main(String[] args) throws Exception {
        if (Strings.isNullOrEmpty("")){
            System.out.println("Hello, Bazel!");
        }
        Server server = new Server(8000);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);
        MongoStorage connect = new MongoStorage();
        connect.connect();
        // Pretend to create a user here to check bazel dependencies;
        DtfUser user = new DtfUser();

        handler.addServlet(new ServletHolder(new LoginHandler()), "/login");

        server.start();
        server.join();
    }

}
