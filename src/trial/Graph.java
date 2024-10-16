package trial;

import java.util.*;



public class Graph {

	int V; // number of vertices
    List<Integer>[] adjList;

    // Constructor
    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // Adds an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // Undirected graph
    }

    // Construct Line Graph
    public Graph lineGraph() {
        Graph L = new Graph(this.V * (this.V - 1) / 2);
        int idx = 0;
        Map<Pair, Integer> edgeMap = new HashMap<>();

        for (int i = 0; i < this.V; i++) {
            for (int j : adjList[i]) {
                if (i < j) {
                    edgeMap.put(new Pair(i, j), idx++);
                }
            }
        }

        for (Pair edge1 : edgeMap.keySet()) {
            for (Pair edge2 : edgeMap.keySet()) {
                if (edge1.intersect(edge2)) {
                    L.addEdge(edgeMap.get(edge1), edgeMap.get(edge2));
                }
            }
        }

        return L;
    }

    // Greedy coloring algorithm
    public int chromaticNumber() {
        int[] result = new int[this.V];
        Arrays.fill(result, -1);

        result[0] = 0;

        boolean[] availableColors = new boolean[this.V];
        Arrays.fill(availableColors, true);

        for (int u = 1; u < this.V; u++) {
            for (int adj : adjList[u]) {
                if (result[adj] != -1) {
                    availableColors[result[adj]] = false;
                }
            }

            int clr;
            for (clr = 0; clr < this.V; clr++) {
                if (availableColors[clr]) {
                    break;
                }
            }

            result[u] = clr;

            Arrays.fill(availableColors, true);
        }

        return Arrays.stream(result).max().getAsInt() + 1;
    }

    static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Pair)) return false;
            Pair other = (Pair) o;
            return (this.a == other.a && this.b == other.b) ||
                   (this.a == other.b && this.b == other.a);
        }

        @Override
        public int hashCode() {
            return a * 31 + b;
        }

        public boolean intersect(Pair other) {
            return this.a == other.a || this.a == other.b ||
                   this.b == other.a || this.b == other.b;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Graph G = new Graph(4);
	        G.addEdge(0, 1);
	        G.addEdge(1, 2);
	        G.addEdge(2, 3);
	        G.addEdge(3, 0);
	        G.addEdge(0, 2);
	        G.addEdge(1, 3);

	        Graph L = G.lineGraph();

	        System.out.println("Minimum colors needed for edge-coloring: " + L.chromaticNumber());
	}

}
