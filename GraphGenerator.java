import java.util.Random;

public class GraphGenerator {
    public static int[][] generateGraph(int vertices) {
        Random rand = new Random();
        int[][] graph = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                int edge = rand.nextInt(2);
                graph[i][j] = edge;
                graph[j][i] = edge;
            }
        }
        return graph;
    }
}
