import java.util.Arrays;
import java.util.Comparator;

class ItemValue {
    int profit, weight;

    ItemValue(int p, int w) {
        profit = p;
        weight = w;
    }
}

public class FractionalKS {

    static double getMaxProfit(ItemValue arr[], int capacity) {

        // sorting the itemvalue array according to profit by weight ratio
        Arrays.sort(arr, new Comparator<ItemValue>() {

            @Override
            public int compare(ItemValue item1, ItemValue item2) {
                double a = item1.profit / item1.weight;
                double b = item2.profit / item2.weight;

                if (a < b)
                    return 1;
                return -1;

            }

        });

        double totalProfit = 0.0;

        for (ItemValue i : arr) {
            int currWeight = i.weight;
            int currProfit = i.profit;

            if (capacity - currWeight >= 0) {

                // the whole thing will go as there is enough space
                capacity -= currWeight;
                totalProfit += currProfit;
            } else {
                // taking the fraction for the limited space
                double fraction = (double) capacity / (double) currWeight;

                totalProfit += currProfit * fraction;
                capacity = (int) (capacity - (currWeight * fraction));
                break;
            }
        }

        return totalProfit;

    }

    public static void main(String[] args) {
        // ItemValue arr[] = {
        // new ItemValue(60, 10),
        // new ItemValue(100, 20),
        // new ItemValue(120, 30),
        // };

        ItemValue arr[] = {
                new ItemValue(60, 10),
                new ItemValue(100, 20),
                new ItemValue(120, 30),
        };

        int capacity = 50;

        System.out.println("Total Profit: " + getMaxProfit(arr, capacity));
    }
}
