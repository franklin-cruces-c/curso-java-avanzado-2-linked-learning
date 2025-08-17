package org.ejemplo.genericos.interfaces.funcionales;

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        OperadorBinario<Double> multiplicacion1 = (a,b) -> a*b;
        System.out.println("El resultado de multiplicar 6.0 x 8.0 es:"+multiplicacion1.aplicar(6.0,8.0));

        OperadorBinario<String> concatenacion1 = (s1, s2) -> s1.concat(s2);

        System.out.println("Concatenando Hola Lambda" + concatenacion1.aplicar("Hola ","Lambda"));

        BinaryOperator<Double> multiplicacion = (x, y) -> x * y;
        System.out.println("El resultado de multiplicar 5 por 6 es " + multiplicacion.apply(5.0, 6.0));

        BinaryOperator<String> concatenacion = (x, y) -> x.concat(y);

    }
}
