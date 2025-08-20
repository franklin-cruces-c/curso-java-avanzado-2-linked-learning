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

        /*
         * Algunos métodos interesantes de la clase Thread
         */

        Thread miHiloUnoFor = new Thread(new SaludadorRunnableFor(2000), "Hilo Uno For");
        miHiloUnoFor.start();

        Thread miHiloDosFor = new Thread(new SaludadorRunnableFor(2000), "Hilo Dos For");
        miHiloDosFor.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        miHiloUnoFor.interrupt();
        /*
         * Si queremos liberar recursos una vez nuestros hilos hayan terminado su ejecución
         */
        while(miHiloUnoFor.isAlive() || miHiloDosFor.isAlive()){

        }
        // aca se liberan recursos

        // Otra forma más limpia es llamando al metodo join del hilo al que se está esperando a que termine
    }
}
