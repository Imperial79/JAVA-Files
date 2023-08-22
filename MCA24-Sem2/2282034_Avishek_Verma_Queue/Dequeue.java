import java.util.Scanner;

/*
 * 3. Write a menu driven program to implement a deque using list.
Call the two ends of the deque left and right and write four C functions, remvLeft,
remvRight, insrtLeft, insrtRight to remove and insert elements at the left and right
ends of the deque. Make sure that the routines work properly for empty deque and
that they detect overflow and underflow
 */

public class Dequeue {
    int arr[];
    int front;
    int end;
    int size;

    Dequeue(int n) {
        size = n;
        arr = new int[n];
        front = -1;
        end = -1;
    }

    boolean isFull() {
        if (front == 0 && end == size - 1 || front == end + 1)
            return true;
        return false;
    }

    boolean isEmpty() {
        if (front == -1 && end == -1)
            return true;
        return false;
    }

    public void insertFront(int n) {

        if (isFull())
            System.out.println("- Queue is Full -");
        else {
            if (isEmpty()) {
                // inserting first element in the queue
                front = end = 0;
                arr[front] = n;
                display();
            } else {

                if (front == 0 && end != size - 1) {
                    // when there is no room behind FRONT
                    // move front to (size-1)
                    front = size - 1;
                    arr[front] = n;
                } else {
                    // else continue the cyclic nature
                    front--;
                    arr[front] = n;
                }
                display();
            }
        }

    }

    public void deleteFront() {
        if (isEmpty())
            System.out.println("- Queue Underflow -");
        else {
            if (front == size - 1) {
                System.out.println("- Deleted " + arr[front] + " -");
                front = 0;
                display();
            } else if (front == end) {
                // when there is only one element left
                System.out.println("- Deleted " + arr[front] + " -");
                front = end = -1;
                System.out.println("- Queue is Empty -");
            } else {
                System.out.println("- Deleted " + arr[front] + " -");
                front++;
                display();
            }
        }

    }

    public void insertEnd(int n) {
        if (isFull())
            System.out.println("- Queue Overflow -");

        else {
            if (isEmpty()) {

                front = end = 0;
                arr[end] = n;
                display();

            } else if (end == size - 1) {

                end = 0;
                arr[end] = n;
                display();

            } else {

                end++;
                arr[end] = n;
                display();

            }
        }
    }

    public void deleteEnd() {

        if (isEmpty())
            System.out.println("- Queue Underflow -");
        else {
            if (end == 0 && front != size - 1) {

                System.out.println("- Deleted " + arr[end] + " -");
                end = size - 1;
                display();

            } else if (front == end) {

                // when there is only one element left
                System.out.println("- Deleted " + arr[end] + " -");
                front = end = -1;
                System.out.println("- Queue is Empty -");

            } else {
                System.out.println("- Deleted " + arr[end] + " -");
                end--;
                display();
            }
        }

    }

    public void display() {
        if (isEmpty())
            System.out.println("- Queue is Empty -");

        else {
            if (isFull()) {
                System.out.print("Queue -> ");
                for (int i = 0; i < size; i++)
                    System.out.print(arr[i] + ", ");
            }

            else {
                System.out.print("Queue -> ");
                if (end < front) {
                    for (int i = 0; i <= end; i++)
                        System.out.print(arr[i] + ", ");

                    for (int i = front; i < size; i++)
                        System.out.print(arr[i] + ", ");

                } else if (front < end) {

                    for (int i = front; i <= end; i++)
                        System.out.print(arr[i] + ", ");
                } else
                    // when front and end are same
                    System.out.print(arr[front] + ", ");
            }
        }
    }

    public static void main(String[] args) {
        Dequeue deqeue = new Dequeue(5);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\n1. Insert Front" +
                            "\n2. Insert End" +
                            "\n3. Delete Front" +
                            "\n4. Delete End" +
                            "\n5. Display" +
                            "\n6. Exit.");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 6) {
                System.out.println("Final Queue");
                deqeue.display();
                break;
            }
            switch (ch) {
                case 1:
                    System.out.println("Enter element: ");
                    deqeue.insertFront(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Enter element: ");
                    deqeue.insertEnd(sc.nextInt());
                    break;

                case 3:
                    deqeue.deleteFront();
                    break;

                case 4:
                    deqeue.deleteEnd();
                    break;

                case 5:
                    deqeue.display();
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }
}
