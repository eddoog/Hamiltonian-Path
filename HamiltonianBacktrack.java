/* 
Heavily inspired/copied from https://www.geeksforgeeks.org/hamiltonian-cycle/
Java program for solution of Hamiltonian Path problem
   using backtracking */

public class HamiltonianBacktrack {
    /*
     * A utility function to check if the vertex v can be
     * added at index 'pos'in the Hamiltonian Path
     * constructed so far (stored in 'path[]')
     */
    boolean isSafe(int v, int graph[][], int path[], int pos) {
        /*
         * Check if this vertex is an adjacent vertex of
         * the previously added vertex.
         */
        if (graph[path[pos - 1]][v] == 0)
            return false;

        /*
         * Check if the vertex has already been included.
         * This step can be optimized by creating an array
         * of size V
         */
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    /*
     * A recursive utility function to solve hamiltonian
     * Path problem
     */
    boolean findPathUtil(int graph[][], int path[], int pos, int V) {
        /*
         * base case: If all vertices are included in
         * Hamiltonian Path
         */
        if (pos == V)
            return true;

        // Try different vertices as a next candidate in
        // Hamiltonian Path. We don't try for 0 as we
        // included 0 as starting point in hamPath()
        for (int v = 1; v < V; v++) {
            /*
             * Check if this vertex can be added to Hamiltonian
             * Path
             */
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                /* recur to construct rest of the path */
                if (findPathUtil(graph, path, pos + 1, V) == true)
                    return true;

                /*
                 * If adding vertex v doesn't lead to a solution,
                 * then remove it
                 */
                path[pos] = -1;
            }
        }

        /*
         * If no vertex can be added to Hamiltonian Path
         * constructed so far, then return false
         */
        return false;
    }

    /*
     * This function solves the Hamiltonian Path problem using
     * Backtracking. It mainly uses hamPathUtil() to solve the
     * problem. It returns false if there is no Hamiltonian Path
     * possible, otherwise return true and prints the path.
     * Please note that there may be more than one solutions,
     * this function prints one of the feasible solutions.
     */
    void findPath(int graph[][]) {
        int V = graph.length;
        int[] path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;

        /*
         * Let us put vertex 0 as the first vertex in the path.
         * If there is a Hamiltonian Path, then the path can be
         * started from any point of the Path as the graph is
         * undirected
         */
        path[0] = 0;

        System.out.println(findPathUtil(graph, path, 1, V));
    }

    public static void find(int graph[][]) {
        HamiltonianBacktrack hamiltonian = new HamiltonianBacktrack();
        hamiltonian.findPath(graph);
    }
}
// This code is contributed by Abhishek Shankhadhar