
import java.util.ArrayList;

public class Prog8 {
    static ArrayList<Integer> getSubset(ArrayList<Integer> set, int sum) {

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < set.size(); i++) {

            int curEle = set.get(i);

            if (curEle == sum) {
                // if the element is equal to the sum return the element
                arr.add(curEle);
                break;
            }

            if (curEle < sum && set.contains(sum - curEle)) {
                arr.add(curEle);
                arr.add(sum - curEle);
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(3);
        set.add(34);
        set.add(4);
        set.add(12);
        set.add(5);
        set.add(2);

        System.out.println("Original Set: " + set);
        int sum = 9;
        ArrayList<Integer> arr = getSubset(set, sum);

        if (arr.size() > 0)
            System.out.println("True, The subset is " + arr + " with sum " + sum);
        else
            System.out.println("No subset");
    }
}
