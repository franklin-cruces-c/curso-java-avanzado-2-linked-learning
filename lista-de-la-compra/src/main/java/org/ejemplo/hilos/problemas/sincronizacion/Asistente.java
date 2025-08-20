package org.ejemplo.hilos.problemas.sincronizacion;

public class Asistente extends Thread {

    private Asistente compañero;
    private boolean necesitaEscribir;

    public Asistente(boolean necesitaEscribir){
        this.necesitaEscribir = necesitaEscribir;
    }
    public void asignarCompañero(Asistente compañero) {
        this.compañero = compañero;
    }

    @Override
    public void run() {
        if (necesitaEscribir) {
            while (compañero.necesitaEscribir) {
                System.out.println(getName() + ": Por favor, escribe tu primero");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(getName() + ": Escribiendo...");
            necesitaEscribir = false;
        }
    }
}
