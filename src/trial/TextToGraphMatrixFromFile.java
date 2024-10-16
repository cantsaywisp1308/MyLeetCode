package trial;
import java.util.*;
import java.io.*;
public class TextToGraphMatrixFromFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String fileName = "input.txt"; // Replace with your input file name
	        int[][] graphMatrix = textToGraphMatrixFromFile(fileName);
	        printMatrix(graphMatrix);
	}

	public static int[][] textToGraphMatrixFromFile(String fileName) {
		try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            List<String> lines = new ArrayList<>();

            // Read each line from the file
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();

            int size = lines.size();
            int[][] matrix = new int[size][size];

            // Create a map to keep track of node positions
            Map<Character, Integer> nodePositions = new HashMap<>();
            int count = 0;

            // Traverse each line to identify unique nodes
            for (String line : lines) {
                String[] nodes = line.split(" ");

                // Traverse each node
                for (String node : nodes) {
                    char ch = node.charAt(0);
                    int index = (int)ch - 97;
                    matrix[count][index] = 1;
                }
                count++;
            }

            // Traverse each line again to build the adjacency matrix
            
//            for (String line : lines) {
//                String[] nodes = line.split(" ");
//                int[] nodeIndexes = new int[nodes.length];
//
//                // Get the indexes of the nodes from the map
//                for (int i = 0; i < nodes.length; i++) {
//                    char ch = nodes[i].charAt(0);
//                    nodeIndexes[i] = nodePositions.get(ch);
//                }
//
//                // Update the adjacency matrix based on node indexes
//                for (int i = 1; i < nodeIndexes.length; i++) {
//                    matrix[nodeIndexes[0]][nodeIndexes[i]] = 1;
//                    matrix[nodeIndexes[i]][nodeIndexes[0]] = 1;
//                }
//            }

            return matrix;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return null;
            
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is null.");
            return;
        }
        
        System.out.println("{");
        for (int[] row : matrix) {
            System.out.print("\t{");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i != row.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("},");
        }
        System.out.println("}");
    }
}

