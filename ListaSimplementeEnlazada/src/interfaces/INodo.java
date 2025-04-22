package interfaces;

import modelo.Vehiculo;

public interface INodo {

    Vehiculo getDato();

    void setDato(Vehiculo dato);

    INodo getSiguiente();

    void setSiguiente(INodo siguiente);
}
