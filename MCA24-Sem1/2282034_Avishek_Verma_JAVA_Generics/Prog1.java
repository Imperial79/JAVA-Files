import java.util.*;

/*1. Design the Stack Using Generic Class that can contain any type of data. Implement the insertion, deletion, peek function. */

class Stack<T> { // here T can be anything
    ArrayList<T> stk = new ArrayList<T>();
    int top;

    Stack() {
        this.top = -1;
    }

    void push(T element) {
        if (top < stk.size()) {
            top++;
            stk.add(element);
            System.out.println(element + " Pushed !!");
        } else
            System.out.println("Stack Overflow");
    }

    void pop() {
        if (top > 0) {
            System.out.println(stk.get(top) + " Popped !!");
            stk.remove(top);
            top--;

        } else
            System.out.println("Stack Overflow");
    }

    void display() {
        System.out.println("Stack----> " + stk);
    }
}

public class Prog1 {

    public static void main(String[] args) {
        boolean again = true;

        Stack<Integer> obj = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while (again) {
            int ch, ele;
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display Stack");
            System.out.println("4. Exit");
            System.out.println("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.println("Enter element to push: ");
                    ele = sc.nextInt();
                    obj.push(ele);
                    break;

                case 2:
                    obj.pop();
                    break;

                case 3:
                    obj.display();
                    break;
                case 4:
                    again = false;
                    break;
                default:
                    System.out.println("!! Invalid choice !!");
            }
        }
        sc.close();
    }
}