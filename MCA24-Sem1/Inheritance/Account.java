import java.util.Scanner;

/*
 6. Assume that a Bank maintains two kinds of accounts for its customers, one called savings
account and the other current account. The savings account provides compound interest and
withdrawal facilities. The current account provides no interest. Current account holders
should maintain balance and if the balance falls below this level, a service charge is imposed.
o Create a class Account that stores customers name, account number and type of the
account. From this derive the classes CurAccount and SavAccount to make them
more specific to their requirements.
- Include the necessary methods in order to achieve the following tasks:
Assign initial values
Accept deposit from a customer and update the balance
Permit withdrawal and update the balance
Compute and deposit interest
Check for the minimum balance, impose penalty, if necessary, and update it.
Display the balance
- Write a program that creates an array of Bank Account and displays a menu that lets a
new account to be created, perform deposit and withdrawal transactions on the basis
of account number, display the balance of account holder for whom the account
number is provided.
 */

class Account {
    public static int min = 500;
    String name;
    int Account_num;
    public float currBalance;
    Scanner sc = new Scanner(System.in);

    public void get_info() {
        System.out.println("Enter Name: ");
        name = sc.nextLine();
        System.out.println("Enter Account Number: ");
        Account_num = sc.nextInt();
        System.out.println("Enter opening Amount (>500): ");
        currBalance = sc.nextFloat();
        if (currBalance < 500) {
            System.out.println("Enter opening Amount (>500): ");
            currBalance = sc.nextFloat();
        }
    }

    public void show() {
        System.out.println("Name:" + name);
        System.out.println("Account_number:" + Account_num);
        System.out.println("Amount:" + currBalance);
    }
}

class CurAccount extends Account {
    float deposit, withdraw, penalty;

    void deposit() {
        System.out.println("Enter Amount to deposit: ");
        deposit = sc.nextFloat();
        show();
        currBalance += deposit;
        System.out.println("Total Amount is " + currBalance);
    }

    void checkBal() {
        if (currBalance < min) {
            System.out.println("!! Amount should be > 500 !!");
            currBalance -= 150;
            System.out.println("Rs. 150 has been debited from your account. Your Current Balance is " + currBalance);
        }
    }

    void withdraw() {
        System.out.println("Enter Amount to withdraw: ");
        withdraw = sc.nextFloat();
        show();

        if (withdraw < currBalance) {
            currBalance -= withdraw;
            System.out.println("Current Balance after withdraw: " + currBalance);
        } else {
            System.out.println("!! Insufficient Balance !!");
        }
        checkBal();
    }
}

class SavAccount extends Account {
    float deposit, withdraw, intrest;

    void deposit() {
        System.out.println("Enter Amount to deposit: ");
        deposit = sc.nextFloat();
        show();
        currBalance += deposit;
        System.out.println("Current Balance: " + currBalance);

    }

    void checkIntrest() {
        intrest = (currBalance * 2) / 100;
        currBalance += intrest;
        System.out.println("Current Balance with intrest is " + currBalance);
    }

    void withdraw() {
        System.out.println("Enter Ammount to withdraw:");
        withdraw = sc.nextFloat();
        show();
        if (withdraw < currBalance) {
            currBalance -= withdraw;
            System.out.println("Current Balance after withdraw: " + currBalance);
        }

        else {
            System.out.println("!! Insufficient Balance !!");
        }
    }
}

class Bank {

    static int ch;

    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        CurAccount ca = new CurAccount();
        SavAccount sav = new SavAccount();

        System.out.println("Choose Account type:");
        System.out.println("1. Current Account:");
        System.out.println("2. Saving Account:");
        ch = sc.nextInt();
        if (ch == 1) {
            ca.get_info();
            ca.checkBal();
            while (count != 4) {

                System.out.println("1.Display\n2.Deposit\n3.Withdraw\n4.Exit");
                System.out.println("Enter Your Coice");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        ca.show();
                        break;
                    case 2:
                        ca.deposit();
                        break;
                    case 3:
                        ca.withdraw();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("!! Invalid Choice !!");
                }

            }

        } else if (ch == 2) {
            sav.get_info();

            while (count != 5) {
                System.out.println("1.Display\n2.Deposit\n3.Withdraw\n4Intrest\n5.Exit");
                System.out.println("Enter Your Coice");
                int cho = sc.nextInt();
                switch (cho) {
                    case 1:
                        sav.show();
                        break;
                    case 2:
                        sav.deposit();
                        break;
                    case 3:
                        sav.withdraw();
                        break;
                    case 4:
                        sav.checkIntrest();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("!! Invalid Choice !!");
                }

            }
        } else {
            System.out.println("!! Invalid Choice !!");
        }
        sc.close();
    }

}