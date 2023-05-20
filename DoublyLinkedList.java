public class DoublyLinkedList {
    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Element inserted at Head : " + data);
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Element inserted at Tail : " + data);
    }

    public void insertAfter(int key, int data) {
        Node newNode = new Node(data);
        Node current = head;

        while (current != null) {
            if (current.data == key) {
                if (current == tail) {
                    insertAtTail(data);
                } else {
                    newNode.prev = current;
                    newNode.next = current.next;
                    current.next.prev = newNode;
                    current.next = newNode;
                    System.out.println("Element inserted after " + key + " : " + data);
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Key not found in the list.");
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == key) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
                System.out.println("Element deleted : " + key);
            }
            return;
        }

        if (tail.data == key) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        Node current = head.next;
        while (current != null) {
            if (current.data == key) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }
            current = current.next;
            
        }

        System.out.println("Key not found in the list.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.print("Elements in DLL : ");
        list.display();
        list.insertAtHead(10);
        System.out.print("Elements in DLL : ");
        list.display();
        list.insertAtHead(20);
        list.insertAtTail(30);
        list.insertAfter(20, 25);
        System.out.print("Elements in DLL : ");
        list.display();

        list.delete(20);
        System.out.print("Elements in DLL : ");
        list.display();
    }
}
