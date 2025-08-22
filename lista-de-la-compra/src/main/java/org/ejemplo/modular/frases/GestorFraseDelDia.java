package org.ejemplo.modular.frases;


import org.ejemplo.modular.estructuras.Frase;
import org.ejemplo.modular.utils.GeneradorDeFrasesAleatorias;

public class GestorFraseDelDia {

    private Frase fraseDelDia;

    public Frase obtenerfraseDelDia() {
        if (fraseDelDia == null) {
           fraseDelDia = GeneradorDeFrasesAleatorias.obtenerFraseAleatoria();
        }
        return fraseDelDia;
    }
}
