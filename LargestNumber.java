package LeetCode;

import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,30,34,5,9};
		System.out.print(largestNumber(nums));
	}
	
	public static String largestNumber(int[] nums) {
		String result = "";
		String[] s = new String[nums.length];
		for(int i = 0; i< nums.length;i++) {
			s[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(s,(a,b)-> (b+a).compareTo(a+b));
		return s[0].equals("0") ? "0": String.join("", s);
	}
	

}
