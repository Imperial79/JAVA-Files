import java.util.Arrays;

public class Heap {

    public void maxHeapify(int arr[], int size, int i) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[root])
            root = left;
        if (right < size && arr[right] > arr[root])
            root = right;

        if (root != i) {
            int temp = arr[i];
            arr[i] = arr[root];
            arr[root] = temp;

            maxHeapify(arr, size, root);
        }
    }

    public void sort(int arr[], int size) {

        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }

    }

    public void display(int arr[]) {
        System.out.println("Updated Array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        Heap heap = new Heap();

        System.out.println("Original Array: " + Arrays.toString(arr));
        heap.sort(arr, arr.length);
        heap.display(arr);
    }
}
