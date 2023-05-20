
public class LL_Stack {

	    private Node top;

	    private static class Node {
	        int data;
	        Node next;

	        Node(int data) {
	            this.data = data;
	        }
	    }

	    public void push(int data) {
	        Node newNode = new Node(data);
	        newNode.next = top;
	        top = newNode;
	        System.out.println("Pushed element: " + data);
	    }

	    public int pop() {
	        if (isEmpty()) {
	            System.out.println("Stack is empty. Cannot pop element.");
	            return -1;  // Return -1 to indicate stack underflow
	        }

	        int poppedElement = top.data;
	        top = top.next;
	        return poppedElement;
	    }

	    public int peek() {
	        if (isEmpty()) {
	            System.out.println("Stack is empty. Cannot peek element.");
	            return -1;  // Return -1 to indicate stack underflow
	        }

	        return top.data;
	    }

	    public boolean isEmpty() {
	        return top == null;
	    }

	    public void display() {
	        if (isEmpty()) {
	            System.out.println("Stack is empty.");
	            return;
	        }

	        Node current = top;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	    	LL_Stack stack = new LL_Stack();

	        stack.push(10);
	        stack.push(20);
	        stack.push(30);
	        stack.push(40);
	        System.out.print("Stack elements are : ");
	        stack.display();

	        int poppedElement = stack.pop();
	        System.out.println("Popped element: " + poppedElement);

	        int peekedElement = stack.peek();
	        System.out.println("Peeked element: " + peekedElement);
	        System.out.print("Stack elements are : ");
	        stack.display();
	    }
	}
