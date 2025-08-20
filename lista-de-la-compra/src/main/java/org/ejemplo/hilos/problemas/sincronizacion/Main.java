package org.ejemplo.hilos.problemas.sincronizacion;

public class Main {
    public static void main(String[] args){
        Asistente asistente1 = new Asistente(true);
        Asistente asistente2 = new Asistente(true);
        asistente1.asignarCompañero(asistente2);
        asistente2.asignarCompañero(asistente1);

        asistente1.start();
        asistente2.start();
    }
}
