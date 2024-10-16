package LeetCode;

import java.util.Arrays;

public class CoinChangeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 5;
		int[] coins = { 1, 2, 5 };
		System.out.println(coinChange(coins, amount));
		System.out.print(coinChange2(coins, amount));

	}

	public static int coinChange(int[] coins, int amount) { //without permutation

		int[] tables = new int[amount + 1];
		Arrays.fill(tables, 0);
		tables[0] = 1;
		for(int i = 0 ; i < coins.length;i++) {
			for(int j = coins[i]; j <= amount;j++) {
				tables[j] += tables[j-coins[i]];
			}
		}
		return tables[amount];
	}
	
	public static int coinChange2(int[] coins, int amount) { //with permutation
		int[] dp = new int[amount+1];
		for(int i = 0 ; i < amount+1;i++) {
			dp[i] = 0;
		}
		
		for(int i = 0;i<coins.length;i++) {
			dp[coins[i]]++;
		}
		for(int i = 0 ; i <= amount; i++) {
			for(int j = 0;j<coins.length;j++) {
				if(i - coins[j]>=0) {
					dp[i]+=dp[i-coins[j]];
				}
			}
		}
		return dp[amount];
	}
}
