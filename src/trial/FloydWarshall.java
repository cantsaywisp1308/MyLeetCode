package trial;

public class FloydWarshall {

	static final int V = 4; // Number of vertices in the graph

    static void floydWarshall(int[][] graph) {
        int[][] dist = new int[V][V];

        // Initialize distance matrix same as input graph matrix
        for (int i = 0; i < V; i++) {
            System.arraycopy(graph[i], 0, dist[i], 0, V);
        }

        System.out.println("Initial Matrix:");
        printMatrix(dist);

        for (int k = 0; k < V; k++) {
            System.out.println("\nIntermediate Matrix " + (k + 1) + ":");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
            printMatrix(dist);
        }

        System.out.println("\nFinal Shortest Path Matrix:");
        printMatrix(dist);
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(val + "\t");
                }
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] graph = {
		            {0, 5, 2, Integer.MAX_VALUE},
		            {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 3 },
		            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,  Integer.MAX_VALUE},
		            {1, Integer.MAX_VALUE, 7, 0}
		        };

		        floydWarshall(graph);
	}

}
