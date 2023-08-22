/*
3. Write a program to sort a list of strings using multithreading. Create one of the
threads that take a string as input from the user, another thread that sorts the
strings and finally another thread that displays the sorted list of strings. Each of
the input, sort, and display methods is to be synchronized.
 */

import java.util.Scanner;

class StringList {
    String s[];
    boolean isSorted = false;
    static Scanner sc;

    StringList() {
        s = null;

    }

    synchronized void getData() {
        sc = new Scanner(System.in);
        System.out.print("How many strings? ");
        s = new String[sc.nextInt()];
        System.out.println("Enter the Strings:-");
        for (int i = 0; i < s.length; i++)
            s[i] = sc.next();
    }

    synchronized void sortData() {
        for (int i = 0; i < s.length; i++) {
            int j;
            String t = s[i];
            for (j = i - 1; j >= 0 && (s[j].compareToIgnoreCase(t) > 0); j--)
                s[j + 1] = s[j];
            s[j + 1] = t;
        }
        isSorted = true;
        notify();
    }

    synchronized void displayData() {
        if (!isSorted) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sorted String :-");

        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }
}

class InputStrings extends Thread {
    StringList obj;

    public InputStrings(StringList obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.getData();
    }
}

class SortStrings extends Thread {
    StringList obj;

    public SortStrings(StringList obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.sortData();
    }
}

class DisplayStrings extends Thread {
    StringList obj;

    public DisplayStrings(StringList obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.displayData();
    }
}

public class Prog3 {
    public static void main(String[] args) {
        StringList obj = new StringList();
        new InputStrings(obj).start();
        new SortStrings(obj).start();
        new DisplayStrings(obj).start();
    }
}
