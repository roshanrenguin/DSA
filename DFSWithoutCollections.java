public class DFSWithoutCollections {
    private static class Graph {
        private int V;
        private int[][] adjacencyMatrix;

        public Graph(int V) {
            this.V = V;
            adjacencyMatrix = new int[V][V];
        }

        public void addEdge(int source, int destination) {
            adjacencyMatrix[source][destination] = 1;
            adjacencyMatrix[destination][source] = 1;
        }

        public void DFS(int startVertex) {
            boolean[] visited = new boolean[V];
            DFSUtil(startVertex, visited);
        }

        private void DFSUtil(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            for (int i = 0; i < V; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    DFSUtil(i, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform DFS starting from vertex 0
        System.out.print("DFS traversal: ");
        graph.DFS(0);
    }
}
