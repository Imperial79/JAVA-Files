import java.util.Scanner;

class SNode<T> {
    SNode<T> head = null;
    SNode<T> next = null;
    T data;

    SNode() {
    }

    SNode(T data) {
        this.data = data;
    }

    public int count() {
        if (head == null)
            return 0;
        else if (head.next == null)
            return 1;
        else {
            int i = 0;
            SNode<T> current = head;
            while (current.next != null) {
                i++;
                current = current.next;
            }
            return i + 1;
        }
    }

    public void create(T data) {
        SNode<T> newNode = new SNode<>(data);
        head = newNode;
        head.next = null;
        System.out.println(data + " Inserted");
        display();
    }

    public void push(T data) {
        if (head != null) {
            SNode<T> newNode = new SNode<>(data);
            SNode<T> current = head;

            while (current.next != null)
                current = current.next;
            current.next = newNode;
            System.out.println(data + " Inserted");
            display();

        } else
            create(data);
    }

    public void pop() {

        if (count() == 0)
            System.out.println("-- Stack Underflow --");

        else if (count() == 1) {

            System.out.println("Popped " + head.data);
            head = null;

            display();

        } else {
            int i = 1;
            SNode<T> current = head;
            while (i != count() - 1) {
                current = current.next;
                i++;
            }
            System.out.println("Popped " + current.next.data);
            current.next = null;

            display();
        }
    }

    public void display() {
        SNode<T> current = head;

        if (count() == 0)
            System.out.println("-- STACK IS EMPTY --");
        else if (count() == 1) {
            System.out.print("STACK -> ");
            System.out.print(head.data);
        } else {
            System.out.print("STACK -> ");
            while (current != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
        }
    }
}

public class StackLL {
    public static void main(String[] args) {
        SNode<Integer> stack = new SNode<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\n1. Push" +
                            "\n2. Pop" +
                            "\n3. Display" +
                            "\n4. Exit");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 4)
                break;
            switch (ch) {
                case 1:
                    System.out.println("Enter element to push: ");
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;

                default:
                    break;
            }

        }

        sc.close();
    }
}