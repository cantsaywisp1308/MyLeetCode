package trial;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class COMP147_TakeHome {

	public static void main(String[] args) {
		String fileName = "input.txt";
		String outputFileName = "output.txt";
		// TODO Auto-generated method stub
//		int[][] graph = {
//				{0,1,1,0,1,1},
//				{1,0,0,1,1,1},
//				{1,0,0,1,1,1},
//				{0,1,1,0,1,1},
//				{1,1,1,1,0,0},
//				{1,1,1,1,0,0}};
		int[][] graph = textToGraphMatrixFromFile(fileName);
		int[][] color = new int[graph.length][3];
		int c = 1;
		for(int i = 0 ; i < color.length;i++) {
			
			for(int j = 0 ; j <3;j++) {
				color[i][j] = c;
				c++;
			}
			
		}
		int[][] nodes = new int[graph.length][4];
		List<List<Integer>> edges = new ArrayList<>();
		List<List<Integer>> result = getNodesAndEdges(graph, color, nodes, edges);
		try {
            File outputFile = new File(outputFileName);
            FileWriter writer = new FileWriter(outputFile);

            // Writing the output to the file
            for (List<Integer> edge : result) {
            	for(Integer integer : edge) {
            		writer.write(integer.toString() + " ");
            	}
                writer.write("\n");
            }

            writer.close();
            System.out.println("Output written to " + outputFileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
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
	
	public static List<List<Integer>> getNodesAndEdges(int[][] graph, int[][] color, int[][] nodes, List<List<Integer>> edges) {
		int c = 1;
		for(int i = 0; i<graph.length;i++) {
			List<Integer> node = new ArrayList<Integer>();
			for(int j = 0; j < 3;j++) {
				node.add(c);
				nodes[i][j] =color[i][j];
				c++;
			}
			node.add(0);
			edges.add(node);
			
			List<Integer> edge = new ArrayList<Integer>();
			edge.add(-nodes[i][0]);
			edge.add(-nodes[i][1]);
			edge.add(0);
			edges.add(edge);
			
			edge = new ArrayList<Integer>();
			edge.add(-nodes[i][0]);
			edge.add(-nodes[i][2]);
			edge.add(0);
			edges.add(edge);
			
			edge = new ArrayList<Integer>();
			edge.add(-nodes[i][1]);
			edge.add(-nodes[i][2]);
			edge.add(0);
			edges.add(edge);
		}
		
		for(int i = 0 ; i <graph.length;i++) {
			for(int j = 0; j < graph[i].length;j++) {
				if(graph[i][j] == 1) {
					for(int k = 0; k < 3;k++) {
						List<Integer> edge = new ArrayList<Integer>();
						edge.add(-color[i][k]);
						edge.add(-color[j][k]);
						edge.add(0);
						edges.add(edge);
					}
				}
			}
		}
//		System.out.println("Nodes: ");
//		for(int i = 0 ; i < nodes.length;i++) {
//			for(int j = 0; j < nodes[i].length;j++) {
//				System.out.print(nodes[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("=============================");
		System.out.println("Edges: ");
		
		for(List<Integer> edge : edges) {
			System.out.println(edge);
		}
		System.out.print(edges.size());
		return edges;
	}
}
