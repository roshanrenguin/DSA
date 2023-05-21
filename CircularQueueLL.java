public class CircularQueueLL {
    private Node front, rear;
    private int size, capacity;

    public CircularQueueLL(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        rear.next = front; // Make the queue circular
        size++;
        System.out.println("Enqueued: " + data);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        int data = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front; // Make the queue circular
        }
        size--;
        System.out.println("Dequeued: " + data);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        Node current = front;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != front);
        System.out.println();
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        CircularQueueLL queue = new CircularQueueLL(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.displayQueue();

        queue.dequeue();
        queue.dequeue();
        queue.displayQueue();

        queue.enqueue(6);
        queue.displayQueue();
    }
}
