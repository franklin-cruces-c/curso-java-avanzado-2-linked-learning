package org.ejemplo.streams;

import java.util.ArrayList;

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
