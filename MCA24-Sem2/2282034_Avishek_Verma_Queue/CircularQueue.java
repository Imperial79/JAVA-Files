import java.util.Scanner;

/*
 * 2. Write a menu driven program to implement a circular queue (use an array to store
the elements of the queue).
You can follow any one of the schemes A circular list with front and rear indices and one position left vacant. Or, A circular list with front and rear indices and an integer variable counting entries
 */

class CiecularQueue {
    int front, end;
    int arr[];

    CiecularQueue(int size) {

        arr = new int[size];
        front = end = -1;
    }

    public void push(int n) {

        if (front == -1 && end == -1) {

            front = end = 0;
            arr[end] = n;
            display();

        } else if (front == 0 && end == arr.length - 1 || end == front - 1) {
            // therefore queue is full
            System.out.println("!! Queue Overflow !!");
        } else {
            if (end == arr.length - 1 && front > 0) {
                // back to 0 when queue gets full and front is ahead of 0
                end = 0;
                arr[end] = n;
            } else {
                if (front == -1)
                    front++;
                end++;
                arr[end] = n;
            }
            display();
        }
    }

    public void pop() {
        if (front != -1 && end != -1) {
            if (front == end) {
                front = -1;
                end = -1;
            } else {
                if (front == arr.length - 1 && end >= 0) {
                    front = 0;
                    System.out.println("POPPED " + arr[front]);
                } else {
                    System.out.println("POPPED " + arr[front]);
                    front++;
                }

            }
            display();
        } else
            System.out.println("!! Queue Underflow !!");

    }

    void display() {
        if (front == -1 && end == -1)
            System.out.println("!! Queue is Empty !!");
        else {
            System.out.print("QUEUE -> ");
            if (front <= end) {
                for (int i = front; i <= end; i++) {
                    System.out.print(arr[i] + ", ");
                }
            } else if (end < front) {
                for (int i = 0; i <= end; i++) {
                    System.out.print(arr[i] + ", ");
                }
                for (int i = front; i < arr.length; i++) {
                    System.out.print(arr[i] + ", ");
                }
            }
        }

    }

}

public class CircularQueue {
    public static void main(String[] args) {
        CiecularQueue cQue = new CiecularQueue(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n1. Push" +
                            "\n2. Pop" +
                            "\n3. Display" +
                            "\n4. Exit.");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 4) {
                System.out.println("Final Queue");
                cQue.display();
                break;
            }
            switch (ch) {
                case 1:
                    System.out.println("Enter: ");
                    cQue.push(sc.nextInt());
                    break;
                case 2:
                    cQue.pop();
                    break;
                case 3:
                    cQue.display();
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }
}
