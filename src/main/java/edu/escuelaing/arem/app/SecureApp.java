package edu.escuelaing.arem.app;

import edu.escuelaing.arem.app.login.Login;
import static spark.Spark.*;

/**
 * Class that makes a connection of web site
 *
 */
public class SecureApp {
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        secure("keyStores/ecikeystore.p12", "123456", null, null);
        get("/hello", (req, res) -> "Hello Web Services!!");
        post("/login", (req, res) -> Login.isLogged(req, res));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}