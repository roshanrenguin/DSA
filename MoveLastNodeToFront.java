
public class MoveLastNodeToFront {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void moveLastNodeToFront() {
        if (head == null || head.next == null) {
            return; // No or only one node in the list
        }

        Node prev = null;
        Node last = head;

        while (last.next != null) {
            prev = last;
            last = last.next;
        }

        prev.next = null; // Disconnect the last node from the list

        last.next = head; // Move last node to the front
        head = last;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MoveLastNodeToFront linkedList = new MoveLastNodeToFront();

        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);

        System.out.println("Before moving last node to front:");
        linkedList.display();

        linkedList.moveLastNodeToFront();

        System.out.println("After moving last node to front:");
        linkedList.display();
    }
}
