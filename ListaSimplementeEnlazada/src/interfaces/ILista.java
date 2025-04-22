package interfaces;

import modelo.Vehiculo;

public interface ILista {

    boolean esVacia();

    void insertarPrimero(Vehiculo dato);

    void insertarUltimo(Vehiculo dato);

    Vehiculo obtenerPrimero();

    int cantidadElementos();

    void mostrarLista();
}