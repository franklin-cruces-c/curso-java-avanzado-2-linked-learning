package org.ejemplo.hilos.objetos.inmutables;

import java.awt.*;

/*
 * Se coloca final la clase para que no pueda ser extendida
 * y con este y los otros cambios realizados asegurando  la inmutabilidad
 * Otra forma seria colocar los constructores como private y reemplazarlos
 * por metodo estaticos factoría
 */
//public class Circulo {
public final class Circulo {
    /*
     * Las variables deben ser private y final para que
     * no puedan ser modificadas.
     */
//    private double radio;
//    private Color color;
    private final double radio;
    private final Color color;

    /*
     * El Objeto Color se crea desde afuera de la clase
     * con cual tienen acceso total a él
     * se debe tambien hacer una copia defensiva
     * @param radio
     * @param color
     */
//    public Circulo(double radio, Color color) {
//        this.radio = radio;
//        this.color = color;
//    }
    public Circulo(double radio, Color color) {
        this.radio = radio;
        this.color = new Color(color.getRGB());
    }
    /*
     * este metodo se quita ya que incumple con la inmutabilidad ya que
     * permite cambiar los estados del objeto (los atributos)
     * @param radio
     */
//    public void establecerRadio(double radio) {
//        this.radio = radio;
//    }

    /*
     * este metodo se quita ya que incumple con la inmutabilidad ya que
     * permite cambiar los estados del objeto (los atributos)
     * @param color
     */
//    public void establecerColor(Color color) {
//        this.color = color;
//    }

    /**

     * @return
     */
    public double obtenerRadio() {
        return radio;
    }

    /*
     * se modifica para que devuelva una copia defensiva
     * para que no tengan acceso desde afuera de la clase
     * al objeto Color y no pueda ser modificado
     * @return
     */
//    public Color obtenerColor() {
//        return color;
//    }
    public Color obtenerColor() {
        return new Color(color.getRGB());
    }
    public double obtenerDiametro() {
        return radio * 2;
    }

    public double obtenerArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    /*
     * Modificamos este metodo para que cumpla con la
     * inmutabilidad, devolviendo un nuevo objeto escalado
     * en lugar de modificar el objeto actual
     * @param factor
     */
//    public void escalar(double factor) {
//        radio *= factor;
//    }
    public Circulo escalar(double factor) {
        return new Circulo(radio * factor, color);
    }

}
