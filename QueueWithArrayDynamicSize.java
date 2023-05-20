
public class QueueWithArrayDynamicSize {
	    private static final int DEFAULT_CAPACITY = 10;
	    private int[] queueArray;
	    private int front;      // Index of the front element
	    private int rear;       // Index of the rear element
	    private int currentSize; // Current size of the queue

	    // Constructor to initialize the queue
	    public QueueWithArrayDynamicSize() {
	        queueArray = new int[DEFAULT_CAPACITY];
	        front = 0;
	        rear = -1;
	        currentSize = 0;
	    }

	    // Method to add an element to the rear of the queue
	    public void enqueue(int element) {
	        if (isFull()) {
	            resizeArray();
	        }
	        rear = (rear + 1) % queueArray.length;
	        queueArray[rear] = element;
	        currentSize++;
	        System.out.println("Enqueued element: " + element);
	    }

	    // Method to remove the front element from the queue
	    public int dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty. Cannot dequeue element.");
	            return -1;  // Return -1 to indicate queue underflow
	        }
	        int dequeuedElement = queueArray[front];
	        front = (front + 1) % queueArray.length;
	        currentSize--;
	        System.out.println("Dequeued element: " + dequeuedElement);
	        return dequeuedElement;
	    }

	    // Method to check if the queue is empty
	    public boolean isEmpty() {
	        return currentSize == 0;
	    }

	    // Method to check if the queue is full
	    public boolean isFull() {
	        return currentSize == queueArray.length;
	    }

	    // Method to resize the array when it becomes full
	    private void resizeArray() {
	        int newCapacity = queueArray.length * 2;
	        int[] newArray = new int[newCapacity];

	        for (int i = 0; i < currentSize; i++) {
	            newArray[i] = queueArray[(front + i) % queueArray.length];
	        }

	        front = 0;
	        rear = currentSize - 1;
	        queueArray = newArray;
	    }

	    public static void main(String[] args) {
	    	QueueWithArrayDynamicSize queue = new QueueWithArrayDynamicSize();

	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);
	        queue.enqueue(40);
	        queue.enqueue(50);
	        queue.enqueue(60);

	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();

	        queue.enqueue(70);
	        queue.enqueue(80);
	        queue.enqueue(90);

	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();
	        queue.dequeue();
	    }
	}
