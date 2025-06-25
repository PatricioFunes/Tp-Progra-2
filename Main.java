import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Construccion del grafo
        Grafo<String> grafo = new GrafoListaAdy<>();
        grafo.addVertice("Hospital");
        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("Paciente");

        // 2. Aristas con peso = tiempo promedio (minutos)
        grafo.addArista("Hospital", "A", 4.5);
        grafo.addArista("Hospital", "B", 2.0);
        grafo.addArista("A", "B", 1.5);
        grafo.addArista("A", "Paciente", 7.0);
        grafo.addArista("B", "Paciente", 5.0);

        // 3. Ejecucion de Dijkstra
        Dijkstra<String> dijkstra = new Dijkstra<>();
        Dijkstra.Resultado<String> resultado = dijkstra.compute(grafo, "Hospital");

        // 4. Mostrar distancias minimas
        System.out.println("Distancias desde Hospital:");
        for (Map.Entry<String, Double> e : resultado.getDistancias().entrySet()) {
            System.out.printf("  %s → %.2f min%n", e.getKey(), e.getValue());
        }

        // 5. Reconstruir y mostrar camino minimo hasta Paciente
        List<String> camino = dijkstra.getCaminoMinimo(resultado, "Paciente");
        System.out.println("Camino mínimo a Paciente: " + camino);
    }
}
