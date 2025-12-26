package LeetCode;
import java.util.*;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		System.out.print(climbStairs(n));
	}
	
	public static int climbStairs(int n) {
        int[] steps = {1,2};
        if(n == 1) {
        	return 1;
        }
        return dynamicProgramming(steps, n);
    }
	
	public static int dynamicProgramming(int[] steps, int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, 0);
		for(int i = 0; i < steps.length;i++) {
			dp[steps[i]]++;
		}
		
		for(int i = 0; i<=n;i++) {
			for(int j = 0; j < steps.length;j++) {
				if(i - steps[j]>=0) {
					dp[i] += dp[i-steps[j]];
				}
			}
		}
		return dp[n];
	}

}
