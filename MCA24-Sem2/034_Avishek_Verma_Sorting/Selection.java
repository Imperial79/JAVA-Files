import java.util.Arrays;

class Prog1 {

    public void sort(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            display(arr);
        }
    }

    public void display(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }
}

public class Selection {
    public static void main(String[] args) {
        Prog1 selection = new Prog1();
        int arr[] = new int[] { 11, 2, 89, 1, 0, 23 };

        selection.sort(arr);
    }
}