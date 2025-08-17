package org.ejemplo.excepciones;

import java.io.IOException;
import java.util.Scanner;

public class Interfaz {

    private ListaDeLaCompra listaDeLaCompra;

    public Interfaz(String archivo) {
        try {
            listaDeLaCompra = new ListaDeLaCompra(archivo);
            System.out.println("esto no se ejecutará cuando se genere la excepcion IOException");
            // las excepciones en catch multiple separado por el operador OR deben ir
            // del mas especifico al mas general, es decir las super clases al final
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
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
            System.out.println("Para añadir un elemento introduzca -1");
            opcionElegida = scanner.nextInt();

            switch (opcionElegida) {
                case 0:
                    break;
                case -1:
                    insertarElemento();
                    break;
                default:
                    mostrarElemento(opcionElegida);
            }
        } while (opcionElegida != 0);

    }

    private void mostrarElemento(int indice) {
        try {
            System.out.println("El elemento número " + indice + " de la lista es " + listaDeLaCompra.obtenerElemento(indice));
        } catch (PositionException e) {
            throw new RuntimeException(e);
        }
    }
    private void insertarElemento() {
        Scanner scanner = new Scanner(System.in);
        String elemento;
        System.out.println("¿Qué elemento desea añadir?");
        elemento = scanner.nextLine();
        try {
            listaDeLaCompra.insertarElemento(elemento);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un problema con el archivo mi-lista.txt");
        }
    }
}
