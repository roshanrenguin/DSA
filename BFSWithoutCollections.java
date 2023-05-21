//BFS Tree
public class BFSWithoutCollections {
    static class Node {
        int value;
        Node left, right;
        
        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    
    static void bfs(Node root) {
        if (root == null)
            return;
        
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printLevel(root, i);
        }
    }
    
    static int getHeight(Node node) {
        if (node == null)
            return 0;
        
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    static void printLevel(Node node, int level) {
        if (node == null)
            return;
        
        if (level == 1) {
            System.out.print(node.value + " ");
        } else if (level > 1) {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }
    
    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.println("BFS traversal of the binary tree:");
        bfs(root);
    }
}
