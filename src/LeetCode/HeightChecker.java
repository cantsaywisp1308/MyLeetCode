package LeetCode;

import java.util.Arrays;

public class HeightChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1,1,4,2,1,3};
		System.out.print(heightChecker(heights));
	}

	public static int heightChecker(int[] heights) {
		int changes = 0;
		int[] newArray = new int[heights.length];
		for(int i = 0; i < heights.length;i++) {
			newArray[i] = heights[i];
		}
		Arrays.sort(newArray);
		for(int i = 0; i < heights.length;i++) {
			if(heights[i] != newArray[i]) {
				changes++;
			}
		}
		return changes;
	}
}
