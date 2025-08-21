package org.ejemplo.hilos.interfaz.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Impresora {

    private final Lock impresoraCalidadLock = new ReentrantLock();
    private final Lock impresoraRapidaLock = new ReentrantLock();

    public void imprimir(Object o) {

        if (impresoraCalidadLock.tryLock()) {
            try {
                double duracion = Math.random() * 10000;
                System.out.println(Thread.currentThread().getName() + ": Impresora de calidad imprimiendo un documento durante " + duracion / 1000 + "segundos");
                Thread.sleep((long) duracion);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + ": La impresión ha finalizado");
                impresoraCalidadLock.unlock();
            }
        }else {
            impresoraRapidaLock.lock();
            try {
                double duracion = Math.random() * 1000;
                System.out.println(Thread.currentThread().getName() + ": Impresora rapida imprimiendo un documento durante " + duracion / 1000 + "segundos");
                Thread.sleep((long) duracion);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + ": La impresión ha finalizado");
                impresoraRapidaLock.unlock();
            }
        }
    }
}
