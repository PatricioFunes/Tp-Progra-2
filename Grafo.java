import java.util.Map;
import java.util.Set;

public interface Grafo<V> {
    void addVertice(V v);

    void addArista(V origen, V destino, double peso);

    Set<V> getVertices();

    Map<V, Double> getAdyacentes(V v);
}
