import java.util.*;

public class knapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(scanner.nextFloat(), scanner.nextFloat());
        }
        float limit = scanner.nextFloat();
        float result = knapsack(n, limit, items);
        System.out.println("Maximum profit is:-" + fixed + setprecision(2) + result + endl);
    }

    public static float knapsack(int n, float limit, Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble(Item::getProfit));
        float maxProfit = 0.0f;
        for (int i = 0; i < n; i++) {
            if (items[i].getWeight() <= limit) {
                maxProfit += items[i].getProfit();
                limit -= items[i].getWeight();
            } else {
                maxProfit += (items[i].getProfit() / items[i].getWeight()) * limit;
                break;
            }
        }
        return maxProfit;
    }

    private static class Item {
        private float weight;
        private float profit;

        public Item(float weight, float profit) {
            this.weight = weight;
            this.profit = profit;
        }

        public float getWeight() {
            return weight;
        }

        public float getProfit() {
            return profit;
        }
    }
}