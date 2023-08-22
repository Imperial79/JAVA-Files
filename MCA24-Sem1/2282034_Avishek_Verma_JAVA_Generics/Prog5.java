
/*5. Write the following methods that return a lambda expression performing a specified action:
isOdd(): The lambda expression must return true  if a number is odd or false  if it is even.
isPrime(): The lambda expression must return true if a number is prime or false if it is composite.
isPalindrome(): The lambda expression must return  true if a number is a palindrome or  false if it is not. */

public class Prog5 {

    interface Check {
        public boolean value(int n);
    }

    static boolean isOdd(int n) {

        Check isodd = (num) -> {
            return (num % 2 != 0) ? true : false;
        };
        return isodd.value(n);
    }

    static boolean isPrime(int n) {

        Check isprime = (num) -> {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;

        };
        return isprime.value(n);
    }

    static boolean isPalindrome(int n) {

        Check ispalin = (num) -> {
            int temp = num, rem, rev = 0;
            while (temp != 0) {
                rem = temp % 10;
                rev = rev * 10 + rem;
                temp /= 10;
            }
            if (num == rev)
                return true;
            else
                return false;
        };
        return ispalin.value(n);
    }

    public static void main(String[] args) {
        System.out.println("isOdd: " + isOdd(12));
        System.out.println("isPrime: " + isPrime(2));
        System.out.println("isPalindrome: " + isPalindrome(22022));
    }
}
