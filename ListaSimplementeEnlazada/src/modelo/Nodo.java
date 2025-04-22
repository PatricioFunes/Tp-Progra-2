package modelo;

import interfaces.INodo;

public class Nodo implements INodo {

    private Vehiculo dato;
    private INodo siguiente;

    public Nodo(Vehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public Vehiculo getDato() {
        return dato;
    }

    @Override
    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    @Override
    public INodo getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(INodo siguiente) {
        this.siguiente = siguiente;
    }
}