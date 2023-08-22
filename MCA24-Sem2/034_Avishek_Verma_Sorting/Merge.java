import java.util.Arrays;

public class Merge {

    void merge(int arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of LeftArray
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy remaining elements of RightArray
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void sort(int arr[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public void display(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int arr[] = { 5, 4, 3, 2, 1 };

        System.out.println("Array before sort -> " + Arrays.toString(arr));

        merge.sort(arr, 0, arr.length - 1);

        System.out.println("Array after sort -> ");
        merge.display(arr);
    }
}
