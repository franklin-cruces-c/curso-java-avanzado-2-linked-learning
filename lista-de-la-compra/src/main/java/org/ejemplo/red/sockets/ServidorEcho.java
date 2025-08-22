package org.ejemplo.red.sockets;

import java.net.*;
import java.io.*;

public class ServidorEcho {

    private int numeroDePuerto;
    private Socket clienteSocket;
    private ServerSocket servidorSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ServidorEcho(int numeroDePuerto) {
        this.numeroDePuerto = numeroDePuerto;
    }

    public void comenzar() {

    }

    public void parar() {
        try {
            in.close();
            out.close();
            servidorSocket.close();
            clienteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
