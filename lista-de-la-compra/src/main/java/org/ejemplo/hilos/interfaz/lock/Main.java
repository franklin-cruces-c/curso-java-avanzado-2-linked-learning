package org.ejemplo.hilos.interfaz.lock;

public class Main {
    public static void main(String[] args) {

        Impresora impresora = new Impresora();
        Thread hilo1 = new Thread(new Impresion(impresora), "Hilo1");
        Thread hilo2 = new Thread(new Impresion(impresora), "Hilo2");
        Thread hilo3 = new Thread(new Impresion(impresora), "Hilo3");
        Thread hilo4 = new Thread(new Impresion(impresora), "Hilo4");
        Thread hilo5 = new Thread(new Impresion(impresora), "Hilo5");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}
