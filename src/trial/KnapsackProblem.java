package trial;
import java.util.*;

public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = {3, 2, 1, 4, 5}; // Weights of the items
        int[] values = {25, 20, 15, 40, 50}; // Values of the items
        int capacity = 6; // Capacity of the knapsack

        // Find the maximum benefit and the items selected
        KnapsackResult result = knapsack(weights, values, capacity);
        System.out.println("Maximum Benefit: $" + result.maxValue);
        System.out.println("Items selected: " + result.itemsSelected);
	}

	public static KnapsackResult knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        // Find out which items are included
        int w = capacity;
        ArrayList<Integer> itemsSelected = new ArrayList<>();

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                itemsSelected.add(i); // Add the item number to the list
                w -= weights[i - 1]; // Reduce the remaining capacity of the knapsack
            }
        }

        // Return the maximum value and the items selected
        return new KnapsackResult(dp[n][capacity], itemsSelected);
    }

    // Class to represent the result of the knapsack algorithm
    static class KnapsackResult {
        int maxValue;
        ArrayList<Integer> itemsSelected;

        public KnapsackResult(int maxValue, ArrayList<Integer> itemsSelected) {
            this.maxValue = maxValue;
            this.itemsSelected = itemsSelected;
        }
    }
}
