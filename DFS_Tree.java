
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class DFS_Tree {
    Node root;

    void depthFirstSearch() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        dfsUtil(root);
    }

    void dfsUtil(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        dfsUtil(node.left);
        dfsUtil(node.right);
    }

    public static void main(String[] args) {
    	DFS_Tree tree = new DFS_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("DFS traversal of the binary tree: ");
        tree.depthFirstSearch();
    }
}
