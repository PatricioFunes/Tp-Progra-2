
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GrafoListaAdy<V> implements Grafo<V> {
    private final Map<V, Map<V, Double>> ady = new HashMap<>();

    @Override
    public void addVertice(V v) {
        ady.putIfAbsent(v, new HashMap<>());
    }

    @Override
    public void addArista(V origen, V destino, double peso) {
        addVertice(origen);
        addVertice(destino);
        ady.get(origen).put(destino, peso);
    }

    @Override
    public Set<V> getVertices() {
        return ady.keySet();
    }

    @Override
    public Map<V, Double> getAdyacentes(V v) {
        return ady.getOrDefault(v, Map.of());
    }
}
