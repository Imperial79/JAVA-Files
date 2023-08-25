import java.util.Scanner;

interface Department {

    abstract void getDeptData();
}

class Hostel {
    Scanner sc = new Scanner(System.in);
    String hostelName, hostelLocation;
    int numberOfRooms;

    public void getData() {
        System.out.println("Enter hostel name: ");
        this.hostelName = sc.nextLine();
        System.out.println("Enter hostel location: ");
        this.hostelLocation = sc.nextLine();
        System.out.println("Enter number of rooms: ");
        this.numberOfRooms = sc.nextInt();
    }

    public void display() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Hostel Location: " + hostelLocation);
        System.out.println("No. of Rooms: " + numberOfRooms);
    }
}

class Student extends Hostel implements Department {
    Scanner sc = new Scanner(System.in);
    String studentName, regdNo, electiveSubject;
    public String deptName = "", deptHead = "";
    float avgMark;

    void getStudentName() {
        System.out.println("Student : " + studentName);
    }

    String getStudentRegNo() {
        return regdNo;
    }

    void getElectiveSubject() {
        System.out.println("Elective Subject : " + electiveSubject);
    }

    void getAvgMarks() {
        System.out.println("Average Marks : " + avgMark);
    }

    public void getDetpName() {
        System.out.println("Department Name : " + deptName);
    }

    public void getDetpHead() {
        System.out.println("Department Head : " + deptHead);
    }

    public void getStudentData() {
        System.out.println("Enter Student Name: ");
        studentName = sc.nextLine();
        System.out.println("Enter Registration No: ");
        regdNo = sc.nextLine();
        System.out.println("Enter Elective Subject: ");
        electiveSubject = sc.nextLine();
        System.out.println("Enter Average Marks : ");
        this.avgMark = sc.nextFloat();
        getDeptData();
    }

    @Override
    public void getDeptData() {
        sc.nextLine();
        System.out.println("Enter Dept. Head: ");
        deptHead = sc.nextLine();
        System.out.println("Enter Dept. Name: ");
        deptHead = sc.nextLine();
    }

    void migrate() {
        System.out.println("Enter new Dept. Name: ");
        deptName = sc.nextLine();
        System.out.println("Enter new Dept. Head: ");
        deptHead = sc.nextLine();
    }

    public void showData() {
        getStudentName();
        System.out.println(" Student Registration No is : " + getStudentRegNo());
        getElectiveSubject();
        getAvgMarks();
        getDetpName();
        getDetpHead();
    }

}

public class Prog4 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Student[] st = new Student[100];
            int sno = 0;
            String rno;
            int ch;
            boolean b;
            while (true) {
                System.out.println("\n 1. Admit a student");
                System.out.println(" 2. Migrate a student");
                System.out.println(" 3. Display");
                System.out.println(" 4. Exit");
                System.out.println(" 5. Enter Your Choice");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        st[sno] = new Student();
                        st[sno++].getStudentData();
                        break;
                    case 2:
                        System.out.println("Enter Registration no : ");
                        rno = sc.next();
                        b = false;
                        for (int i = 0; i < sno; i++) {
                            if (st[i].getStudentRegNo().equals(rno)) {
                                b = true;
                                st[0].migrate();
                                break;
                            }
                        }
                        if (b == false) {
                            System.out.println("Student Not Found");
                        }
                        break;
                    case 3:
                        System.out.println("Enter Registration no : ");
                        rno = sc.next();
                        b = false;
                        for (int i = 0; i < sno; i++) {
                            if (st[i].getStudentRegNo().equals(rno)) {
                                b = true;
                                st[0].showData();
                                break;
                            }
                        }
                        if (b == false) {
                            System.out.println("Student Not Found");
                        }
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("--Invalid Entry--");
                }

            }
            // sc.close();
        }
    }

}
