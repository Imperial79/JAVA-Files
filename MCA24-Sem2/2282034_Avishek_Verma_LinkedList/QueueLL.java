import java.util.Scanner;

class QNode<T> {
    QNode<T> head = null;
    QNode<T> next = null;
    T data;

    QNode() {
    }

    QNode(T data) {
        this.data = data;
    }

    public void create(T data) {
        QNode<T> newNode = new QNode<>(data);
        head = newNode;
        head.next = null;
        System.out.println(data + " Inserted");
        display();
    }

    public int count() {
        if (head == null)
            return 0;
        else if (head.next == null)
            return 1;
        else {
            int i = 0;
            QNode<T> current = head;
            while (current.next != null) {
                i++;
                current = current.next;
            }
            return i + 1;
        }
    }

    public void enqueue(T data) {
        if (head != null) {
            QNode<T> newNode = new QNode<>(data);
            QNode<T> current = head;

            while (current.next != null)
                current = current.next;
            current.next = newNode;
            System.out.println(data + " Inserted");
            display();

        } else
            create(data);
    }

    public void dequeue() {
        if (head != null) {
            System.out.println(head.data + " Deleted");
            if (count() == 1)
                head = null;
            else if (count() > 1)
                head = head.next;

            display();

        } else
            System.out.println("-- QUEUE IS EMPTY --");
    }

    public void display() {
        QNode<T> current = head;

        if (count() == 0)
            System.out.println("-- QUEUE IS EMPTY --");
        else if (count() == 1) {
            System.out.print("QUEUE -> ");
            System.out.print(head.data);
        } else {
            System.out.print("QUEUE -> ");
            while (current != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
        }
    }

}

public class QueueLL {
    public static void main(String[] args) {
        QNode<Integer> queue = new QNode<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\n1. Enqueue" +
                            "\n2. Dequeue" +
                            "\n3. Display" +
                            "\n4. Exit");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 4)
                break;
            switch (ch) {
                case 1:
                    System.out.println("Enter element to push: ");
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;

                default:
                    break;
            }

        }

        sc.close();
    }

}
