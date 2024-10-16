package trial;

import java.util.ArrayList;



public class KnapsackProblem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = {6,3,4,2}; // Weights of the items
        int[] values = {30,14,16,9}; // Values of the items
        int capacity = 10; // Capacity of the knapsack

        // Find the maximum benefit and the items selected
        KnapsackResult result = knapsack(weights, values, capacity);
        System.out.println("Maximum Benefit: $" + result.maxValue);
        System.out.println("Items selected: " + result.itemsSelected);
	}
	
	public static KnapsackResult knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        for (int i = 0; i <=n; i++) {
        	dp[i][0] = 0;
        }
        
        for (int i = 0 ; i <= capacity; i++) {
        	dp[0][i] = 0;
        }

        for (int i = 1; i <=n ;i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=weights[i-1] && dp[i-1][j - weights[i-1]]+values[i-1] > dp[i-1][j]) {
                    dp[i][j] = dp[i-1][j - weights[i-1]] + values[i-1];
                }
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
	
	static class KnapsackResult {
        int maxValue;
        ArrayList<Integer> itemsSelected;

        public KnapsackResult(int maxValue, ArrayList<Integer> itemsSelected) {
            this.maxValue = maxValue;
            this.itemsSelected = itemsSelected;
        }
    }

}
