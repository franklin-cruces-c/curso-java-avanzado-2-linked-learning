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
        try {
            servidorSocket = new ServerSocket(numeroDePuerto);
            clienteSocket = servidorSocket.accept();
            out =  new PrintWriter(clienteSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            /*
             * Leer lo que el cliente envia y enviarlo de vuelta (hacer un eco)
             */
            String inputLine;
            while ((inputLine=in.readLine())!=null){
                out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
  public static void main(String[] args){
        ServidorEcho servidorEcho = new ServidorEcho(5000);
        servidorEcho.comenzar();
  }
}
