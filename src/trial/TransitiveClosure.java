package trial;
import java.util.*;

public class TransitiveClosure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adjacencyMatrix = {
	            {0, 1, 0, 0},
	            {0, 0, 1, 0},
	            {0, 0, 0, 1},
	            {0, 0, 0, 0}
	        };

	        System.out.println("Initial Adjacency Matrix:");
	        printMatrix(adjacencyMatrix);

	        int[][] transitiveClosure = findTransitiveClosure(adjacencyMatrix);
	        System.out.println("\nTransitive Closure:");
	        printMatrix(transitiveClosure);
	}

	public static int[][] findTransitiveClosure(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        int[][] transitiveClosure = new int[n][n];

        // Initialize the transitive closure matrix with the adjacency matrix
        for (int i = 0; i < n; i++) {
            transitiveClosure[i] = Arrays.copyOf(adjacencyMatrix[i], n);
        }

        System.out.println("\nIntermediate Matrices:");
        for (int k = 0; k < n; k++) {
            System.out.println("Intermediate Matrix " + (k + 1) + ":");
            printMatrix(transitiveClosure);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transitiveClosure[i][j] = transitiveClosure[i][j] | (transitiveClosure[i][k] & transitiveClosure[k][j]);
                }
            }
        }
        return transitiveClosure;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
