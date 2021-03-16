package edu.escuelaing.arem.app.HttpServer;

import edu.escuelaing.arem.app.login.Login;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * clase que realiza la conexion SSL
 *
 */
public class URLReader {

    /**
     * Metodo que crea la configuracion
     */
    public static void configuration () {
        File trustStoreFile = new File("keyStores/myTrustStore");
        char[] trustStorePassword = "123456".toCharArray();
        KeyStore trustStore = null;
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try {
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        TrustManagerFactory tmf = null;
        try {
            tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            tmf.init(trustStore);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que lee la URL
     * @param sitetoread
     */
    public static String readURL(String sitetoread) {
        configuration();
        try {
            URL siteURL = new URL(sitetoread);
            URLConnection urlConnection = siteURL.openConnection();
            System.out.println("-------message-body------");
            InputStreamReader inputStream = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(inputStream);

            String inputLine = null;
            String url = "";
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                url += inputLine;
                return url;
            }
        } catch (IOException x) {
            x.printStackTrace();
        }
        return "";
    }
}