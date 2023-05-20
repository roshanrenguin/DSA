public class QueueWithArrayFixedSize {
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;
    
    public QueueWithArrayFixedSize(int capacity) {
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = item;
        size++;
        System.out.println("Enqueued element: " + item);
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;  // Return -1 to indicate queue underflow
        }
        int dequeuedItem = queueArray[front];
        front = (front + 1) % queueArray.length;
        size--;
        System.out.println("Dequeued element: " + dequeuedItem);
        return dequeuedItem;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queueArray.length;
    }
    
    public static void main(String[] args) {
        QueueWithArrayFixedSize queue = new QueueWithArrayFixedSize(5);  // Create a queue with fixed size 5
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);  // Trying to enqueue element to a full queue
        
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();  // Trying to dequeue element from an empty queue
    }
}
