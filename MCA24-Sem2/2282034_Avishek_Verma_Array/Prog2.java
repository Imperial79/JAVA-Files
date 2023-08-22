import java.util.ArrayList;

/*2. Create a Class BasicSort within that implement three Generic methods that can implement the BuubleSort(), SelectionSort(), InsertionSort() that can sort of any type of data. */
class BasicSort<T> {
    public <T extends Comparable<T>> void bubbleSort(ArrayList<T> arr) {
        T temp;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i).compareTo(arr.get(j)) > 0) {
                    temp = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, temp);
                }
            }
        }

        System.out.println("Sorted Array (bubble sort) = " + arr);

    }

    public <T extends Comparable<T>> void selectionSort(ArrayList<T> arr) {
        T temp;
        int n = arr.size();

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j).compareTo(arr.get(i)) < 0) {
                    min = j;
                }

                temp = arr.get(min);
                arr.set(min, arr.get(i));
                arr.set(i, temp);
            }
        }

        System.out.println("Sorted Array (selection sort) = " + arr);

    }

    public <T extends Comparable<T>> void insertionSort(ArrayList<T> arr) {

        int n = arr.size();
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            T key = arr.get(i);
            while (j >= 0 && arr.get(j).compareTo(key) > 0) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }

        System.out.println("Sorted Array (insertion sort) = " + arr);

    }
}

public class Prog2 {
    public static void main(String[] args) {
        // -------------INTEGER---------
        BasicSort<Integer> sortInt = new BasicSort<>();
        ArrayList<Integer> arrInt = new ArrayList<>();
        arrInt.add(11);
        arrInt.add(2);
        arrInt.add(90);
        arrInt.add(7);
        arrInt.add(1);
        System.out.println("Original Array: " + arrInt);
        sortInt.bubbleSort(arrInt);
        sortInt.selectionSort(arrInt);
        sortInt.insertionSort(arrInt);
        // -------------STRING---------
        BasicSort<Integer> sortStr = new BasicSort<>();
        ArrayList<String> arrStr = new ArrayList<>();
        arrStr.add("Avishek");
        arrStr.add("Vivek");
        arrStr.add("Jacob");
        arrStr.add("Karthik");
        sortStr.bubbleSort(arrStr);
        sortStr.selectionSort(arrStr);
        sortStr.insertionSort(arrStr);
    }
}
