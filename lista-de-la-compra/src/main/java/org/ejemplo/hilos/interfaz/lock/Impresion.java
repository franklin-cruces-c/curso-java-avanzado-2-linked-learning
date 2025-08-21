package org.ejemplo.hilos.interfaz.lock;

public class Impresion implements Runnable {

    private Impresora impresora;

    public Impresion(Impresora impresora) {
        this.impresora = impresora;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ": Quiere imprimir un documento");
        impresora.imprimir(new Object());
    }
}
