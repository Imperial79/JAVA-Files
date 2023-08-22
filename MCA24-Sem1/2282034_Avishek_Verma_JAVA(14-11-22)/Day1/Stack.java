/*
Create a class Stack that declares a stack and the methods to perform push ( ), pop ( ) and
display() operations on the stack. Create two stacks and write a menu-driven program to
perform operations on the two stacks. Whenever the number of elements in the two stacks
becomes equal, a message should automatically be generated displaying the number of elements
in each stack. 
*/
package Day1;

import java.util.Arrays;
import java.util.Scanner;

class Stack {
    int arr1[];
    int arr2[];
    int size;
    int top1, top2;

    Stack(int n) {
        this.arr1 = new int[n];
        this.arr2 = new int[n];
        this.size = n;
        this.top1 = this.top2 = 0;
    }

    public void push(int num, int stackNo) {

        if (stackNo == 1) {
            if (top1 < size) {
                arr1[top1] = num;
                top1++;

            } else {
                System.out.println("!! Stack_1 overflow !!");
                System.out.println(Arrays.toString(arr1));

            }
        } else {
            if (top2 < size) {
                arr2[top2] = num;
                top2++;

            } else {
                System.out.println("!! Stack_2 overflow !!");
                System.out.println(Arrays.toString(arr2));

            }
        }

        if (top1 == top2) {
            System.out.println("No. of elements in both the stacks are " + (top1));
        }

    }

    public void pop(int stackNo) {

        if (stackNo == 1) {
            if (top1 >= 0) {
                System.out.println("Popped " + arr1[top1]);
                top1--;
                display();
            } else {
                System.out.println("!! Stack 1 Underflow !!");

            }
        } else {
            if (top2 >= 0) {
                System.out.println("Popped " + arr2[top2]);
                top2--;
                display();
            } else {
                System.out.println("!! Stack 2 Underflow !!");

            }
        }

    }

    public void display() {
        System.out.print("Stack 1 --> [ ");
        for (int i = 0; i < top1; i++) {
            System.out.print(arr1[i] + ", ");
        }
        System.out.print(" ]");
        System.out.println();
        System.out.print("Stack 2 --> [ ");
        for (int i = 0; i < top2; i++) {
            System.out.print(arr2[i] + ", ");
        }
        System.out.print(" ]");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack(5);
        int number;

        // int number;

        while (true) {

            System.out.println(
                    "\n1. Push (Stack 1)" +
                            "\n2. Push (Stack 2)" +
                            "\n3. Pop (Stack 1)" +
                            "\n4. Pop (Stack 2)" +
                            "\n5. Display" +
                            "\n6. Exit.");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 6) {
                System.out.println("Final Stack");
                stack.display();
                break;
            }

            switch (ch) {
                case 1:
                    System.out.println("PUSHING TO STACK 1");
                    System.out.println("Enter Number: ");
                    number = sc.nextInt();

                    stack.push(number, 1);
                    break;

                case 2:
                    System.out.println("PUSHING TO STACK 2");
                    System.out.println("Enter Number: ");
                    number = sc.nextInt();

                    stack.push(number, 2);
                    break;

                case 3:

                    stack.pop(1);
                    break;
                case 4:
                    stack.pop(2);
                    break;

                case 5:
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
