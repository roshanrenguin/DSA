
public class SinglyToCircularLinkedList {

		public static class NodeClass {
			int data;
			NodeClass next;
			
			public NodeClass(int value) {// Constructor for Node class
				data = value;
				next = null;
			}
		}
		
		public static void convertToCircular(NodeClass head) {
			NodeClass current = head;
			
			while (current.next != null) {
				current = current.next;
			}
			current.next = head;
		}
		
		public static void printList(NodeClass head) {
			NodeClass current = head;
			
			do {
				System.out.print(current.data + "-> ");
				current = current.next;
			} while (current != head);
			
			System.out.println();
			System.out.println("The next node after last node [" + current.data + "] - is the Head node, forms circular list"); 
		}
		
		
		public static void printSinlgyLinkedList(NodeClass head) {
			NodeClass current = head;
			
			do {
				System.out.print(current.data + "->");
				current = current.next;
			}while (current.next != null);
			
			System.out.println(current.data + " - Last node is pointing to NULL");
		}
		
		public static void main(String[] args) {
			NodeClass head = new NodeClass(10);
			head.next = new NodeClass(21);
			head.next.next = new NodeClass(32);
			head.next.next.next = new NodeClass(43);
			System.out.println("The Singly linked list is: ");
			printSinlgyLinkedList(head); 
			convertToCircular(head); 
			System.out.println("The converted circular linked list is: ");
			printList(head);
		}
	}
