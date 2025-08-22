package org.ejemplo.red.datagramas;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        new ServidorEcho(5000).start();
        ClienteEcho clienteEcho = null;

        try {
            clienteEcho = new ClienteEcho(InetAddress.getLocalHost(), 5000);
            String respuesta = clienteEcho.enviarMensaje("Hola, ¿qué tal?");
            System.out.println("La respuesta del servidor ha sido:" + respuesta);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
