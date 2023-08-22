
/*1. Write a menu driven program to implement a doubly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list */

import java.util.Scanner;

class DNode<T> {
    DNode<T> prev;
    T data;
    DNode<T> next;
    DNode<T> head = null;

    DNode() {
    }

    DNode(T data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public int count() {
        if (head == null)
            return 0;
        else if (head.next == null)
            return 1;
        else {
            int i = 0;
            DNode<T> current = head;
            while (current.next != null) {
                i++;
                current = current.next;
            }
            return i + 1;
        }
    }

    public void create(T data) {
        DNode<T> newNode = new DNode<>(data);
        head = newNode;
        head.prev = null;
        head.next = null;
        System.out.println("> A new list has been created <");
        display();
    }

    public void insertFront(T data) {
        DNode<T> current = head;
        if (head != null) {
            DNode<T> newNode = new DNode<>(data);
            head = newNode;
            head.prev = null;
            head.next = current;
            current.prev = head;
            System.out.println("!! INSERTED !!");
            display();
        } else {
            System.out.println("> List is Empty <");
            create(data);
        }

    }

    public void deleteFront() {
        if (count() == 1)
            head = null;
        else if (count() > 1) {
            head = head.next;
            head.prev = null;
            System.out.println("!! DELETED !!");
            display();
        } else
            System.out.println("> List is Empty <");

    }

    public void insertEnd(T data) {
        if (head != null) {
            DNode<T> current = head;
            DNode<T> newNode = new DNode<>(data);
            while (current.next != null) {
                current = current.next;
            }
            newNode.prev = current;
            newNode.next = null;
            current.next = newNode;

            display();
        } else {
            System.out.println("> List is Empty <");
            create(data);
        }
    }

    public void deleteEnd() {

        if (count() == 1)
            head = null;

        else if (count() > 1) {
            DNode<T> current = head;
            int i = 1;
            while (i != count() - 1) {
                current = current.next;
                i++;
            }
            current.next = null;
            System.out.println("!! DELETED !!");
            display();
        }

        else
            System.out.println("> List is Empty <");
    }

    public void insertPos(int pos, T data) {

        if (head != null) {
            if (pos == count())
                insertEnd(data);
            else if (pos == 1) {
                insertFront(data);
            } else if (pos > 1 && pos < count()) {
                int i = 1;
                DNode<T> current = head;
                DNode<T> newNode = new DNode<>(data);
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
                System.out.println("!! Index Does not Exist !!");
        } else
            System.out.println("> List is Empty <");
    }

    public void deletePos(int pos) {
        if (pos > count())
            System.out.println("!! INDEX NOT AVAILABLE !!");
        else if (pos == 1)
            deleteFront();
        else {
            int i = 1;
            DNode<T> current = head;
            while (i != pos - 1) {
                current = current.next;
                i++;
            }
            if (pos == count()) {
                current.next = null;
            } else {
                DNode<T> temp = current.next.next;
                current.next = temp;
                temp.prev = current;
            }
            System.out.println("!! DELETED !!");
            display();

        }

    }

    public void display() {
        if (head != null) {
            DNode<T> current = head;
            System.out.print("Current List -> ");
            while (current != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
        } else
            System.out.println("> List is Empty <");
    }
}

public class DoubleLL {
    public static void main(String[] args) {
        DNode<Integer> doubly = new DNode<>();
        Scanner sc = new Scanner(System.in);
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
                    doubly.insertFront(sc.nextInt());
                    break;
                case 2:
                    // Insert At End
                    System.out.println("Enter element: ");
                    doubly.insertEnd(sc.nextInt());
                    break;

                case 3:
                    // Insert At Pos
                    System.out.println("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.println("Enter element: ");
                    doubly.insertPos(pos, sc.nextInt());
                    break;
                case 4:
                    // Delete From Front
                    doubly.deleteFront();
                    break;
                case 5:
                    // Delete From End
                    doubly.deleteEnd();
                    break;
                case 6:
                    // Delete At Pos
                    System.out.println("Enter Position: ");
                    doubly.deletePos(sc.nextInt());
                    break;
                case 7:
                    // Display
                    doubly.display();
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }
}
