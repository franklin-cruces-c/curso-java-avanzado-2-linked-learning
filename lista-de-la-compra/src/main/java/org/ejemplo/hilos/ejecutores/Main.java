package org.ejemplo.hilos.ejecutores;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        /*
         * De forma manual
         */
        Thread hilo1 = new Thread(new SaludadorRunnable(), "Hilo Uno");
        hilo1.start();
        /*
         * Con ejecutor service y un único hilo atendiendo todas las tareas
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.submit(new SaludadorRunnable());
        }
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Esta es otra tarea");
            }
        });
        /*
         * shutdown no permite agregar mas tareas nuevas a ejecutar
         * y de que finalicen normalmente las tareas pendientes
         */
        executorService.shutdown();
        /*
         * Con ejecutor service multihilo atendiendo todas las tareas
         */
        ExecutorService executorServiceMulti = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50000; i++) {
            executorServiceMulti.submit(new SaludadorRunnable());
        }
        /*
         * shutdownNow finaliza inmediatamente todas las tareas
         * asi no hayan terminado de ejecutarse, y no permite agregar nuevas tareas
         */
        executorServiceMulti.shutdownNow();

        /*
         * Utilizando un Callable con ExecutorService
         */
        executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new CalculadorCallable());
        executorService.shutdown();
        System.out.println("Ha terminado la tarea?"+future.isDone());
        Integer resultado= 0;
        try {
            resultado=future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Ha terminado la tarea?"+future.isDone());
        System.out.println("El resultado es:"+resultado);

    }
}
