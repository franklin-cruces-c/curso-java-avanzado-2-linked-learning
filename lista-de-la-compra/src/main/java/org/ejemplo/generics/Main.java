package org.ejemplo.generics;

public class Main {
    public static void main(String[] args) {
        Caja miCaja = new Caja();
        miCaja.set(58);
        // Esta conversion da error en tiempo de ejecución
        // Ya que se utiliza Object en lugar de generics
        // con lo cual no lo verifica el compilador
        //String miString = (String) miCaja.get();

        CajaGenerica<Integer> miCajaGenerica = new CajaGenerica<>();
        // En esta conversion el compilador verfica y el error
        // de compatibilidad sale antes de ejecutar el programa
        // lo cual es muy conveniente para evitar problemas incluso
        // en produccion si no es detectado por ejemplo porque el codigo
        // no se llegue a ejecutar en las pruebas.
        //String miString = (String) miCajaGenerica.get();
        


    }

}