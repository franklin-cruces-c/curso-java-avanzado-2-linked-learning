package org.ejemplo.hilos;

public class SaludadorThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hola me llamo " + getName());
    }
}
