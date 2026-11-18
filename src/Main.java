import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "data/Graph.txt";

        GraphAdjacencyList graph = new GraphAdjacencyList();
        graph.fileRead(fileName);

        System.out.println("Graph file to read from " + fileName);
        System.out.println();
        System.out.println("List of nodes: ");
        Set<String> nodes = graph.getAdjList().keySet();
        for (String node : nodes){
            System.out.println(node + " ");
        }
        System.out.println("\n");
        Scanner input = new Scanner(System.in);
        String start;
        DjikstrasAlgorithm djikstrasAlgorithm = new DjikstrasAlgorithm(graph);
        while(true){
            System.out.print("Enter start vertex: ");
            start = input.nextLine();
            if(!nodes.contains(start)){
                break;
            }
            djikstrasAlgorithm.djikstrasAlg(start);
        }
        input.close();
    }
}
