
/*
4. An educational institution wishes to maintain a database of its employees. The database is
divided into a number of classes whose hierarchical relationships are shown below. Write all
the classes and defines the methods to create the database and retrieve individual information
as and when needed.
Write a driver program to test the classes:
    Staff (code, name)
    Teacher (subject, publication) is a Staff
    Officer (grade) is a Staff
    Typist (speed) is a Staff
    RegularTypist (remuneration) is a Typist
    CasualTypist (daily wages) is a Typist. 
*/
import java.util.Scanner;

public class Staff {
    int code;
    String name;

    Staff(int code, String name) {
        this.code = code;
        this.name = name;
    }
}

class Teacher extends Staff {
    String subject, publication;

    Teacher(int code, String name, String subject, String publication) {
        super(code, name);
        this.subject = subject;
        this.publication = publication;
    }

    void display() {
        System.out.println("CODE: " + code);
        System.out.println("NAME: " + name);
        System.out.println("SUBJECT: " + subject);
        System.out.println("PUBLICATION: " + publication);
    }
}

class Officer extends Staff {
    int grade;

    Officer(int code, String name, int grade) {
        super(code, name);
        this.grade = grade;
    }

    void display() {
        System.out.println("CODE: " + code);
        System.out.println("NAME: " + name);
        System.out.println("GRADE: " + grade);
    }
}

class Typist extends Staff {
    int speed;

    Typist(int code, String name, int speed) {
        super(code, name);
        this.speed = speed;
    }
}

class RegularTypist extends Typist {
    int remuneration;

    RegularTypist(int code, String name, int speed, int remuneration) {
        super(code, name, speed);
        this.remuneration = remuneration;
    }

    void display() {
        System.out.println("CODE: " + code);
        System.out.println("NAME: " + name);
        System.out.println("SPEED: " + speed);
        System.out.println("REMUNERATION: " + remuneration);
    }
}

class CasualTypist extends Typist {
    int dailyWages;

    CasualTypist(int code, String name, int speed, int dailyWages) {
        super(code, name, speed);
        this.dailyWages = dailyWages;
    }

    void display() {
        System.out.println("CODE: " + code);
        System.out.println("NAME: " + name);
        System.out.println("SPEED: " + speed);
        System.out.println("DAILY WAGES: " + dailyWages);
    }

}

class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------TEACHERS---------------");
        System.out.println("Code: ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Subject: ");
        String sub = sc.nextLine();
        System.out.println("Publication: ");
        String publ = sc.nextLine();
        Teacher th = new Teacher(code, name, sub, publ);
        System.out.println("-----------------------------");

        System.out.println("--------------OFFICER---------------");
        System.out.println("Code: ");
        code = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("Grade: ");
        int grade = sc.nextInt();

        Officer off = new Officer(code, name, grade);
        System.out.println("-----------------------------");

        System.out.println("--------------REGULAR TYPIST---------------");
        System.out.println("Code: ");
        code = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("Speed: ");
        int speed = sc.nextInt();
        System.out.println("Remuneration: ");
        int remuneration = sc.nextInt();

        RegularTypist regTy = new RegularTypist(code, name, speed, remuneration);
        System.out.println("-----------------------------");

        System.out.println("--------------CASUAL TYPIST---------------");
        System.out.println("Code: ");
        code = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("Speed: ");
        speed = sc.nextInt();
        System.out.println("Daily Wages: ");
        int dailyWages = sc.nextInt();

        CasualTypist casTy = new CasualTypist(code, name, speed, dailyWages);
        System.out.println("-----------------------------");

        System.out.println("------------    THE DATA    ------------");
        th.display();
        off.display();
        regTy.display();
        casTy.display();

        sc.close();
    }
}
