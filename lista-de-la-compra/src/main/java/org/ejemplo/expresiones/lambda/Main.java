package org.ejemplo.expresiones.lambda;

public class Main {
    public static void main(String[] args) {
       MiValor miValor = ()-> 2.8;
       System.out.println("Si ejecuto miValor.obtenerValor()  obtengo:"  +miValor.obtenerValor());

       OperadorUnario raizCuadrada = n -> Math.sqrt(n);
       System.out.println("raíz cuadrada de 4 es : "+raizCuadrada.aplicar(4));

       OperadorBinario multiplicacion = (x,y) -> x*y;
       System.out.println("El resultado de multiplicar 6x8 es:" + multiplicacion.aplicar(6,8));

       OperadorBinario minimoComunMultiplo = (x,y) -> {
           double mcm;
           if(x>y){
               mcm = x;
           } else{
               mcm = y;
           }
           while(mcm % x != 0 || mcm % y != 0){
               mcm++;
           }
           return mcm;
       };
       System.out.println("El mínimo común múltiplo de 12 y 9 es: "+minimoComunMultiplo.aplicar(12,9));
       Ejemplo ejemplo = new Ejemplo();
       ejemplo.miMetodo();
    }
}
