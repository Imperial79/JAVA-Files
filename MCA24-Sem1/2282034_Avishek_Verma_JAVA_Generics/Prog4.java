import java.util.Comparator;

/*4. Write a generic method that computes the Second minimum and Second maximum elements of an array of type T and returns a pair containing the minimum and maximum value. */

class MinMax {

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

        System.out.println(arr[1] + ", " + arr[arr.length - 2]);

    }
}

public class Prog4 {
    public static void main(String[] args) {

        Integer arr[] = new Integer[] { 11, 2, 3, 45 };

        MinMax obj = new MinMax();
        obj.sorted(arr, Comparator.reverseOrder());
    }
}
