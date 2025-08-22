package org.ejemplo.red.sockets;

public class Main {
    public static void main(String[] args){
        ClienteEcho clienteEcho = new ClienteEcho("127.0.0.1",5000);
        clienteEcho.comenzarConexion();
        String respuesta = clienteEcho.enviarMensaje("Hola Lola");
        System.out.println("Respuesta: "+respuesta);
        respuesta = clienteEcho.enviarMensaje("Que tal?");
        System.out.println("Respuesta2: "+respuesta);

        respuesta = clienteEcho.enviarMensaje("Todo bien?");
        System.out.println("Respuesta3: "+respuesta);

    }
}
