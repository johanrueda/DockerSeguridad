package edu.escuelaing.arem.app;

import edu.escuelaing.arem.app.login.Login;
import static spark.Spark.*;

/**
 * Clase que crea la conexion al servicio web
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
        return 5000;
    }
}