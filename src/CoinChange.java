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
        Arrays.fill(dp, -1);
        if(minCoinsNum(coins, coins.length, amount, dp)== Integer.MAX_VALUE) {
        	return -1;
        } else {
        	return minCoinsNum(coins, coins.length, amount, dp);
        }
    }
	
	public static int minCoinsNum(int[] coins, int m, int amount, int[] dp) {
		if(amount == 0) {
			return 0;
		}
		if(dp[amount] != -1) {
			return dp[amount];
		}
		
		int res = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < m; i++) {
			if(coins[i] <= amount) {
				int sub_res = minCoinsNum(coins, m, amount-coins[i], dp);
				if(sub_res != Integer.MAX_VALUE && sub_res+1 < res) {
					res = sub_res+1;
				}
			}
		}
		dp[amount] = res;
		return res;
	}
}
