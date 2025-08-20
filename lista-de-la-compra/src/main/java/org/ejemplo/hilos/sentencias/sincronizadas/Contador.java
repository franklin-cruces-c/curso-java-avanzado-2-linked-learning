package org.ejemplo.hilos.sentencias.sincronizadas;

public class Contador {
    private int c = 0;

    public void incrementar() {
        c++;
        for(int i = 0; i< 20 ; i++){
            System.out.println("Iteracion " + (i + 1 ) + " desde hilo "+ Thread.currentThread().getName());
        }
    }

    public void decrementar() {
        c--;
    }

    public int obtenerValor() {
        return c;
    }
}

