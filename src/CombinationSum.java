package LeetCode;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {1,2,3,4,5,6};
		int target = 10;
		System.out.print(combinationSum(candidates, target));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		backTracking(list, new ArrayList<>(), candidates, target, 0);
		return list;
	}

	public static void backTracking(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain,
			int start) {
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			list.add(new ArrayList<Integer>(tempList));
		} else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backTracking(list, tempList, nums, remain - nums[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}

	}
}
