package org.ejemplo.expresiones.lambda.referencias.metodos;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args){
        // Esta es la forma sin hacer referencia a los metodos
        //BinaryOperator<Integer> suma = (a,b) -> a + b;
        // Esta es la forma haciendo referencia a un metodo ya creado en una clase
        // en este caso un método estatico
        BinaryOperator<Integer> suma = Calculadora::sumar;
        System.out.println("El resultado de sumar 30 + 18 es :" + suma.apply(30,18));

        // Acá hacemos referencia a un método no estático de la clase String "toUpperCase"
        String miString = "Hola me llamo María";
        // Utilizamos la interfaz funcional Supplier que no recibe parametros y devuelve
        // un valor
        Supplier<String> stringMayusculas = miString::toUpperCase;
        System.out.println("miString en mayusculas es:"+stringMayusculas.get());

        // Ahora vamos a hacer referencia a constructores

        // Interfaz UnaryOperator para construir Strings con la clase String
        UnaryOperator<String> constructorDeStrings = String::new;
        String unString = constructorDeStrings.apply("Un String");
        String otroString = constructorDeStrings.apply("Otro String");
    }
}