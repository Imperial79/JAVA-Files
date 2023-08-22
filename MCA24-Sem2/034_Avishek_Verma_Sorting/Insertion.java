import java.util.Arrays;

class Prog2 {
    public void sort(int arr[]) {
        int size = arr.length;

        for (int i = 1; i < size; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

                j = j - 1;
            }
            display(arr);
        }
    }

    public void display(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }
}

public class Insertion {
    public static void main(String[] args) {
        Prog2 insertion = new Prog2();
        int arr[] = new int[] { 5, 4, 3, 2, 1 };
        insertion.sort(arr);

    }
}
