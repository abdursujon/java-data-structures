import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


public class Graph<T>{
    private Map<T, List<T>> adjacencyList = new HashMap<>();

    public void addVertex(T vertex){
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T from, T to){
        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());
        adjacencyList.get(from).add(to);
        // undirected graph so we add connection on both direction
        adjacencyList.get(to).add(from);
    }

    public List<T> getNeighbours(T vertex){
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public Set<T> getVertices(){
        return adjacencyList.keySet();
    }

    public static void main(String[] args){
        Graph<Integer> graph = new Graph<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);


        System.out.println("neighbours of 1: " + graph.getNeighbours(1));
        System.out.println("neighbours of 2: " + graph.getNeighbours(2));
        System.out.println("neighbours of 3: " + graph.getNeighbours(3));
        System.out.println("neighbours of 4: " + graph.getNeighbours(4));


        Set<Integer> vertices = graph.getVertices();
        System.out.println("All vertices of given graph is: " + vertices);

        // full adjacency view
        for (Integer vertex : vertices) {
            List<Integer> neighbours = graph.getNeighbours(vertex);
            System.out.println(vertex + " -> " + neighbours);
        }
    }
}
