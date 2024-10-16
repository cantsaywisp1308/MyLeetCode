package trial;

import java.util.*;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 65;
		int[] nums = {1,0,1};
		//System.out.println(FibonacciRecursion(n));
		//System.out.print(FibonacciList(n));
		System.out.print(power(nums, 2));
	}

	public static long FibonacciRecursion(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return FibonacciRecursion(n - 1) + FibonacciRecursion(n - 2);
		}
	}

	public static long FibonacciList(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		if (n == 0 || n == 1) {
			return list.get(n);
		} else {
			int i = 2;
			while (i <= n) {
				list.add(list.get(i - 1) + list.get(i - 2));
				i++;
			}
			return list.get(n);
		}

	}
	
	public static long power(int[] nums, int a) {
		long res = 1;
		int n = 0;
		for(int i = 0; i < nums.length;i++) {
			n += nums[i]*(int)Math.pow(2, i);
			res= (int)Math.pow(a,n);
		}
		return res;
	}
}
