import java.io.IOException;
import java.util.Scanner;

public class Interfaz {

    private ListaDeLaCompra listaDeLaCompra;

    public Interfaz(String archivo) {
        try {
            listaDeLaCompra = new ListaDeLaCompra(archivo);
            System.out.println("esto no se ejecutará cuando se genere la excepcion IOException");
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Ha ocurrido un problema con el archivo " + archivo);
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcionElegida;
        do {
            System.out.println("Para salir introduzca 0");
            System.out.println("Para ver un elemento introduzca la posición del elemento");
            opcionElegida = scanner.nextInt();
            if (opcionElegida != 0) {
                mostrarElemento(opcionElegida);
            }
        } while (opcionElegida != 0);

    }

    private void mostrarElemento(int indice) {
        System.out.println("El elemento número " + indice + " de la lista es " + listaDeLaCompra.obtenerElemento(indice));
    }
}
