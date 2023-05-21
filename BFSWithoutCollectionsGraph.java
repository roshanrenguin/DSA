public class BFSWithoutCollectionsGraph {

    static class Graph {
        int vertices;
        int[][] adjacencyMatrix;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyMatrix = new int[vertices][vertices];
        }

        public void addEdge(int source, int destination) {
            adjacencyMatrix[source][destination] = 1;
            adjacencyMatrix[destination][source] = 1;
        }

        public void breadthFirstSearch(int startVertex) {
            boolean[] visited = new boolean[vertices];
            int[] queue = new int[vertices];
            int front = -1, rear = -1;

            visited[startVertex] = true;
            queue[++rear] = startVertex;

            while (front != rear) {
                int currentVertex = queue[++front];
                System.out.print(currentVertex + " ");

                for (int i = 0; i < vertices; i++) {
                    if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        queue[++rear] = i;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.print("BFS traversal: ");
        graph.breadthFirstSearch(0);
    }
}
