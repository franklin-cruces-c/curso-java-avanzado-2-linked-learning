package org.ejemplo.hilos.sentencias.sincronizadas;

import org.ejemplo.hilos.sentencias.sincronizadas.Contador;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        Thread miHilo = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (contador) {
                    contador.incrementar();
                    System.out.println("El valor del contador es " + contador.obtenerValor());
                }
            }
        }, "Hilo Uno");

        Thread miHiloDos = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (contador) {
                    contador.incrementar();
                    System.out.println("El valor del contador es " + contador.obtenerValor());
                }
            }
        }, "Hilo Dos");

        miHilo.start();
        miHiloDos.start();
    }


}
