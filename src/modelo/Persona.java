package modelo;

import java.util.Objects;

public class Persona {

    private final String nombre;
    private final int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }


    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre; // Simplificado para que las impresiones sean más limpias
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre);
    }

    @Override
    public int hashCode() {
        // Forma moderna y más segura de generar un hashCode
        return Objects.hash(nombre, edad);
    }
}
