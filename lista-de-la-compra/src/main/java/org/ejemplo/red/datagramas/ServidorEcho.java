package org.ejemplo.red.datagramas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorEcho extends Thread {

    private DatagramSocket datagramSocket;
    private byte[] buffer = new byte[256];

    public ServidorEcho(int numeroDePuerto) {
        try {
            datagramSocket = new DatagramSocket(numeroDePuerto);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        DatagramPacket paquete = new DatagramPacket(buffer,buffer.length);
        DatagramPacket paqueteEcho;
        try {
            datagramSocket.receive(paquete);
            InetAddress direccion =  paquete.getAddress();
            int puerto = paquete.getPort();

            paqueteEcho = new DatagramPacket(buffer,buffer.length,direccion,puerto);
            datagramSocket.send(paqueteEcho);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
