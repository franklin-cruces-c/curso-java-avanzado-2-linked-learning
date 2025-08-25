package com.mparrastia.frases;


import org.ejemplo.estructuras.Frase;
import org.ejemplo.utils.GeneradorDeFrasesAleatorias;

public class GestorFraseDelDia {

    private Frase fraseDelDia;

    public Frase obtenerfraseDelDia() {
        if (fraseDelDia == null) {
           fraseDelDia = GeneradorDeFrasesAleatorias.obtenerFraseAleatoria();
        }
        return fraseDelDia;
    }
}
