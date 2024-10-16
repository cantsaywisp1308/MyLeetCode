package ICPC;

import java.util.Arrays;

public class Connect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {12,34,567,890};
		System.out.print(Connect(nums));
	}
	
	public static long Connect(int[] nums) {
		long result =0;
		String[] s = new String[nums.length];
		for(int i = 0;i<nums.length;i++) {
			s[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(s, (a,b)-> (b+a).compareTo(a+b));
		for(int i = 0;i<s.length;i++) {
			result = (long) ((long) (result* Math.pow(10, checkNum(Integer.valueOf(s[i]))) + Integer.valueOf(s[i]))
					%(Math.pow(10, 9)+7));
		}
		return result;
	}
	
	public static int checkNum(int num) {
		int result = 0;
		while(num !=0 ) {
			num = num/10;
			result++;
		}
		return result;
	}

}
