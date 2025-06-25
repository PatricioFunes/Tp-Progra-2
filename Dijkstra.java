
import java.util.*;

public class Dijkstra<V> {

    public static class Resultado<V> {
        private final Map<V, Double> distancias;
        private final Map<V, V> predecesores;

        public Resultado(Map<V, Double> dist, Map<V, V> pred) {
            this.distancias = dist;
            this.predecesores = pred;
        }

        public Map<V, Double> getDistancias() {
            return distancias;
        }

        public Map<V, V> getPredecesores() {
            return predecesores;
        }
    }

    // Ejecuta Dijkstra y devuelve distancias y predecesores
    public Resultado<V> compute(Grafo<V> grafo, V origen) {
        Map<V, Double> dist = new HashMap<>();
        Map<V, V> prev = new HashMap<>();
        for (V v : grafo.getVertices()) {
            dist.put(v, Double.POSITIVE_INFINITY);
            prev.put(v, null);
        }
        dist.put(origen, 0.0);

        // Cola de prioridad por distancia
        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        pq.add(new Nodo(origen, 0.0));

        while (!pq.isEmpty()) {
            Nodo nodo = pq.poll();
            V u = nodo.vertice;
            double d = nodo.distancia;
            if (d > dist.get(u))
                continue; // entrada obsoleta

            for (Map.Entry<V, Double> entry : grafo.getAdyacentes(u).entrySet()) {
                V v = entry.getKey();
                double peso = entry.getValue();
                double alt = dist.get(u) + peso;
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    pq.add(new Nodo(v, alt));
                }
            }
        }

        return new Resultado<>(dist, prev);
    }

    // Reconstruye camino minimo desde origen a destino
    public List<V> getCaminoMinimo(Resultado<V> res, V destino) {
        LinkedList<V> camino = new LinkedList<>();
        V paso = destino;
        while (paso != null) {
            camino.addFirst(paso);
            paso = res.getPredecesores().get(paso);
        }
        return camino;
    }

    // Clase auxiliar para la cola de prioridad
    private class Nodo implements Comparable<Nodo> {
        V vertice;
        double distancia;

        Nodo(V vertice, double distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(Nodo o) {
            return Double.compare(this.distancia, o.distancia);
        }
    }
}
