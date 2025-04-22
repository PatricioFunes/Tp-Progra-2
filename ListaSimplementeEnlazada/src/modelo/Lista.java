package modelo;

import interfaces.ILista;
import interfaces.INodo;

public class Lista implements ILista {

    private INodo primero;

    public Lista() {
        this.primero = null;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void insertarPrimero(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (!esVacia()) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {
            primero = nuevo;
        }
    }

    @Override
    public void insertarUltimo(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = nuevo;
        } else {
            INodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    @Override
    public Vehiculo obtenerPrimero() {
        if (esVacia()) throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }

    @Override
    public int cantidadElementos() {
        int contador = 0;
        INodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }

    @Override
    public void mostrarLista() {
        INodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato() + "\n");
            actual = actual.getSiguiente();
        }
    }
}