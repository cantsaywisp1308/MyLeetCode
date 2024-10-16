package ICPC;

import java.util.Arrays;

public class CoinChanges { //this one uses combination

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 8;
		int[] coins = {2,3};
		System.out.print(CoinChanges(coins, sum));
	}

	public static long CoinChanges(int[] coin, int sum) {
		long[] tables = new long[sum+1];
		Arrays.fill(tables, 0);
		tables[0] = 1;
		for(int i = 0 ; i < coin.length;i++) {
			for(int j = coin[i]; j <= sum;j++) {
				tables[j] += tables[j-coin[i]];
			}
		}
		return tables[sum];
	}
}