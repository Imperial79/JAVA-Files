// Write a program to remove the Nth node from the end of a linked list.

class Node {
    int data;
    Node next;
    Node head = null;

    Node() {
    }

    Node(int data) {
        this.data = data;
        next = null;
    }

    public void create(int value) {
        if (head == null) {
            Node newNode = new Node(value);
            head = newNode;
            head.next = null;

            System.out.println("A new list has been created with data " + value);
        }
    }

    int count() {
        if (head == null)
            return 0;
        else if (head.next == null)
            return 1;
        else {
            int c = 0;
            Node temp = head;
            while (temp != null) {
                c++;
                temp = temp.next;
            }

            return c;
        }
    }

    public void insertAtEnd(int value) {
        if (head != null) {
            Node newNode = new Node(value);
            Node temp = head;

            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;

            System.out.println("Inserted " + value + " at end");
        }
    }

    public void deleteAtPos(int pos) {
        int c = count();
        System.out.println("Current length: " + c);
        if (pos > c)
            System.out.println("INdex not available");
        else if (c == 1)
            head = null;
        else if (pos == 1)
            head = head.next;
        else {
            Node temp = head;
            int i = 1;
            System.out.println("c = " + c);
            while (i < pos - 1) {
                i++;
                temp = temp.next;
            }

            System.out.println("You want to delete " + temp.next.data);
            temp.next = temp.next.next;
        }

    }

    public void display() {
        Node temp = head;
        System.out.println("Current length: " + count());
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

}

public class Prac1 {

    public static void main(String[] args) {
        Node node = new Node();
        node.create(10); // pos 1
        node.insertAtEnd(11); // pos 2
        node.insertAtEnd(12);// pos 3
        node.insertAtEnd(13);// pos 4
        node.insertAtEnd(14);// pos 5
        node.display();
        node.deleteAtPos(2);
        node.display();

    }
}