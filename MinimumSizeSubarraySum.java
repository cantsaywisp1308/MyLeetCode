package LeetCode;

import java.util.*;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,2,4,3};
		int target = 7;
		System.out.print(minSubArrayLen(target, nums));
	}

	public static int minSubArrayLen(int target, int[] nums) {
//		int[][] dp = new int[nums.length][nums.length];
//		for (int i = 0; i < nums.length; i++) {
//			dp[i][i] = nums[i];
//		}
//		int min = Integer.MAX_VALUE;
//		for (int i = 0; i < dp.length; i++) {
//			if (dp[i][i] == target) {
//				return 1;
//			} else {
//				for (int j = i+1; j < dp[i].length; j++) {
//					dp[i][j] = dp[i][j - 1] + nums[j];
//					if (dp[i][j] == target) {
//						int length = j - i + 1;
//						if (length < min) {
//							min = length;
//							break;
//						}
//					}
//				}
//			}
//		}
//		if(min == Integer.MAX_VALUE) {
//			min = 0;
//		}
//		return min; //18/21 cases
		
		int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
		while(right < nums.length) {
			sum+=nums[right];
			while(sum >= target) {
				min = Math.min(right - left +1, min);
				sum -= nums[left];
				left++;
			}
			right++;
			
		}
		if(min == Integer.MAX_VALUE) {
			min = 0;
		}
		return min;
	}
	
	public static int sum(int[] nums, int start, int end) {
		int sum = 0;
		for(int i = start; i<=end;i++) {
			sum += nums[i];
		}
		return sum;
	}
	

}
