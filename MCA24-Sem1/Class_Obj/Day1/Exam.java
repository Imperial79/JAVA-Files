/*4. The annual examination results of N students are tabulated as follows:
 Roll No. Subject 1 Subject 2 Subject 3

 Write a program to read the data and determine the following:
(a) Total marks obtain by each student
(b) The highest marks in each subject and the roll no of the student who secured it
(c) The student who obtained the highest total marks
 */
package Day1;

import java.util.Scanner;

class Student {
    int roll, sub1, sub2, sub3;

    Student(int roll, int sub1, int sub2, int sub3) {
        this.roll = roll;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }

    public static void totalMarks(Student stud[]) {
        int total, maxTotal = 0, maxRoll = 0;
        for (int i = 0; i < stud.length; i++) {
            total = 0;
            total = stud[i].sub1 + stud[i].sub2 + stud[i].sub3;
            if (maxTotal < total) {
                maxTotal = total;
                maxRoll = stud[i].roll;
            }
            System.out.println("Student " + stud[i].roll + " scored " + total);
        }
        System.out.println("Student " + maxRoll + " scored highest marks " + maxTotal);
    }

    public static void highestMarks(Student stud[]) {
        int maxSub1 = 0, maxSub2 = 0, maxSub3 = 0;
        int maxRollSub1 = 0, maxRollSub2 = 0, maxRollSub3 = 0;

        for (int i = 0; i < stud.length; i++) {
            if (maxSub1 < stud[i].sub1) {
                maxSub1 = stud[i].sub1;
                maxRollSub1 = stud[i].roll;
            }
            if (maxSub2 < stud[i].sub2) {
                maxSub2 = stud[i].sub2;
                maxRollSub2 = stud[i].roll;
            }
            if (maxSub3 < stud[i].sub3) {
                maxSub3 = stud[i].sub3;
                maxRollSub3 = stud[i].roll;
            }

        }
        System.out.printf("\nHighest Scorers subject wise\n");
        System.out.printf("\n===================================\n");
        System.out.printf("\nRoll: %d | Subject 1: %d", maxRollSub1, maxSub1);
        System.out.printf("\nRoll: %d | Subject 2: %d", maxRollSub2, maxSub2);
        System.out.printf("\nRoll: %d | Subject 3: %d", maxRollSub3, maxSub3);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("No. of students? ");
        int n = sc.nextInt();

        Student stud[] = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("\n======= STUDENT %d==========\n", i + 1);
            System.out.println("Enter roll: ");
            int roll = sc.nextInt();
            System.out.println("Enter marks of 3 subs: ");
            int sub1 = sc.nextInt();
            int sub2 = sc.nextInt();
            int sub3 = sc.nextInt();
            stud[i] = new Student(roll, sub1, sub2, sub3);
        }
        Student.totalMarks(stud);
        Student.highestMarks(stud);

        sc.close();
    }

}
