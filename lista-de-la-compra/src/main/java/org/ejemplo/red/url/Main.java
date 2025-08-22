package org.ejemplo.red.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        BufferedReader in = null;
        URL javaInfoWikipedia = null;
        try {
            URL miUrl = new URL("https://es.wikipedia.org/");
            javaInfoWikipedia = new URL(miUrl, "wiki/java_(lenguaje_de_programación)");

            URL miUrl2 = new URL("https", "es.wikipedia.org", 80, "/wiki/java_(lenguaje_de_programación)");

            in = new BufferedReader(new InputStreamReader(javaInfoWikipedia.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            /*
             * Otra forma es con httpUrlConnection y openConnection
             */
            URL javaInfoWikipedia2 = new URL(miUrl, "wiki/java_(lenguaje_de_programación)");
            HttpURLConnection httpURLConnection = (HttpURLConnection) javaInfoWikipedia2.openConnection();
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            /*
             * se puede leer igual como se hizo con el objeto URL
             */

            /*
             * tambien podemos habilitar la conexion de escritura e intentar llenar
             * un formulario
             */

//            httpURLConnection.setDoOutput(true);
//            OutputStream outputStream = httpURLConnection.getOutputStream();
//            byte[] data = new byte[1024];
//            outputStream.write(data);
//            outputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
