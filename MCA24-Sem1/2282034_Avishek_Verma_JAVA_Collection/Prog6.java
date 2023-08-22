import java.util.ArrayList;

/*6. Write a python program to check the number where the difference between every adjacent digit should be 1 using ArrayList. */

public class Prog6 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        a.add(123);
        a.add(256);
        a.add(456);
        a.add(578);
        a.add(678);
        a.add(987);
        a.add(700);
        a.add(1000);

        for (int element : a) {
            int temp = element, rem, flag = 0, i = 0;
            int lastDig = temp % 10;
            int diff;
            while (temp != 0) {
                i++;
                rem = temp % 10;
                diff = lastDig - rem;
                lastDig = rem;
                temp /= 10;
                if (i != 1) {

                    diff = diff == -1 ? 1 : diff;

                    if (diff != 1) {
                        flag = 1;
                        break;
                    }
                }

            }
            if (flag == 0) {
                b.add(element);
            }

        }

        System.out.println(b);

    }

}
