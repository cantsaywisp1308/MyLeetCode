package LeetCode;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 3;
		int[] coins = {2};
		System.out.print(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int c:coins) {
        	for(int i =c; i<= amount; i++) {
        		if(dp[i-c] != Integer.MAX_VALUE) {
        			dp[i] = Math.min(dp[i], 1 + dp[i-c]);
        		}	
        	}
        }
        return dp[amount] == Integer.MAX_VALUE ? - 1: dp[amount];
    }
	
	
}
