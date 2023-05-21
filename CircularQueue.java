public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    
    public CircularQueue(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }
        
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % queue.length;
        }
        
        queue[rear] = element;
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }
        
        int removedElement = queue[front];
        
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
        
        size--;
        return removedElement;
    }
    
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        
        return queue[front];
    }
    
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        
        System.out.println("Front: " + queue.front());  // Output: 1
        System.out.println("Rear: " + queue.rear());    // Output: 5
        
        queue.dequeue();
        queue.dequeue();
        
        queue.enqueue(6);
        queue.enqueue(7);
        
        System.out.println("Size: " + queue.size());     // Output: 5
        System.out.println("Front: " + queue.front());  // Output: 3
        System.out.println("Rear: " + queue.rear());    // Output: 7
    }
}
