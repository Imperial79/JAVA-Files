/*
 * 7. Create a program with multi-dimensional List to store customer details (customerId,
customerName, customerCity).
This program to search the customer based on the customerName from a given array.
Note: use Binary search and Insertion sort algorithm.
 Create a constructor to initialize size of customer details for five customers.
 Create customer method which takes the array of customer elements (sorted as a
customerName).
 Create a method to getCustomer(customerId) method which will return the customer
details as a List.
 Create a method to sortCustomer() method which will return the array in a sorted
order based on customer city.
 */

import java.util.Scanner;

class Customer {
    String custDetails[][];

    Customer() {
        custDetails = new String[3][3];
    }

    void setCustomer() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < custDetails.length; i++) {
            System.out.println("<- Add Details of customer [" + (i + 1) + "] ->");
            System.out.println("Enter ID: ");
            custDetails[i][0] = sc.nextLine();
            System.out.println("Enter Name: ");
            custDetails[i][1] = sc.nextLine();
            System.out.println("Enter City: ");
            custDetails[i][2] = sc.nextLine();
        }
        sc.close();
    }

    void getCustomer(String custId) {
        for (int i = 0; i < custDetails.length; i++) {
            for (int j = 0; j < custDetails[0].length; j++) {
                System.out.print(custDetails[i][j] + " ");
            }
            System.out.println();
        }
    }

    void sortCustomer() {
        String x[];
        int j;
        for (int i = 1; i < custDetails.length; i++) {
            x = custDetails[i];
            for (j = i - 1; j >= 0 && x[2].compareTo(custDetails[j][2]) < 0; j--)
                custDetails[j + 1] = custDetails[j];
            custDetails[j + 1] = x;
        }

        for (int i = 0; i < custDetails.length; i++) {
            for (int k = 0; k < custDetails[0].length; k++) {
                System.out.print(custDetails[i][k] + " ");
            }
            System.out.println();
        }
    }

    void searchCustomer(String key) {
        int l = 0, h = custDetails.length - 1, m = (h + l) / 2;
        int flag = 0;
        while (l <= h) {
            if (custDetails[m][1].compareTo(key) == 0) {
                flag = 1;
                break;
            } else if (key.compareTo(custDetails[m][1]) < 0)
                h = m - 1;
            else
                l = m + 1;
            m = (h + l) / 2;
        }
        if (flag == 0)
            System.out.println("Name not found !!");
        else
            System.out.println("Name found");
    }
}

public class Prog7 {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setCustomer();
        customer.getCustomer("");

        System.out.println("-----------SORTED BY CITY--------------");
        customer.sortCustomer();

        System.out.println("Enter name to search: ");
        Scanner sc = new Scanner(System.in);

        String key = sc.nextLine();
        customer.searchCustomer(key);

        sc.close();
    }
}
