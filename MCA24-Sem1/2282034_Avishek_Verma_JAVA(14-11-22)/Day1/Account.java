/*5. Define a class Account to represent a bank account. Include the following members.
Instance Variable: Name of the depositor, Account number, Account type, Balance amount in
the account.
Method: To assign initial values, To deposit an amount, To withdraw an amount after checking
the balance, To display name and balance.
Write a program to test the program for a given number of customers. The program should be
able to search any customer if the account number is provided. */
package Day1;

import java.util.Scanner;

public class Account {

    String name, accType, accNo;
    float balance;
    Scanner sc = new Scanner(System.in);

    public void openAcc() {
        System.out.printf("\nEnter Account No.: ");
        this.accNo = sc.nextLine();
        System.out.printf("\nEnter Account Holder Name: ");
        this.name = sc.nextLine();
        System.out.printf("\nEnter Account Type: ");
        this.accType = sc.nextLine();
        System.out.printf("\nEnter Balance: ");
        this.balance = sc.nextFloat();
    }

    public void displayAcc() {
        System.out.println("Account No.-> " + accNo);
        System.out.println("Account Holder Name-> " + name);
        System.out.println("Account Type-> " + accType);
        System.out.println("Current Balance-> " + balance);
    }

    public void depositMoney() {
        float amount;
        System.out.println("Enter Amount to deposit: ");
        amount = sc.nextFloat();
        balance += amount;
        System.out.println("!! Amount Credited Successfully !!");
    }

    public void withdrawMoney() {
        float amount;
        System.out.println("Enter Amount to Withdraw: ");
        amount = sc.nextFloat();
        if (balance >= amount) {
            balance -= amount;
            System.out.println("!! Amount Debited Successfully !!");
        } else {
            System.out.println("Balance is less than " + amount);
            System.out.println("!! Transaction Failed !!");
        }
    }

    public boolean searchAccount(String accountNo) {
        if (accNo.contains(accountNo)) {
            displayAcc();
            return true;
        } else {

            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many customers? ");
        int n = sc.nextInt();
        Account ac[] = new Account[n];

        for (int i = 0; i < n; i++) {
            ac[i] = new Account();
            ac[i].openAcc();
        }

        while (true) {

            System.out.println(
                    "\n1. Display All A/c details" +
                            "\n2. Search by A/c No." +
                            "\n3. Deposit Money" +
                            "\n4. Withdraw Money" +
                            "\n5. Exit.");
            System.out.println("Enter Your Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 5) {
                System.out.println("Exiting...");
                break;
            }

            switch (ch) {
                case 1:
                    System.out.println("*** Displaying all A/c Details ***");
                    for (int i = 0; i < ac.length; i++) {
                        ac[i].displayAcc();
                    }
                    break;

                case 2:
                    System.out.println("Enter A/c no. to search: ");
                    String accountNo = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < ac.length; i++) {
                        found = ac[i].searchAccount(accountNo);
                        if (found)
                            break;
                    }
                    if (!found)
                        System.out.println("No Account with A/C No. " + accountNo);
                    break;

                case 3:
                    System.out.println("Enter A/c no: ");
                    accountNo = sc.nextLine();
                    found = false;
                    for (int i = 0; i < ac.length; i++) {
                        found = ac[i].searchAccount(accountNo);
                        if (found)
                            ac[i].depositMoney();
                    }
                    if (!found)
                        System.out.println("A/c not found");
                    break;
                case 4:
                    System.out.println("Enter A/c no: ");
                    accountNo = sc.nextLine();
                    found = false;
                    for (int i = 0; i < ac.length; i++) {
                        found = ac[i].searchAccount(accountNo);
                        if (found)
                            ac[i].withdrawMoney();
                    }
                    if (!found)
                        System.out.println("A/c not found");
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        }

        sc.close();
    }

}
