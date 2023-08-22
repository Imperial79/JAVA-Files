import java.util.Arrays;
import java.util.Comparator;

class ItemValue {
    int profit, weight;

    ItemValue(int p, int w) {
        profit = p;
        weight = w;
    }
}

public class ZeroOneKS {

    double getMaxProfit(ItemValue arr[], int capacity) {

        // sorting the itemvalue array according to profit by weight ratio

        Arrays.sort(arr, new Comparator<ItemValue>() {

            @Override
            public int compare(ItemValue item1, ItemValue item2) {

                if (item1.profit < item2.profit)
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
            }

        }

        return totalProfit;

    }

    public static void main(String[] args) {

        ZeroOneKS knapS = new ZeroOneKS();
        ItemValue arr[] = {
                new ItemValue(10, 30),
                new ItemValue(20, 10),
                new ItemValue(30, 40),
                new ItemValue(40, 20),
        };

        int capacity = 40;

        System.out.println("Total Profit: " + knapS.getMaxProfit(arr, capacity));
    }
}
