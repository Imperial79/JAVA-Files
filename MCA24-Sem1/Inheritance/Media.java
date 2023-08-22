import java.util.Scanner;

/*
 5. Consider an example of book shop which sells books & video tapes. It’s modeled by Book &
Tape classes. These two classes are inherited from the abstract class called Media. The Media
class has common data members such as title & publication. The Book class has data
member for storing a no. of pages in a book & Tape class has the playing time in a tape. Each
class will have method such as read ( ) & show ( ). Write a program that models this class
hierarchy & processes objects using reference to base class only.
 */

abstract class Media {
    String title;
    String publication;

    Media(String title, String publication) {
        this.title = title;
        this.publication = publication;
    }
}

class Book extends Media {
    int pages;
    Scanner sc = new Scanner(System.in);

    Book(String title, String publication) {
        super(title, publication);
        // this.pages = pages;
    }

    void read() {

        System.out.println("No. of Pages: ");
        pages = sc.nextInt();
    }

    void show() {
        System.out.println("BOOK TITLE: " + title);
        System.out.println("BOOK PUBLICATION: " + publication);
        System.out.println("NO. OF PAGES: " + pages);
    }
}

class Tape extends Media {
    int playTime;
    Scanner sc = new Scanner(System.in);

    Tape(String title, String publication) {
        super(title, publication);
        // this.playTime = playTime;
    }

    void read() {
        System.out.println("Play Time of Tape: ");
        playTime = sc.nextInt();
    }

    void show() {
        System.out.println("BOOK TITLE: " + title);
        System.out.println("BOOK PUBLICATION: " + publication);
        System.out.println("PLAYTIME OF TAPES: " + playTime);
    }
}

class MediaTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Book Title: ");
        String title = sc.nextLine();
        System.out.println("Book Publication: ");
        String publication = sc.nextLine();
        Book bk = new Book(title, publication);
        bk.read();
        // ----------------
        System.out.println("Tape Title: ");
        title = sc.nextLine();
        System.out.println("Tape Publication: ");
        publication = sc.nextLine();
        Tape tp = new Tape(title, publication);
        tp.read();

        tp.show();
        bk.show();

        sc.close();
    }
}
