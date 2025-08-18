package org.ejemplo.expresiones.lambda.ejemplos.de.uso;

public class EjemploRunnable {
    public static void main(String[] args) {
        //Código clásico
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("Corriendo...");
            }
        });

        thread1.start();

        //Código con expresión lambda
        Thread thread2 = new Thread(() -> System.out.println("Corriendo ..."));
        thread2.start();
    }
}
