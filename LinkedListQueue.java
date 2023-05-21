// Que with Linked-List
public class LinkedListQueue {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int data = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.display(); // Output: 1 2 3

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 1

        queue.display(); // Output: 2 3

        System.out.println("Front element: " + queue.peek()); // Output: 2
    }
}
