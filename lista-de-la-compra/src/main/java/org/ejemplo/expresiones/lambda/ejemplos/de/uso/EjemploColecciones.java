package org.ejemplo.expresiones.lambda.ejemplos.de.uso;

import java.util.ArrayList;

public class EjemploColecciones {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("lunes");
        arrayList.add("martes");
        arrayList.add("miércoles");
        arrayList.add("jueves");
        arrayList.add("viernes");
        arrayList.add("sábado");
        arrayList.add("domingo");

        arrayList.forEach((s)-> System.out.println(s));

        // Otra forma, utilizando referencia al metodo
        System.out.println("**** Con referencia al metodo de una clase ****");
        arrayList.forEach(System.out::println);

    }
}
