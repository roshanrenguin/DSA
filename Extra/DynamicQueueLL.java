//Dynamic size queue using a linked
public class DynamicQueueLL {
    private Node front;
    private Node rear;
    private int size;
    
    private class Node {
        private int data;
        private Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public DynamicQueueLL() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
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
        
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        
        int data = front.data;
        front = front.next;
        size--;
        
        if (isEmpty()) {
            rear = null;
        }
        
        return data;
    }
    
    public int getSize() {
        return size;
    }
    
    public void printQueue() {
        Node current = front;
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        DynamicQueueLL queue = new DynamicQueueLL();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        queue.printQueue();  // Output: 10 20 30
        
        int removedItem = queue.dequeue();
        System.out.println("Removed item: " + removedItem);  // Output: Removed item: 10
        
        queue.printQueue();  // Output: 20 30
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.printQueue();  // Output: 20 30 40 50 60
    }
}
