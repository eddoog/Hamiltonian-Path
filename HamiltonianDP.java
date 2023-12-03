/* 
Heavily inspired/copied from https://www.geeksforgeeks.org/hamiltonian-path-using-dynamic-programming/
Java program for the above approach
 */
public class HamiltonianDP {

    // Function to check whether there
    // exists a Hamiltonian Path or not
    static boolean Hamiltonian_path(int graph[][], int N) {
        boolean dp[][] = new boolean[N][(1 << N)];

        // Set all dp[i][(1 << i)] to
        // true
        for (int i = 0; i < N; i++)
            dp[i][(1 << i)] = true;

        // Iterate over each subset
        // of nodes
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {

                // If the jth nodes is included
                // in the current subset
                if ((i & (1 << j)) != 0) {

                    // Find K, neighbour of j
                    // also present in the
                    // current subset
                    for (int k = 0; k < N; k++) {

                        if ((i & (1 << k)) != 0 &&
                                graph[k][j] == 1 && j != k &&
                                dp[k][i ^ (1 << j)]) {
                            // Update dp[j][i]
                            // to true
                            dp[j][i] = true;
                            break;
                        }
                    }
                }
            }
        }

        // Traverse the vertices
        for (int i = 0; i < N; i++) {
            // Hamiltonian Path exists
            if (dp[i][(1 << N) - 1])
                return true;
        }

        // Otherwise, return false
        return false;
    }

    public static void find(int graph[][]) {
        int N = graph.length;

        // Function Call
        if (Hamiltonian_path(graph, N))
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }
}