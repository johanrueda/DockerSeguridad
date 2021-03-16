package edu.escuelaing.arem.app.login;

import edu.escuelaing.arem.app.HttpServer.URLReader;
import spark.Request;
import spark.Response;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase que maneja el control de acceso al servicio web
 *
 */
public class Login extends URLReader {

    /**
     * Metodo de acceso al servicio web
     * @param request
     * @param response
     * @return
     */
    public static boolean login (Request request, Response response){
        String userLog = "Johan";
        String passLog = "827ccb0eea8a706c4c34a16891f84e7b"; //12345
        boolean logged = false;
        if (request.queryParams("user") != null && request.queryParams("pssd") != null){
            try {
                String hash = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(request.queryParams("pssd").getBytes("UTF-8")));
                hash = hash.toLowerCase();
                if (request.queryParams("user").equals(userLog) && hash.equals(passLog)){
                    logged = true;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else {
            logged = false;
        }
        return logged;
    }

    /**
     * Metodo que da acceso al servicio web
     * @param request
     * @param response
     * @return
     */
    public static String isLogged (Request request, Response response){
        String ans = "";
        if (login(request, response)){
            ans += "Acceso Autorizado";
        }else {
            ans += "Error en el login, verifique su usuario o contraseña";
        }
        return ans;
    }
}