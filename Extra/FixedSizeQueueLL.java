public class FixedSizeQueueLL {
    private Node head;
    private Node tail;
    private int maxSize;
    private int currentSize;
    
    private static class Node {
        private int data;
        private Node next;
        
        public Node(int data) {
            this.data = data;
        }
    }
    
    public FixedSizeQueueLL(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public void enqueue(int data) {
        if (currentSize == maxSize) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        currentSize++;
    }
    
    public int dequeue() {
        if (currentSize == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Assuming -1 represents an invalid value
        }
        
        int data = head.data;
        head = head.next;
        
        if (head == null) {
            tail = null;
        }
        
        currentSize--;
        
        return data;
    }
    
    public int size() {
        return currentSize;
    }
    
    public static void main(String[] args) {
        FixedSizeQueueLL queue = new FixedSizeQueueLL(5);
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Exceeding the maximum size
        
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        
        System.out.println("Current size: " + queue.size());
    }
}
