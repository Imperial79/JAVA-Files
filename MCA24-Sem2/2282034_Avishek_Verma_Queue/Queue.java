/*
 * 1. Write a program to implement a Queue class (use a list to store the elements of the
Queue). [Implement Queue Overflow and Underflow by Exception]. Write a method to check two Queue are carrying similar elements or not. (Repetition of the elements are not consider)
 */

import java.util.Arrays;
import java.util.Scanner;

class Prog1 {
    int top1 = 0;
    int end1 = -1;
    int top2 = 0;
    int end2 = -1;
    int arr1[];
    int arr2[];

    Prog1(int n) {
        arr1 = new int[n];
        arr2 = new int[n];
    }

    public void push(int n, int stackNo) {
        if (stackNo == 1) {
            if (end1 <= arr1.length - 1) {
                end1++;
                arr1[end1] = n;
            } else
                System.out.println("!! QUEUE OVERFLOW 1 !!");
        } else {

            if (end2 <= arr2.length - 1) {
                end2++;
                arr2[end2] = n;
            } else
                System.out.println("!! QUEUE OVERFLOW 2 !!");
        }

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("!! Elements are same in both the Arrays !!");
        }
    }

    void pop(int stackNo) {
        if (stackNo == 1) {
            // for stack 1
            if (top1 <= end1) {
                System.out.println("POPPED " + arr1[top1]);
                top1++;
            } else
                System.out.println("!! QUEUE 1 UNDERFLOW !!");
        } else {
            // for stack 2
            if (top2 <= end1) {
                System.out.println("POPPED " + arr2[top2]);
                top2++;
            } else
                System.out.println("!! QUEUE 2 UNDERFLOW !!");
        }
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("!! Elements are same in both the Arrays !!");
        }
    }

    public void display() {
        if (end1 > -1) {
            System.out.print("Queue 1 -> ");
            for (int i = top1; i <= end1; i++) {
                System.out.print(arr1[i] + ", ");
            }
        } else {
            System.out.println("!! Queue 1 is Empty !!");
        }
        System.out.println();
        if (end1 > -1) {
            System.out.print("Queue 2 -> ");
            for (int i = top2; i <= end2; i++) {
                System.out.print(arr2[i] + ", ");
            }
        } else {
            System.out.println("!! Queue 2 is Empty !!");
        }
    }

}

public class Queue {
    public static void main(String[] args) {
        Prog1 que = new Prog1(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n1. Push (Queue 1)" +
                            "\n2. Push (Queue 2)" +
                            "\n3. Pop (Queue 1)" +
                            "\n4. Pop (Queue 2)" +
                            "\n5. Display" +
                            "\n6. Exit.");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 6) {
                System.out.println("Final Queue");
                que.display();
                break;
            }

            switch (ch) {
                case 1:
                    System.out.println("- PUSHING INTO QUEUE 1 -");
                    System.out.println("Enter element to push: ");
                    que.push(sc.nextInt(), 1);
                    break;
                case 2:
                    System.out.println("- PUSHING INTO QUEUE 2 -");
                    System.out.println("Enter element to push: ");
                    que.push(sc.nextInt(), 2);
                    break;
                case 3:
                    que.pop(1);
                    break;
                case 4:
                    que.pop(2);
                    break;

                case 5:
                    System.out.println("- DISPLAYING THE QUEUE -");
                    que.display();

                default:
                    break;
            }
        }
        sc.close();
    }
}