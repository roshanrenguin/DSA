
import java.util.LinkedList;
import java.util.Queue;

class BFS {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    BFS(int v) {
        vertices = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            LinkedList<Integer> neighbors = adjacencyList[currentVertex];
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
    	BFS graph = new BFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);

        System.out.print("BFS traversal starting from vertex 0: ");
        graph.breadthFirstSearch(0);
    }
}
