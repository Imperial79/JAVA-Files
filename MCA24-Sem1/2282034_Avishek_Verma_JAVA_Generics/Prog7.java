import java.util.Scanner;

/*7. The Ceasar cipher is a basic encryption technique used by Julius Ceasar to securely communicate with his generals. Each letter is replaced by another letter N position down the English alphabet. For example, for a rotation of 5, the letter &#39;c&#39; would be replaced by an &#39;h&#39;. In case of a &#39;z&#39;, the alphabet rotates and it is transformed into a &#39;d&#39;.Write a methods that return a lambda expression implement a decoder for the Ceasar cipher where N = 5. */

public class Prog7 {

    interface Caesar {
        public void decoder(String line);
    }

    void decode(String line) {
        int n = 5;
        char[] lst = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Caesar c = (str) -> {
            for (char i : line.toCharArray()) {
                for (int j = 0; j < lst.length; j++) {
                    if (i == lst[j]) {
                        if (lst.length < (j + n + 1)) {
                            System.out.print(lst[lst.length - (j + n)]);
                        } else {
                            System.out.print(lst[j + n]);
                        }
                    }
                }
            }
        };

        c.decoder(line);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String line = sc.nextLine();

        Prog7 obj = new Prog7();

        obj.decode(line);

        sc.close();
    }
}
