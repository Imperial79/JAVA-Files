/*1. Create a Class Search within that implement two Generic method LinearSearch(), BinarySearch(). Test your program for different data. */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Search<T> {
    public void linearSearch(ArrayList<T> arr, T key) {
        int flag = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (key.equals(arr.get(i))) {
                System.out.println(key + " is present at index " + i);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println(key + " was not found !!");
        }
    }

    public <T extends Comparable<T>> void binarySearch(ArrayList<T> arr, T key) {
        int first = 0, mid = 0, last = arr.size() - 1, flag = 0;
        arr.sort(Comparator.naturalOrder());

        mid = (first + last) / 2;

        while (first <= last) {

            if (arr.get(mid).compareTo(key) < 0) {
                // if the search key is greater than middle element
                // then the serach area shift to right half of the array
                first = mid + 1;
            } else if (arr.get(mid).compareTo(key) == 0) {
                System.out.println(key + " was found at index " + mid);
                flag = 1;
                break;
            } else {
                // if the search key is less than middle element
                // then the serach area shift to left half of the array
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (flag == 0) {
            System.out.println(key + " not found !!");
        }
    }
}

public class Prog1 {
    public static void main(String[] args) {

        Search<Integer> searchInt = new Search<>();

        Scanner sc = new Scanner(System.in);
        // -------------INTEGER---------
        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt.add(10);
        arrInt.add(15);
        arrInt.add(98);
        arrInt.add(56);
        arrInt.add(90);
        arrInt.add(101);

        System.out.println("Enter the key to search (Integer): ");
        Integer key = sc.nextInt();
        System.out.println("Available List = " + arrInt);
        searchInt.linearSearch(arrInt, key);
        searchInt.binarySearch(arrInt, key);

        // -------------STRING---------
        ArrayList<String> arrStr = new ArrayList<>();
        Search<String> searchStr = new Search<>();
        arrStr.add("Avishek");
        arrStr.add("Vivek");
        arrStr.add("Jacob");
        arrStr.add("Karthik");
        System.out.println("Available List (String) = " + arrStr);
        System.out.println("Enter the key (String): ");
        String key2 = sc.next();
        searchStr.linearSearch(arrStr, key2);
        searchStr.binarySearch(arrStr, key2);
        sc.close();
    }
}