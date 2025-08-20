package org.ejemplo.hilos.metodos.sincronizados;

public class Main {
    public static void main(String[] args){
        Contador contador = new Contador();

        Thread miHilo =  new Thread(new Runnable() {
            @Override
            public void run() {
                contador.incrementar();
                System.out.println("El valor del contador es " + contador.obtenerValor());
            }
        }, "Hilo Uno");

        Thread miHiloDos =  new Thread(new Runnable() {
            @Override
            public void run() {
                //contador.incrementar();
                //contador.decrementar();
                System.out.println("El valor del contador es " + contador.obtenerValor());
            }
        }, "Hilo Dos");

        miHilo.start();
        miHiloDos.start();
    }


}
