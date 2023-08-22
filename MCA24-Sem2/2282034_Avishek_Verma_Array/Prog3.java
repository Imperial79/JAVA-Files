import java.util.ArrayList;

/*3. Write a Generic method that computes the Second minimum and Second maximum elements of an array of type T and returns a pair containing the minimum and maximum value. */

class Second<T> {
    public <T extends Comparable<T>> ArrayList<T> minMax(ArrayList<T> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i).compareTo(arr.get(j)) > 0) {
                    T temp = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, temp);
                }
            }
        }
        ArrayList<T> arrlst = new ArrayList<>();
        arrlst.add(arr.get(0));
        arrlst.add(arr.get(arr.size() - 1));
        return arrlst;
    }
}

public class Prog3 {
    public static void main(String[] args) {

        // ----------------- INTEGER --------------------
        ArrayList<Integer> arrInt = new ArrayList<>();
        Second<Integer> secondInt = new Second<>();
        arrInt.add(11);
        arrInt.add(2);
        arrInt.add(90);
        arrInt.add(7);
        arrInt.add(1);
        System.out.println("Original Array: " + arrInt);
        System.out.println("Minimum and Maximum Elements - " + secondInt.minMax(arrInt));

        // -------------STRING---------
        ArrayList<String> arrStr = new ArrayList<>();
        Second<Integer> secondStr = new Second<>();
        arrStr.add("Avishek");
        arrStr.add("Vivek");
        arrStr.add("Jacob");
        arrStr.add("Karthik");
        arrStr.add("Rohan");
        System.out.println("Original Array: " + arrStr);
        System.out.println("Minimum and Maximum Elements - " + secondInt.minMax(arrStr));
    }
}
