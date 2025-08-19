package org.ejemplo.streams;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarteraDeClientes {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = crearListaDeClientes();

        for (Cliente cliente : clientes) {
            if (cliente.getNombre().startsWith("M")) {
                System.out.println(cliente.toString());
            }
        }

        // Con Stream
        System.out.println("******* Con Stream ******");
        clientes.stream()
                .filter(cliente -> cliente.getNombre().startsWith("M"))
                .forEach(System.out::println);

        // Con Stream y agregando un filtro adicional, clientes de Argentina
        System.out.println("******* Con Stream y agregando un filtro adicional, clientes de Argentina ******");
        clientes.stream()
                .filter(cliente -> cliente.getNombre().startsWith("M"))
                .filter(cliente -> cliente.getPais().equalsIgnoreCase("ARGENTINA"))
                .forEach(System.out::println);

        // Procesamiento en paraleto
        // Vale la pena cuando se procesan grandes cantidades de datos en maquinas multihilo
        System.out.println("******* Procesamiento en paralelo ******");
        clientes.parallelStream()
                .filter(cliente -> cliente.getNombre().startsWith("M"))
                .filter(cliente -> cliente.getPais().equalsIgnoreCase("ARGENTINA"))
                .forEach(System.out::println);

        /*
         * Operaciones intermedias, operaciones que se ejecutan sobre un stream
         * que producen otro stream, y estas no se ejecutan hasta que
         * no se invoca una operacion terminal (por ejemplo forEach).
         */
        System.out.println("Otro ejemplo, operaciones intermedias y operacion terminal");
        clientes.stream()
                .filter(cliente -> cliente.getPais().equalsIgnoreCase("MÉXICO"))
                .forEach(System.out::println);

        /*
         * Otro ejemplo con peek
         * peek no cierra el stream permitiendo encadenar mas operaciones
         * forEach cierra el stream ya que es una operacion terminal.
         */
        System.out.println("Otro ejemplo, con peek y count");
        clientes.stream()
                .filter(cliente -> cliente.getNombre().startsWith("M"))
                .peek(cliente -> System.out.println("Cliente cuyo nombre comienza por M "+cliente))
                .filter(cliente -> cliente.getPais().equalsIgnoreCase("MÉXICO"))
                .peek(cliente -> System.out.println("Cliente cuyo nombre comienza por M y es de México "+cliente))
                .count();


        /*
         * Operacion Map transforma los elementos de un stream, utilizando la funcion que se le envia
         */
        System.out.println("******* Operacion Map *******");
        Stream.of("MARIA", "PEDRO", "JUAN")
                .map(String::toLowerCase)
                .forEach(System.out::println);

        /*
         * distinct devuelve un stream con los elementos no duplicados utilizando el metodo equals
         */
        System.out.println("******* Operación distinct *******");
        Stream.of("MARIA", "PEDRO", "JUAN", "PEDRO")
                .distinct()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        /*
         * sorted devuelve un stream con los elementos ordenados, los elementos deben de ser comparables
         */
        System.out.println("******* Operación sorted *******");
        Stream.of("MARIA", "PEDRO", "JUAN", "PEDRO")
                .distinct()
                .sorted()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        /*
         * Operaciones terminales
         * Cuando trabajamos con streams los  pipelines terminan con una operacion terminal
         * que da como resultado algo diferente a un stream.
         */

        Stream.of(8,15,-3, 24, -99)
                .sorted()
                .forEach(System.out::println);

        Object [] myArray = Stream.of(8, 15, -3, 24, -99)
                .sorted()
                .toArray();

        Set<Object> mySet = Stream.of(8, 15, -3, 24, -99)
                .sorted()
                .collect(Collectors.toSet());
        /*
         * El operador reduce
         * reduce una secuencia de elementos a un único resultado aplicando repetidamente una
         * operacion binaria, aplicable a series como el factorial. Se va apilando el resultado..
         */

        Optional<Integer> producto = Stream.of(8, 15, -3, 24, -99)
                .sorted()
                .reduce((a,b) -> a * b);
        System.out.println("El producto final es :" + producto.get());


        /**
         * Operaciones predefinidas
         */
         int suma =  IntStream.of(8, 15, -3, 24, -99)
                .sorted()
                .sum();
        System.out.println("La suma final es :" + suma);

        /*
         *  Operaciones Booleanas
         */
        boolean mayorQue10 =  IntStream.of(8, 15, -3, 24, -99)
                .sorted()
                .anyMatch(i -> i >10);

        System.out.println("Hay algun elemento mayor que 10? "+mayorQue10);

        boolean TodosmayoresQue10 =  IntStream.of(8, 15, -3, 24, -99)
                .sorted()
                .allMatch(i -> i >10);

        System.out.println("Son todos los elementos mayores que 10? "+TodosmayoresQue10);
    }

    static ArrayList<Cliente> crearListaDeClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("GREGORIO", "HINOJOSA", "MÉXICO"));
        clientes.add(new Cliente("LORENA", "DE LUCAS", "COLOMBIA"));
        clientes.add(new Cliente("LAURA", "GARATE", "ESPAÑA"));
        clientes.add(new Cliente("JUAN CARLOS", "MORATALLA", "ARGENTINA"));
        clientes.add(new Cliente("JOSE CARLOS", "CORRALES", "PERÚ"));
        clientes.add(new Cliente("SEBASTIAN", "GALAN", "VENEZUELA"));
        clientes.add(new Cliente("JUANA", "MERA", "ARGENTINA"));
        clientes.add(new Cliente("MÓNICA", "MENDIZABAL", "MÉXICO"));
        clientes.add(new Cliente("PEDRO", "GARCÍA", "ESPAÑA"));
        clientes.add(new Cliente("ALBA", "ESPEJO", "CHILE"));
        clientes.add(new Cliente("JAIME", "VIZUETE", "ECUADOR"));
        clientes.add(new Cliente("MARÍA MAR", "CHECA", "GUATEMALA"));
        clientes.add(new Cliente("MARÍA", "CABANILLAS", "ARGENTINA"));
        clientes.add(new Cliente("JOSE CARLOS", "ARTIGAS", "BOLIVIA"));
        clientes.add(new Cliente("MANUEL", "SANTAMARIA", "REPÚBLICA DOMINICANA"));
        clientes.add(new Cliente("SILVIA", "GAMERO", "HONDURAS"));
        clientes.add(new Cliente("LUCIA", "ALCOLEA", "EL SALVADOR"));
        return clientes;
    }
}
