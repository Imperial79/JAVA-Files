
/*
An educational institution wishes to maintain a database of its employees. The database is
divided into a number of classes whose hierarchical relationships are shown below. Write all
the classes and defines the methods to create the database and retrieve individual information
as and when needed.
Write a driver program to test the classes.
Staff (code, name)
Teacher (subject, publication) is a Staff
Officer (grade) is a Staff
Typist (speed) is a Staff
RegularTypist (remuneration) is a Typist
CasualTypist (daily wages) is a Typist.
*/
import java.util.Scanner;

class Staff {
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
        int ch = 0, f = 0, i, n, code, speed, remuneration, dailywages;
        String name, sub, publ;
        Scanner sc = new Scanner(System.in);
        Teacher a[] = new Teacher[1];
        Officer b[] = new Officer[1];
        RegularTypist c[] = new RegularTypist[1];
        CasualTypist d[] = new CasualTypist[1];
        while (ch < 5) {
            System.out.println("1. Teacher\n2. Officer\n3. Regular Typist\n4. Casual Typist\n5. Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the no. of entries = ");
                    n = sc.nextInt();
                    a = new Teacher[n];
                    for (i = 0; i < n; i++) {
                        System.out.println("Code: ");
                        code = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Name: ");
                        name = sc.nextLine();
                        System.out.println("Subject: ");
                        sub = sc.nextLine();
                        System.out.println("Publication: ");
                        publ = sc.nextLine();
                        a[i] = new Teacher(code, name, sub, publ);
                    }
                    break;
                case 2:
                    System.out.println("Enter the no. of entries = ");
                    n = sc.nextInt();
                    b = new Officer[n];
                    for (i = 0; i < n; i++) {
                        System.out.println("Code: ");
                        code = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Name: ");
                        name = sc.nextLine();
                        System.out.println("Grade: ");
                        int grade = sc.nextInt();
                        b[i] = new Officer(code, name, grade);
                    }
                    break;
                case 3:
                    System.out.println("Enter the no. of entries = ");
                    n = sc.nextInt();
                    c = new RegularTypist[n];
                    for (i = 0; i < n; i++) {
                        System.out.println("Code: ");
                        code = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Name: ");
                        name = sc.nextLine();
                        System.out.println("Speed: ");
                        speed = sc.nextInt();
                        System.out.println("Remuneration: ");
                        remuneration = sc.nextInt();
                        c[i] = new RegularTypist(code, name, speed, remuneration);
                    }
                    break;
                case 4:
                    System.out.println("Enter the no. of entries = ");
                    n = sc.nextInt();
                    d = new CasualTypist[n];
                    for (i = 0; i < n; i++) {
                        System.out.println("Code: ");
                        code = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Name: ");
                        name = sc.nextLine();
                        System.out.println("Speed: ");
                        speed = sc.nextInt();
                        System.out.println("Daily Wages: ");
                        dailywages = sc.nextInt();
                        d[i] = new CasualTypist(code, name, speed, dailywages);
                    }
                    break;
                default:
                    System.out.println("Exit");
            }
        }
        System.out.println("What do u want to search?");
        System.out.println("1. Teacher\n2. Officer\n3. Regular Typist\n4. Casual Typist");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("Enter the code = ");
                code = sc.nextInt();
                for (i = 0; i < a.length; i++) {
                    if (a[i].code == code) {
                        a[i].display();
                        f = 0;
                        break;
                    } else
                        f = 1;
                }
                if (f == 1)
                    System.out.println("Wrong Code.");
                break;
            case 2:
                System.out.println("Enter the code = ");
                code = sc.nextInt();
                for (i = 0; i < b.length; i++) {
                    if (b[i].code == code) {
                        b[i].display();
                        f = 0;
                        break;
                    } else
                        f = 1;
                }
                if (f == 1)
                    System.out.println("Wrong Code.");
                break;
            case 3:
                System.out.println("Enter the code = ");
                code = sc.nextInt();
                for (i = 0; i < c.length; i++) {
                    if (c[i].code == code) {
                        c[i].display();
                        f = 0;
                        break;
                    } else
                        f = 1;
                }
                if (f == 1)
                    System.out.println("Wrong Code.");
                break;
            case 4:
                System.out.println("Enter the code = ");
                code = sc.nextInt();
                for (i = 0; i < d.length; i++) {
                    if (d[i].code == code) {
                        d[i].display();
                        f = 0;
                        break;
                    } else
                        f = 1;
                }
                if (f == 1)
                    System.out.println("Wrong Code.");
                break;
            default:
                System.out.println("Wrong Choice");
        }
        sc.close();
    }
}