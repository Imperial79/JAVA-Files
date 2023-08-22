/*2. Write a menu driven program to implement a circularDll circular linked list with the
following operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list */

import java.util.Scanner;

class CNode<T> {
    T data;
    CNode<T> head = null;
    CNode<T> next = null;
    CNode<T> prev = null;

    CNode() {
    }

    CNode(T data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public int count() {

        if (head == null)
            return 0;
        else if (head.next == head && head.prev == head)
            return 1;
        else {
            int i = 0;
            CNode<T> current = head;
            while (current.next != head) {
                i++;
                current = current.next;
            }
            return i + 1;
        }
    }

    public void create(T data) {
        CNode<T> newNode = new CNode<>(data);
        head = newNode;
        head.next = head.prev = head;
        System.out.println("-- NEW NODE CREATED --");
        display();
    }

    public void insertFront(T data) {
        if (head != null) {
            CNode<T> newNode = new CNode<>(data);
            CNode<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            newNode.prev = current;
            current.next = newNode;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            display();
        } else {
            create(data);
        }
    }

    public void insertPos(int pos, T data) {
        if (pos == 1)
            insertFront(data);
        else if (pos == count())
            insertEnd(data);
        else if (pos > 1 && pos < count()) {
            int i = 1;
            CNode<T> newNode = new CNode<>(data);
            CNode<T> current = head;
            while (i != pos - 1) {
                current = current.next;
                i++;
            }

            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;

            display();
        } else
            System.out.println("-- Invalid Position --");
    }

    public void insertEnd(T data) {
        if (head != null) {
            CNode<T> newNode = new CNode<>(data);
            CNode<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            newNode.prev = current;
            current.next = newNode;
            newNode.next = head;
            head.prev = newNode;

            display();
        } else
            create(data);

    }

    public void deleteFront() {
        if (count() == 0)
            System.out.println("-- List is Empty --");

        else if (count() == 1)
            head = null;
        else {
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next;

            display();

        }
    }

    public void deleteEnd() {
        if (count() == 0)
            System.out.println("-- List is Empty --");
        else if (count() == 1) {
            head = null;
            display();
        } else {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
            display();
        }
    }

    public void deletePos(int pos) {
        if (pos == 1)
            deleteFront();
        else if (pos == count())
            deleteEnd();
        else if (pos > 1 && pos < count()) {
            int i = 1;
            CNode<T> current = head;
            while (i != pos - 1) {
                current = current.next;
                i++;
            }

            current.next.next.prev = current;
            current.next = current.next.next;

            display();
        } else
            System.out.println("-- Invalid Position --");
    }

    public void display() {
        System.out.println("Count = " + count());
        if (count() == 0)
            System.out.println("-- List is Empty --");
        else if (count() == 1)
            System.out.println("Available List -> " + head.data);
        else {
            System.out.print("Available List -> ");
            CNode<T> current = head;

            System.out.print(current.data + ", ");
            while (current.next != head) {
                current = current.next;
                System.out.print(current.data + ", ");
            }
        }

    }
}

public class CircularDLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CNode<Integer> circularDll = new CNode<>();
        while (true) {
            System.out.println(
                    "\n1. Insert at front" +
                            "\n2. Insert at end" +
                            "\n3. Insert at position" +
                            "\n4. Delete from front" +
                            "\n5. Delete from end" +
                            "\n6. Delete at position" +
                            "\n7. DISPLAY" +
                            "\n8. Exit");

            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 8) {
                break;
            }
            switch (ch) {
                case 1:
                    // Insert At Front
                    System.out.println("Enter element: ");
                    circularDll.insertFront(sc.nextInt());
                    break;
                case 2:
                    // Insert At End
                    System.out.println("Enter element: ");
                    circularDll.insertEnd(sc.nextInt());
                    break;

                case 3:
                    // Insert At Pos
                    System.out.println("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.println("Enter element: ");
                    circularDll.insertPos(pos, sc.nextInt());
                    break;
                case 4:
                    // Delete From Front
                    circularDll.deleteFront();
                    break;
                case 5:
                    // Delete From End
                    circularDll.deleteEnd();
                    break;
                case 6:
                    // Delete At Pos
                    System.out.println("Enter Position: ");
                    circularDll.deletePos(sc.nextInt());
                    break;
                case 7:
                    // Display
                    circularDll.display();
                    break;

                default:
                    break;
            }

        }

        sc.close();
    }
}
