package org.ejemplo.hilos.metodos.sincronizados;

public class Contador {
    private int c = 0;

    public void incrementar() {
        c++;
    }

    public void decrementar() {
        c--;
    }

    public int obtenerValor() {
        return c;
    }
}

