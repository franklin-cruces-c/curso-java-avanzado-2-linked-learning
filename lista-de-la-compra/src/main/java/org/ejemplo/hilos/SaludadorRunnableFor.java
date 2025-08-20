package  org.ejemplo.hilos;
public class SaludadorRunnableFor implements Runnable{
    private int periodoDeSaludo;

    public SaludadorRunnableFor(int milisegundos){
        periodoDeSaludo = milisegundos;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            /*
             * Esto se utiliza en el caso no tener el catch del sleep
             */
//            if(Thread.interrupted()){
//                System.out.println("Hilo" +  Thread.currentThread().getName() + "Termina su ejecucion en Interrupted");
//            }
            System.out.println("Hola me llamo " + Thread.currentThread().getName());
            try {
                Thread.sleep(periodoDeSaludo);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Hilo" +  Thread.currentThread().getName() + "Termina su ejecucion en el catch");
                return;
            }
        }
    }
}
