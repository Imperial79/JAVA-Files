import java.util.Scanner;

class DeNode<T> {
    T data;
    DeNode<T> next = null;
    DeNode<T> head = null;

    DeNode() {
    }

    DeNode(T data) {
        this.data = data;
    }

    public void create(T data) {
        if (head == null) {
            DeNode<T> newNode = new DeNode<>(data);
            head = newNode;
            head.next = null;
            System.out.println("> A new list has been created <");
            display();
        } else
            System.out.println("> List already created <");
    }

    public void insertLeft(T data) {
        if (head != null) {
            DeNode<T> newNode = new DeNode<>(data);
            DeNode<T> temp = head;
            head = newNode;
            head.next = temp;
            System.out.println("> Inserted " + data + " <");
            display();
        } else {
            System.out.println("> List is Empty <");
            create(data);
        }
    }

    public void insertRight(T data) {
        if (head != null) {
            DeNode<T> newNode = new DeNode<>(data);
            DeNode<T> temp = head;

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

    public void deleteLeft() {
        if (head != null) {
            System.out.println("> " + head.data + " Deleted <");
            if (count() == 1)
                head = null;
            else if (count() > 1)
                head = head.next;

            display();

        } else
            System.out.println("> List is Empty <");
    }

    public void deleteRight() {
        if (head != null) {
            if (count() == 1)
                head = null;
            else if (count() > 1) {
                System.out.println("> " + head.data + " Deleted <");
                DeNode<T> temp = head;
                int i = 1;

                while (i != count() - 1) {
                    temp = temp.next;
                    i++;
                }
                temp.next = null;
            }
            display();

        } else
            System.out.println("> List is Empty <");
    }

    public int count() {
        if (head == null)
            return 0;
        else if (head.next == null)
            return 1;
        else {
            int i = 0;
            DeNode<T> temp = head;
            while (temp.next != null) {
                i++;
                temp = temp.next;
            }
            return i + 1;
        }
    }

    public void display() {

        if (count() > 1) {
            DeNode<T> temp = head;
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

}

public class DequeueLL {
    public static void main(String[] args) {
        DeNode<Integer> dequeue = new DeNode<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n1. Insert from Left" +
                            "\n2. Insert from Right" +
                            "\n3. Delete from Left" +
                            "\n4. Delete from Right" +
                            "\n5. DISPLAY" +
                            "\n6. Exit");

            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 6)
                break;
            switch (ch) {
                case 1:
                    System.out.println("Enter data: ");
                    dequeue.insertLeft(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter data: ");
                    dequeue.insertRight(sc.nextInt());
                    break;
                case 3:
                    dequeue.deleteLeft();
                    break;
                case 4:
                    dequeue.deleteRight();
                    break;

                case 5:
                    dequeue.display();
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }
}
