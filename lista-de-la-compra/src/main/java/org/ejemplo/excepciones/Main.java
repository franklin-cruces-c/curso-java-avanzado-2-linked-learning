package org.ejemplo.excepciones;

public class Main {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz("src/main/resources/mi-lista.txt");
        interfaz.mostrarMenu();
    }
}
