package modelo;

import java.util.*;

public class Grafo <T> {


    //(clave, valor)
    //Clave valor como diccionarios de python
    private Map<T, Nodo> nodos = new HashMap<>();
    private final boolean esDirigido;

    public Grafo(boolean esDirigido){ //grafo dirigido o no dirigido
        this.esDirigido=esDirigido;
    }

    public Grafo (){// grafo no dirigido
        this.esDirigido=false;
    }

    // Agrega un nodo al grafo si no existe aún

    public void agregarNodo(T valor) {
        nodos.putIfAbsent(valor, new Nodo<>(valor));
    }

    // Agrega una arista (conexión) entre dos nodos existentes
    public void agregarArista(T origen, T destino) {

        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            Nodo nodoOrigen = nodos.get(origen); //Agarro el nodo que tiene
            //como clave al origen... get retorna el NODO
            Nodo nodoDestino = nodos.get(destino);

            nodoOrigen.agregarVecino(nodoDestino);

            if (!esDirigido)
                nodoDestino.agregarVecino(nodoOrigen); // borrar en caso de ser dirigido

        }
    }

    // Muestra la matriz de adyacencia del grafo

    public void mostrarMatrizAdyacencia() {// las columnas y filas cambian en cada ejecucion
        System.out.println("Matriz de Adyacencia:");
        List<T> claves = new ArrayList<>(nodos.keySet());

        System.out.print("   ");
        for (T origen : claves) System.out.print(origen + " ");
        System.out.println();

        // Filas de la matriz
        for (T origen : claves) { /// 1--- 2  ---- 3 Columnas
            System.out.print(origen.toString() + ": ");
            for (T destino : claves) {  /// 1 , 2, 3 --- Filas
                Nodo nodoOrigen = nodos.get(origen);
                Nodo nodoDestino = nodos.get(destino);
                System.out.print(nodoOrigen.getVecinos().contains(nodoDestino) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    // Muestra la lista de adyacencia del grafo
    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");

        for (Map.Entry<T, Nodo> entrada : nodos.entrySet()) {

            System.out.print(entrada.getKey() + ": ");
            List<Nodo<T>> vecinos = entrada.getValue().getVecinos();

            for (Nodo<T> vecino : vecinos) {
                System.out.print(vecino.getValor()+ " ");
            }
            System.out.println();
        }
    }

    // Recorrido en anchura (Breadth First Search)
    public void bfs(T inicio) {

        if (!nodos.containsKey(inicio))
            return; // precondición

        ///Lista y cola
        Set<T> visitados = new HashSet<>(); // Conjunto de nodos visitados
        Queue<Nodo<T>> cola = new LinkedList<>(); // Cola para el recorrido

        Nodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.poll();
            System.out.print(actual.getValor() + " ");

            for (Nodo<T> vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getValor())) {
                    visitados.add(vecino.getValor());
                    cola.add((Nodo<T>) vecino);
                }
            }
        }
        System.out.println();
    }

    // Recorrido en profundidad (Depth First Search)
    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return; // precondición

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados); //Pila!!!!
        System.out.println();
    }

    // Función recursiva auxiliar para DFS
    private void dfsRec(Nodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getValor());
        System.out.print(actual.getValor() + " ");
        for (Nodo<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getValor())) {
                dfsRec(vecino, visitados);
            }
        }
    }
}