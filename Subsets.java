package LeetCode;

import java.util.*;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
		System.out.print(subsets(nums));

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<Integer>(), nums, 0);
		return res;
	}

	public static void backtrack(List<List<Integer>> res, List<Integer> sub, int[] nums, int index) {
		if(index == nums.length) {
			res.add(sub);
			return;
		}
		backtrack(res, new ArrayList<Integer>(sub), nums, index+1);
		sub.add(nums[index]);
		backtrack(res,new ArrayList<Integer>(sub),nums,index+1);
	}

}
