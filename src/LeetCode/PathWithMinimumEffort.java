package LeetCode;

public class PathWithMinimumEffort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int minimumEffortPath(int[][] heights) {
		int result = 0;
		int m = heights.length;
		int n = heights[0].length;
		int[][] dp = new int[m][n];
		for(int i = 0;i<m;i++) {
			for(int j = 0 ; j< n ; j++) {
				
			}
		}
		return result;
	}
	
	public static int FindMaxDifference(int[] array) {
		int max = Integer.MIN_VALUE;

		for(int i =0;i<array.length-1;i++) {
			int diff = Math.abs(array[i+1]- array[i]);
			if(diff > max) {
				max = diff;
			}
		}
		return max;
	}

}
