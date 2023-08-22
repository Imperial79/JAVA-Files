import java.util.Arrays;
import java.util.Scanner;

/*1. Write a program to implement a Stack class (use a Array to store the elements of the stack).
[Implement Stack Overflow and Underflow by user defined Exception]. Write a method to check two stack are carrying similar elements or not.(Repetition of the elements are not consider)
 */

class Stack {
    int arr1[];
    int arr2[];
    int size;
    int top1, top2;

    Stack(int n) {
        this.arr1 = new int[n];
        this.arr2 = new int[n];
        this.size = n;
        this.top1 = this.top2 = -1;
    }

    public void push(int num, int stackNo) {

        if (stackNo == 1) {
            if (top1 < size - 1) {
                top1 += 1;
                arr1[top1] = num;

            } else {
                System.out.println("!! Stack (1) overflow !!");
                System.out.println(Arrays.toString(arr1));

            }
        } else {
            if (top2 < size - 1) {
                top2 += 1;
                arr2[top2] = num;

            } else {
                System.out.println("!! Stack (2) overflow !!");
                System.out.println(Arrays.toString(arr2));

            }
        }

        if (top1 == top2) {
            System.out.println("No. of elements in both the stacks are " + (top1));
        }
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("!! Both the Stacks have same elements !!");
        }

    }

    public void pop(int stackNo) {

        if (stackNo == 1) {
            if (top1 != -1) {
                System.out.println("POPPED -> " + arr1[top1]);
                top1--;
                display();
            } else {
                System.out.println("!! Stack (1) UNDERFLOW !!");

            }
        } else {
            if (top2 >= 0) {
                System.out.println("POPPED -> " + arr2[top2]);
                top2--;
                display();
            } else {
                System.out.println("!! Stack (2) UNDERFLOW !!");

            }
        }

    }

    public void display() {
        System.out.print("Stack 1 --> [ ");
        for (int i = 0; i <= top1; i++) {
            System.out.print(arr1[i] + ", ");
        }
        System.out.print(" ]");
        System.out.println();
        System.out.print("Stack 2 --> [ ");
        for (int i = 0; i <= top2; i++) {
            System.out.print(arr2[i] + ", ");
        }
        System.out.print(" ]");

    }

}

public class Prog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack(5);
        int number;

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
