import java.util.Comparator;

/*3. Write a Generic Method that can perform the sorting of any type of data. */

class Sorting {

    <E> void sorted(E[] arr, Comparator<E> comp) {
        E temp;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length - 1; j++) {
                if (comp.compare(arr[j], arr[j + 1]) < 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

public class Prog3 {
    public static void main(String[] args) {

        Integer list[] = new Integer[] { 11, 2, 3, 45 };
        String list2[] = new String[] { "cd", "aabbc", "bbcde" };

        Sorting obj = new Sorting();
        obj.sorted(list, Comparator.reverseOrder());
        System.out.println();
        obj.sorted(list2, Comparator.reverseOrder());
    }
}
