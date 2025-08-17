package org.ejemplo.genericos.interfaces.funcionales;

@FunctionalInterface
public interface OperadorBinario<T> {
    T aplicar(T operando1, T operando2);

}
