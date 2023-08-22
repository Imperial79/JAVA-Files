
/*1. Write a program that reads in a series of first names and stores them in a LinkedList. Do not store
duplicate names. Allow the user to search for a first name. */
import java.util.LinkedList;
import java.util.Scanner;

public class Prog1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<String> fNames = new LinkedList<>();
        System.out.println("Enter 5 Names: ");
        for (int i = 0; i < 5; i++) {
            String name = sc.nextLine();
            if (!fNames.contains(name)) {
                fNames.add(name);
            } else
                System.out.println("Name Already contains!!");
        }
        System.out.println(fNames);
        System.out.println("Enter Name to Search: ");
        String name = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < fNames.size(); i++) {
            if (fNames.get(i).equals(name)) {
                flag = 1;
                System.out.println(name + " found !!");
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Name " + name + " not found !!");
        }
        sc.close();
    }
}