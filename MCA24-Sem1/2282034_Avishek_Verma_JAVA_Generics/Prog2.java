import java.util.ArrayList;
import java.util.Scanner;

/*2.  Design the Queue Using Generic Class that can contain any type of data. Implement the
insertion, deletion methods. */

class Queue<T> { // here T can be any data type
    ArrayList<T> que = new ArrayList<>();

    void push(T element) {
        que.add(element);
    }

    void pop() {

        if (que.size() == 0) {
            System.out.println("!! QUEUE Underflow !!");
        } else {
            que.remove(0);
            display();
        }
    }

    void display() {
        System.out.println(que + " Size: " + que.size());
    }
}

public class Prog2 {
    public static void main(String[] args) {
        boolean again = true;

        Queue<Integer> obj = new Queue<>();
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
