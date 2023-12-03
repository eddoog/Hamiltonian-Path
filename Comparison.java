public class Comparison {
    public static void experiment() {
        int[][] small = GraphGenerator.generateGraph(16);
        testDP(small, "Small");
        testBacktrack(small, "Small");

        System.out.println("=========================================");

        int[][] medium = GraphGenerator.generateGraph(18);
        testDP(medium, "Medium");
        testBacktrack(medium, "Medium");

        System.out.println("=========================================");

        int[][] large = GraphGenerator.generateGraph(20);
        testDP(large, "Large");
        testBacktrack(large, "Large");
    }

    private static void testDP(int[][] graph, String type) {
        long startTime = System.nanoTime();
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        HamiltonianDP.find(graph);

        long endTime = System.nanoTime();
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Execution time - DP - " + type + ": " + (endTime - startTime));
        System.out.println("Memory Usage - DP - " + type + ": " + (endMemory - startMemory));
    }

    private static void testBacktrack(int[][] graph, String type) {
        long startTime = System.nanoTime();
        long startMemory = getUsedMemory();

        HamiltonianBacktrack.find(graph);

        long endTime = System.nanoTime();
        long endMemory = getUsedMemory();

        System.out.println("Execution time - Backtrack - " + type + ": " + (endTime - startTime));
        System.out.println("Memory Usage - Backtrack - " + type + ": " + (endMemory - startMemory));
    }

    private static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
