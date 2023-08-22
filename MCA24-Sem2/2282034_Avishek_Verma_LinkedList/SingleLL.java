import java.util.Scanner;

/*
 1. Write a menu driven program to implement a singly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists
 */

class Node<T> {
    T data;
    Node<T> next;
    Node<T> head = null;

    Node() {
    }

    Node(T data) {
        this.data = data;
        next = null;
    }

    public void create(T data) {
        if (head == null) {
            Node<T> newNode = new Node<>(data);
            head = newNode;
            head.next = null;
            System.out.println("> A new list has been created <");
            display();
        } else
            System.out.println("> List already created <");
    }

    public void insertAtEnd(T data) {
        if (head != null) {
            Node<T> newNode = new Node<>(data);
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;

            System.out.println("> Inserted " + data + " <");
            display();
        } else {
            System.out.println("> List is Empty <");
            create(data);
        }
    }

    public void insertAtBegin(T data) {
        if (head != null) {
            Node<T> newNode = new Node<>(data);
            Node<T> temp = head;
            head = newNode;
            head.next = temp;
            System.out.println("> Inserted " + data + " <");
            display();
        } else {
            System.out.println("> List is Empty <");
            create(data);
        }
    }

    public void insertAtPos(int pos, T data) {
        if (pos > count())
            System.out.println("> Requested Index not available <");
        else {
            if (head != null) {
                Node<T> temp = head;
                int i = 0;
                while (temp.next != null) {
                    i++;
                    if (i == pos - 1) {
                        break;
                    }

                    temp = temp.next;

                }
                Node<T> newNode = new Node<>(data);
                Node<T> temp2 = temp.next;
                temp.next = newNode;
                newNode.next = temp2;
                System.out.println("> " + data + " Inserted to Position " + pos + " <");
                display();
            } else {
                System.out.println("> List is Empty <");
                create(data);

            }

        }
    }

    public int count() {
        if (head == null)
            return 0;
        else if (head.next == null)
            return 1;
        else {
            int i = 0;
            Node<T> temp = head;
            while (temp.next != null) {
                i++;
                temp = temp.next;
            }
            return i + 1;
        }
    }

    public void display() {

        if (count() > 1) {
            Node<T> temp = head;
            System.out.print("> Current List : ");
            while (temp != null) {
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
            System.out.print(" <");
        } else if (count() == 1) {
            System.out.println("> Current List : " + head.data + " <");
        }

        else
            System.out.println("> List is Empty <");
    }

    public void deleteAtEnd() {
        if (head != null) {
            if (count() == 1)
                head = null;
            else if (count() > 1) {
                Node<T> temp = head;
                int i = 1;

                while (i != count() - 1) {
                    temp = temp.next;
                    i++;
                }
                temp.next = null;
            }
            System.out.println("> Node Deleted <");
            display();

        } else
            System.out.println("> List is Empty <");
    }

    public void deleteAtBegin() {
        if (head != null) {
            if (count() == 1)
                head = null;
            else if (count() > 1)
                head = head.next;

            System.out.println("> Node Deleted <");
            display();

        } else
            System.out.println("> List is Empty <");
    }

    public void deleteAtPos(int pos) {
        if (pos > count())
            System.out.println("> Requested Index not available <");

        else if (pos == 1)
            deleteAtBegin();

        else {
            if (head != null) {
                int i = 0;
                Node<T> temp = head;
                while (temp != null) {
                    i++;
                    if (i == pos - 1)
                        break;
                    temp = temp.next;
                }
                System.out.println("> Deleted " + temp.data + " <");
                temp.next = temp.next.next;
                display();
            } else
                System.out.println("> Create a node first <");

        }
    }

    public void reverseList() {
        Node<T> temp = head;
        Node<T> prev = null;
        Node<T> next = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
        System.out.println("> List Reversed <");
        display();

    }

    public void linearSearch(T key) {
        Node<T> temp = head;
        int flag = 0, i = 1;

        if (head != null) {
            while (temp != null) {
                if (temp.data == key) {
                    flag = 1;
                    break;
                }
                i++;
                temp = temp.next;
            }

            if (flag == 1)
                System.out.println("> " + key + " was found at position " + i);
            else
                System.out.println("> " + key + " was not found <");
        } else
            System.out.println("> List is Empty <");
    }

    public void concatenate(Node<T> head2) {
        Node<T> temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = head2;
        display();
    }

}

public class SingleLL {
    public static void main(String[] args) {
        Node<Integer> sLinkedList = new Node<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\n1. Insert at beginning" +
                            "\n2. Insert at end" +
                            "\n3. Insert at position" +
                            "\n4. Delete from front" +
                            "\n5. Delete from last" +
                            "\n6. Delete at position" +
                            "\n7. DISPLAY" +
                            "\n8. Count" +
                            "\n9. Reverse the List" +
                            "\n10. Search the list" +
                            "\n11. Concatenate two lists" +
                            "\n12. Exit");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 12) {
                break;
            }

            switch (ch) {
                case 1:
                    // Inserting at Beginning
                    System.out.println("Enter data: ");
                    sLinkedList.insertAtBegin(sc.nextInt());
                    break;
                case 2:
                    // Inserting at end
                    System.out.println("Enter data: ");
                    sLinkedList.insertAtEnd(sc.nextInt());
                    break;
                case 3:
                    // Inserting at specific position
                    System.out.println("Enter the position: ");
                    int pos = sc.nextInt();
                    System.out.println("Enter data: ");
                    int data = sc.nextInt();
                    sLinkedList.insertAtPos(pos, data);
                    break;

                case 4:
                    // delete at beginning
                    sLinkedList.deleteAtBegin();
                    break;
                case 5:
                    // Delete from end
                    sLinkedList.deleteAtEnd();
                    break;
                case 6:
                    // delete at position
                    System.out.println("Enter the position: ");
                    sLinkedList.deleteAtPos(sc.nextInt());
                    break;

                case 7:
                    // displaying the linked list
                    sLinkedList.display();
                    break;

                case 8:
                    // counting the linked list
                    System.out.println("> There are " + sLinkedList.count() + " nodes <");
                    break;

                case 9:
                    // reverse a list
                    sLinkedList.reverseList();

                case 10:
                    // Linear Search
                    System.out.println("Enter element to search: ");
                    sLinkedList.linearSearch(sc.nextInt());
                    break;

                case 11:
                    // concatenate two lists
                    Node<Integer> newList = new Node<>();
                    newList.create(10);
                    System.out.println();
                    newList.insertAtEnd(30);
                    System.out.println();
                    newList.insertAtEnd(20);
                    System.out.println();
                    sLinkedList.concatenate(newList.head);
                    break;

                default:
                    System.out.println("INVALID CHOICE");
            }
        }
        sc.close();
    }
}