package org.ejemplo.hilos.problemas.sincronizacion;

public class Conferencia {
    public static void main(String[] args) {

        Object cuaderno = new Object();
        Object boligrafo = new Object();

        Thread ana = new Thread(() -> {
            synchronized (cuaderno) {
                System.out.println(Thread.currentThread().getName() + ": Tengo el cuaderno...");
                System.out.println(Thread.currentThread().getName() + ": Esperando al bolígrafo...");
                synchronized (boligrafo) {
                    System.out.println(Thread.currentThread().getName() + ": Tengo el cuaderno y el bolígrafo.");
                }
            }
        }, "Ana");

        Thread pablo = new Thread(() -> {
            synchronized (cuaderno) {
                System.out.println(Thread.currentThread().getName() + ": Tengo el cuaderno...");
                System.out.println(Thread.currentThread().getName() + ": Esperando al bolígrafo...");
                synchronized (boligrafo) {
                    System.out.println(Thread.currentThread().getName() + ": Tengo el cuaderno y el bolígrafo.");
                }
            }
        }, "Pablo");

        ana.start();
        pablo.start();
    }
}
