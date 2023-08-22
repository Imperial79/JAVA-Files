import java.util.Arrays;

class Prog3 {
    public int partition(int arr[], int low, int high) {
        int pi = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pi) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;

    }

    public void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public void display(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }
}

public class Quick {
    public static void main(String[] args) {
        Prog3 quick = new Prog3();
        int arr[] = new int[] { 5, 4, 3, 2, 1 };
        quick.sort(arr, 0, arr.length - 1);
        quick.display(arr);
    }
}
