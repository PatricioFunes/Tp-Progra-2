package test;

import modelo.Grafo;
import modelo.Persona;

public class TestGrafo {

    public static void main(String[] args) {
        Grafo<Persona> grafo =new Grafo<>();


        Persona p1 = new Persona("Bruno", 25);
        Persona p2 = new Persona("Francisco", 34);
        Persona p3 = new Persona("Marcos", 23);
        Persona p4 = new Persona("Patricio", 20);

        //agregar nodos
        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);
        grafo.agregarNodo(p4);

        //Agregar aristas (no dirigido)
        grafo.agregarArista(p1,p2);
        grafo.agregarArista(p1,p3);
        grafo.agregarArista(p2,p4);
        //Matriz de adyacencia
        grafo.mostrarListaAdyacencia();
        System.out.println("-------------");
        grafo.mostrarMatrizAdyacencia();

        grafo.bfs(p1);
        grafo.dfs(p1);
    /*en el caso de que se quiera hacer un dirigido agregamos un constructor que reciba un boolean en la clase grafo donde se pueda determinar si es dirigido o no
      y que cada vez que se agregue una arista se compruebe si es dirigido o no para agregar la arista destino origen (linea 37 38 de grafo)
    */
    }
}