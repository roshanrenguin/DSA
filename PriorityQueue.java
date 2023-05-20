public class PriorityQueue {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] queueArray;
    private int size;

    public PriorityQueue() {
        queueArray = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            resizeArray();
        }
        
        int currentIndex = size;
        queueArray[currentIndex] = element;
        size++;

        // Adjust the heap by comparing with parent nodes and swapping if necessary
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (queueArray[currentIndex] < queueArray[parentIndex]) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
        System.out.println("Enqueued element: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty. Cannot dequeue element.");
            return -1;  // Return -1 to indicate priority queue underflow
        }

        int dequeuedElement = queueArray[0];
        size--;

        // Move the last element to the root position
        queueArray[0] = queueArray[size];

        // Adjust the heap by comparing with child nodes and swapping if necessary
        int currentIndex = 0;
        while (currentIndex < size) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the index of the smaller child
            int smallestChildIndex = currentIndex;
            if (leftChildIndex < size && queueArray[leftChildIndex] < queueArray[smallestChildIndex]) {
                smallestChildIndex = leftChildIndex;
            }
            if (rightChildIndex < size && queueArray[rightChildIndex] < queueArray[smallestChildIndex]) {
                smallestChildIndex = rightChildIndex;
            }

            if (smallestChildIndex != currentIndex) {
                swap(currentIndex, smallestChildIndex);
                currentIndex = smallestChildIndex;
            } else {
                break;
            }
        }

        return dequeuedElement;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queueArray.length;
    }

    private void resizeArray() {
        int newCapacity = queueArray.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(queueArray, 0, newArray, 0, size);
        queueArray = newArray;
    }

    private void swap(int index1, int index2) {
        int temp = queueArray[index1];
        queueArray[index1] = queueArray[index2];
        queueArray[index2] = temp;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        
        pq.enqueue(20);
        pq.enqueue(10);
        pq.enqueue(30);
        pq.enqueue(50);
        pq.enqueue(40);
        System.out.println("---------------------");

        while (!pq.isEmpty()) {
            int dequeuedElement = pq.dequeue();
            System.out.println("Dequeued element: " + dequeuedElement);
        }
    }
}
