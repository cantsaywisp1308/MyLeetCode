package ICPC;

import java.util.Arrays;

public class MinimumCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 11;
		int[] coins = {1,2,5};
		System.out.print(minCoins(coins, value));
	}
	
	public static int minCoins(int[] coins, int V) {
		int dp[] = new int[V+1];
		Arrays.fill(dp, -1);
		return minCoinsUtil(coins, coins.length, V, dp);
	}

	 public static int minCoinsUtil(int[] coins, int m, int value, int[] dp) {
		 if(value == 0) {
			 return 0;
		 }
		 if(dp[value] != -1) {
			 return dp[value];
		 }
		 int res = Integer.MAX_VALUE;
		 for(int i = 0; i < m;i++) { //m is the length of array coins
			 if(coins[i] <= value) {
				 int sub_res = minCoinsUtil(coins, m, value-coins[i], dp);
				 if(sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
					 res = sub_res+1;
				 }
			 }
		 }
		 dp[value] = res;
		 return res;
	 }
	 
	 
}
