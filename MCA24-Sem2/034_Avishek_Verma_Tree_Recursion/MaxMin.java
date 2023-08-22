import java.util.Arrays;

//  Max-Min using divide and conquer
class Pair {
    int max, min;

    Pair(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

public class MaxMin {

    static void divide(int a[], int low, int high, Pair num) {

        // if only one element
        if (low == high) {
            if (num.min > a[low])
                num.min = a[low];

            if (num.max < a[high])
                num.max = a[high];

            return;
        }

        // if two elements
        if (a.length == 2) {
            if (a[low] < a[high]) {
                num.min = a[low];
                num.max = a[high];
            } else {
                num.max = a[low];
                num.min = a[high];
            }
            return;
        }

        else {
            int mid = (low + high) / 2;
            divide(a, low, mid, num);
            divide(a, mid + 1, high, num);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 1, 4, 98, 67, 2 };

        Pair p = new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);

        divide(arr, 0, arr.length - 1, p);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Maximum element: " + p.max);
        System.out.println("Minimum element: " + p.min);
    }
}
