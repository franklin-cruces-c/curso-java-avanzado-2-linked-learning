package org.ejemplo.generics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Caja miCaja = new Caja();
        miCaja.set(58);
        /**
         *          Esta conversion da error en tiempo de ejecución
         *          Ya que se utiliza Object en lugar de generics
         *          con lo cual no lo verifica el compilador
         */

        //String miString = (String) miCaja.get();

        CajaGenerica<Integer> miCajaGenerica = new CajaGenerica<>();
        /**
         * En esta conversion el compilador verfica y el error
         * de compatibilidad sale antes de ejecutar el programa
         * lo cual es muy conveniente para evitar problemas incluso
         * en produccion si no es detectado por ejemplo porque el codigo
         * no se llegue a ejecutar en las pruebas.
          */

        //String miString = (String) miCajaGenerica.get();

        Object miObjeto = new Object();
        Integer miInteger = 22;
        miObjeto = miInteger;

        Number miNumero = miInteger;

        ArrayList<Number> miLista = new ArrayList<>();
        miLista.add(miNumero);
        miLista.add(miInteger);

        mostrarLista(miLista);

        ArrayList<Integer> miListaInteger = new ArrayList<>();
        miListaInteger.add(miInteger);
        /**
         *        La el paramtero que estamos enviando no es un subtipo
         *         es decir si bien Integer si es subtipo de Number
         *         ArrayList<Integer> no es subtipo de ArrayList<Number>
          */
           // mostrarLista(miListaInteger);
         mostrarListaConWildCards(miListaInteger);
    }

    public static void mostrarLista(ArrayList<Number> lista){
        for(Number numero: lista){
            System.out.println(numero);
        }
    }

    /**
     * Para este caso extends en la wildcard funciona tanto par extends de clases
     * como para el implements de las interfaces
     * @param lista
     */
    public static void mostrarListaConWildCards(ArrayList<? extends Number> lista){
        for(Number numero: lista){
            System.out.println(numero);
        }
    }
/**
 *  En este caso utilizando super e Integer, el metodo acepta
 *  desde Integer hacia arriba hasta llegar a Object.
 */
    public static void mostrarListaConWildCardsConSuper(ArrayList<? super Integer> lista){
        for(Object object: lista){
            System.out.println(object);
        }
    }
}