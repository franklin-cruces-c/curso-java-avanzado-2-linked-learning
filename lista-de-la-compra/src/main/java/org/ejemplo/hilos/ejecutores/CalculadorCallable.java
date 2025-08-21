package org.ejemplo.hilos.ejecutores;

import java.util.concurrent.Callable;

public class CalculadorCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Realizando un cálculo muy complicado y lento...");
        Thread.sleep(1000);
        return 55;
    }
}
