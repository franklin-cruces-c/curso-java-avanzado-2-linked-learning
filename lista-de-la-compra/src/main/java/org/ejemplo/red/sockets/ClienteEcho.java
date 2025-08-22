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
        try {
            clienteSocket = new Socket(nombreDeHost, numeroDePuerto);
            out = new PrintWriter(clienteSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public String enviarMensaje(String mensaje) {
        out.println(mensaje);
        String respuesta = null;
        try {
            respuesta = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
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