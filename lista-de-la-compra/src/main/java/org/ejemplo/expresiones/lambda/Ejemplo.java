package org.ejemplo.expresiones.lambda;

import java.util.function.UnaryOperator;

public class Ejemplo {
    private double miDouble = 5.0;
    private String miString = "Hola";

    public void miMetodo() {
        double miDoubleLocal = 7.0;
        String miStringLocal = "Buenos dias";

        UnaryOperator<Double> operacion1 = n -> {
            String miString = "lambda string";
            System.out.println("Dentro de la expresion lambda this.miString es" + this.miString);
            miDouble++;
            return miDouble + n;
        };
        /**
         * Esto no funciona porque las variables locales utilizadas en las expresiones
         * lambda son final
         */
//        UnaryOperator<Double> operacion2 = n -> {
//             miDoubleLocal ++;
//             return miDoubleLocal +n;
//        };
        UnaryOperator<String> operacion3 = n -> miDouble + n;
        UnaryOperator<String> operacion4 = n -> miStringLocal + n;
        operacion1.apply(2.0);

    }
}
