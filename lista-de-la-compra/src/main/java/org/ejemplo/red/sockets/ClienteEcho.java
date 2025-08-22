package org.ejemplo.red.sockets;

import java.io.*;
import java.net.*;

public class ClienteEcho {

    private String nombreDeHost;
    private int numeroDePuerto;
    private Socket clienteSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClienteEcho(String nombreDeHost, int numeroDePuerto) {
        this.nombreDeHost = nombreDeHost;
        this.numeroDePuerto = numeroDePuerto;
    }

    public void comenzarConexion() {

    }

    public String enviarMensaje(String mensaje) {

    }

    public void pararConexion() {
        try {
            in.close();
            out.close();
            clienteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}