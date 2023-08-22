/*1. Create a class called Time that has separate data member for hours, minutes and seconds.
Define member functions to perform the following tasks:
to display the time in the format hh: mm: ss.
to add times passed as arguments.
to check which among two times passed as arguments is greater.
Write a program to test the class and its functions. Use constructor to initialize the instance
variables of the class Time.
 */

package Day2;

public class Time {
    int hr, min, sec;

    Time(int hr, int min, int sec) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
    }

    public static void displayTime(Time tm1, Time tm2) {
        System.out.printf("\nTime 1 -> %d : %d : %d", tm1.hr, tm1.min, tm1.sec);
        System.out.printf("\nTime 2 -> %d : %d : %d", tm2.hr, tm2.min, tm2.sec);

        // comparing both the times
        if (tm1.hr > tm2.hr || tm1.hr == tm2.hr && tm1.min > tm2.min
                || tm1.hr == tm2.hr && tm1.min == tm1.min && tm1.sec > tm2.sec) {
            System.out.printf("\nTime 1 is greater (%d:%d:%d)", tm1.hr, tm1.min, tm1.sec);
        } else if (tm1.hr == tm2.hr && tm1.min == tm2.min && tm1.sec == tm2.sec)
            System.out.printf("\nBoth the times are equal");
        else
            System.out.printf("\nTime 2 is greater (%d:%d:%d)", tm2.hr, tm2.min, tm2.sec);

    }

    public static void main(String[] args) {
        Time tm1 = new Time(4, 30, 00);
        Time tm2 = new Time(4, 30, 01);
        displayTime(tm1, tm2);
    }
}