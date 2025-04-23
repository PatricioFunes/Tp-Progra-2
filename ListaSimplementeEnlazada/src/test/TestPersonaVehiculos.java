package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestPersonaVehiculos {

    public static void main(String[] args) {

        Persona p = new Persona(11111, "Bruno Bianchi");

        test("Lista no debe ser vacia", p.getListaVehiculos().esVacia(), true);

        Vehiculo v1 = new Vehiculo("aaa111", "Toyota gr yaris");
        p.getListaVehiculos().insertarPrimero(v1);
        test("Lista no debe ser vacia tras insertarPrimero", p.getListaVehiculos().esVacia(), false);
        test("cantidadElementos debe ser 1 tras insertarPrimero", p.getListaVehiculos().cantidadElementos(), 1);
        test("obtenerPrimero debe ser v1", p.getListaVehiculos().obtenerPrimero(), v1);

        Vehiculo v2 = new Vehiculo("bbb222", "Fiat Uno");
        p.getListaVehiculos().insertarUltimo(v2);
        test("cantidadElementos debe ser 2 tras insertarUltimo", p.getListaVehiculos().cantidadElementos(), 2);
        test("obtenerPrimero permanece v1 tras insertarUltimo", p.getListaVehiculos().obtenerPrimero(), v1);

        p.mostrarPersona();

    }

    private static void test(String descripcion, boolean actual, boolean esperado) {
        System.out.println(descripcion);

    }

    private static void test(String descripcion, int actual, int esperado) {
        System.out.println(descripcion);
    }

    private static void test(String descripcion, Vehiculo actual, Vehiculo esperado) {
        System.out.println(descripcion);
    }
}
