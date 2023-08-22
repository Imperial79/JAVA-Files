import java.util.Scanner;

class StackOverflowException extends Exception {
    StackOverflowException() {
        super("Stack Overflow");
    }
}

class StackUnderflowException extends Exception {
    StackUnderflowException() {
        super("Stack Underflow");
    }
}

public class MyStack {
    int arr[];
    int size;
    int top;

    MyStack(int n) {
        this.arr = new int[n];

        this.size = n;
        this.top = 0;
    }

    public void push(int num) {

        try {
            if (top < size) {
                arr[top] = num;
                top++;
                System.out.println("Inserted " + num);
            } else {
                throw new StackOverflowException();
            }
        } catch (StackOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pop() {

        try {
            if (top > 0) {
                System.out.println("Popped " + arr[top - 1]);
                top--;
                display();
            } else {
                throw new StackUnderflowException();

            }
        } catch (StackUnderflowException e) {
            System.out.println(e.getMessage());
        }

    }

    public void display() {
        System.out.print("Stack --> ");
        for (int i = 0; i < top; i++) {
            System.out.print(arr[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack(5);
        int number;

        while (true) {

            System.out.println(
                    "\n1. Push " +
                            "\n2. Pop" +
                            "\n3. Display" +
                            "\n4. Exit.");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            if (ch == 4) {
                System.out.println("Final MyStack");
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
