
public class LL_Queue {


	    private Node front;
	    private Node rear;

	    private static class Node {
	        int data;
	        Node next;

	        Node(int data) {
	            this.data = data;
	        }
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
	        System.out.println("Enqueued element: " + data);
	    }

	    public int dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty. Cannot dequeue element.");
	            return -1;  // Return -1 to indicate queue underflow
	        }

	        int dequeuedElement = front.data;
	        front = front.next;

	        if (front == null) {
	            rear = null;  // If front becomes null after dequeue, update rear as well
	        }

	        return dequeuedElement;
	    }

	    public int peek() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty. Cannot peek element.");
	            return -1;  // Return -1 to indicate queue underflow
	        }

	        return front.data;
	    }

	    public boolean isEmpty() {
	        return front == null;
	    }

	    public void display() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty.");
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
	    	LL_Queue queue = new LL_Queue();

	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);
	        queue.enqueue(40);
	        System.out.print("Elements in queue : ");
	        queue.display();

	        int dequeuedElement = queue.dequeue();
	        System.out.println("Dequeued element: " + dequeuedElement);

	        int peekedElement = queue.peek();
	        System.out.println("Peeked element: " + peekedElement);
	        System.out.print("Elements in queue : ");
	        queue.display();
	    }
	}
