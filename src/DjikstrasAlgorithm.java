import java.util.*;

public class DjikstrasAlgorithm{
    private GraphAdjacencyList graph;

    public DjikstrasAlgorithm(GraphAdjacencyList graph){
        this.graph = graph;
    }

    public void djikstrasAlg(String start){
        Map<String, Double> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();

        for(String vertex : graph.getAdjList().keySet()){
            dist.put(vertex, Double.POSITIVE_INFINITY);
        }
        dist.put(start, 0.0);

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingDouble(dist::get));
        queue.add(start);
        while(!queue.isEmpty()){
            String vertex = queue.poll();
            for(Edge edge : graph.getAdjList().get(vertex)){
                String neighbor = edge.getDest();
                double weight = edge.getWeight();
                double newDist = dist.get(vertex) + weight;
                if(newDist < dist.get(neighbor)){
                    dist.put(neighbor, newDist);
                    prev.put(neighbor, vertex);
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        for(String vertex : dist.keySet()){
            List<String> path = getPath(prev, start, vertex);
            for(int i = 0; i < path.size(); i++){
                System.out.print(path.get(i));
                if(i < path.size()-1){
                    System.out.print(" -> ");
                }
            }
            System.out.println(" Dist: " + dist.get(vertex));
        }
    }
    private List<String> getPath(Map<String, String> prev, String start, String vertex){
        LinkedList<String> path = new LinkedList<>();
        String current = vertex;
        while(current != null){
            path.addFirst(current);
            current = prev.get(current);
        }
        return path;
    }
}