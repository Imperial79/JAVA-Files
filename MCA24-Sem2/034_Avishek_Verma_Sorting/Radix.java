import java.util.Arrays;

public class Radix {

    public int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    public void countSort(int arr[], int pos, int size) {

        int temp, dig;
        int arr2[] = new int[size];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < size; i++) {
            dig = (arr[i] / pos) % 10;
            count[dig]++;
        }

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = size - 1; i >= 0; i--) {
            temp = (arr[i] / pos) % 10;
            arr2[count[temp] - 1] = arr[i];
            count[temp]--;
        }

        for (int i = 0; i < size; i++)
            arr[i] = arr2[i];
    }

    public void sort(int arr[]) {
        int max = getMax(arr);
        int pos = 1;
        while (max > 0) {
            countSort(arr, pos, arr.length);
            pos *= 10;
            max /= 10;
        }
    }

    public void display(int arr[]) {
        System.out.println("Updated Array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Radix radix = new Radix();
        int arr[] = { 5, 4, 2, 22, 1 };
        radix.sort(arr);
        System.out.println("Original Array: " + Arrays.toString(arr));
        radix.display(arr);
    }
}
