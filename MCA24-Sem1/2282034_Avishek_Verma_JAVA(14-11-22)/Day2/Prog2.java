/*2. Create two classes DM and DB which store the value of distances. DM stores distances in
meters and centimeters and DB in feet and inches. Write a program that can read values for
the class objects and add one object of DM with another object of DB. Use method to carry
out the addition operation. The object that stores the result may be a DM object or a DB
object, depending on the units in which the results are required. The display should be done
in the format of feet and inches or meters and centimeters depending on the object on
display.  */
package Day2;

import java.util.Scanner;

class DM {
    double meter, centimeter;
}

class DB {
    double feet, inches;

    public void add(DM dm, DB db) {
        double d1, d2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distance in meter & centimeter: ");
        dm.meter = sc.nextInt();
        dm.centimeter = sc.nextInt();
        System.out.println("Enter the distance in feet & inches: ");
        db.feet = sc.nextInt();
        db.inches = sc.nextInt();

        d1 = dm.meter + (db.feet / 3.281);
        d2 = dm.centimeter + (db.inches * 2.54);

        System.out.println("Meter + Feet = " + d1);
        System.out.println("Centimeter + Inches = " + d2);
        sc.close();
    }
}

public class Prog2 {
    public static void main(String[] args) {
        DM dm = new DM();
        DB db = new DB();

        db.add(dm, db);

    }
}
