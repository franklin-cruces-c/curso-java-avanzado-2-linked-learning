package org.ejemplo.hilos;

public class Main {
    public static void main(String[] args){

        /*
         * Creando hilos implementando Runnable
         *
         */
        Thread miHilo = new Thread(new SaludadorRunnable(), "Hilo Uno");
        miHilo.start();

        Thread miHilo1 = new Thread(new SaludadorRunnable(), "Hilo Dos");
        miHilo1.start();

        Thread miHilo2 = new Thread(new SaludadorRunnable(), "Hilo Tres");
        miHilo2.start();

        /*
         *
         * Creando hilos extendiendo de Thread
         *
         */
        SaludadorThread saludadorThread = new SaludadorThread();
        saludadorThread.start();
    }
}
