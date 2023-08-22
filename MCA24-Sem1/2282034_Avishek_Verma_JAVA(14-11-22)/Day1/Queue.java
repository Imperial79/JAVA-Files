/*
Create a class Queue to implement queue data structure with constructors. Define suitable
methods for insertion & deletion of elements to & from the queue. Write a program for this,
clearly specifying the overflow & underflow conditions.  
*/
package Day1;

import java.util.Scanner;

class Queue {

    int arr[];
    int top, end, size;

    Queue(int n) {
        this.arr = new int[n];
        this.size = n;
        this.top = 0;
        this.end = -1;
    }

    public void push(int num) {
        if (end >= size - 1) {
            System.out.println("!! Queue Overflow !!");
        } else {
            end++;
            arr[end] = num;
            System.out.println(num + " Inserted | end: " + end);
            display();
        }

    }

    public void pop() {
        if (top >= end) {
            System.out.println("!! Queue Underflow !!");
            top = 0;
            end = -1;
        } else {
            int ele = arr[top];
            top++;
            System.out.println(ele + " Popped | top: " + top);

            display();
        }
    }

    public void display() {
        System.out.print("QUEUE --> ");
        for (int i = top; i <= end; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue stack = new Queue(5);
        int number;

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
                stack.display();
                break;
            }

            switch (ch) {
                case 1:
                    System.out.println("PUSHING TO STACK 1");
                    System.out.println("Enter Number: ");
                    number = sc.nextInt();

                    stack.push(number);
                    break;

                case 2:

                    stack.pop();
                    break;

                case 3:
                    stack.display();
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        }
        sc.close();

    }
}