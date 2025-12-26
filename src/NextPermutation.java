package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 6, 7, 5, 3, 5, 6, 2, 9, 1, 2, 7, 0, 9 };
		nextPermute(nums);
		printArray(nums);
	}

	public static void nextPermute(int[] nums) {
		int index = -1;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			Arrays.sort(nums, 0, nums.length);
			return;
		}

		for (int i = nums.length - 1; i > index; i--) {
			if (nums[i] > nums[index]) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
				break;
			}
		}

		Arrays.sort(nums, index + 1, nums.length);
	}
	
	public static void printArray(int[] nums) {
		System.out.print("[ ");
		for(int i = 0; i < nums.length;i++) {
			System.out.print(nums[i]+ " ");
		}
		System.out.print("]");
	}

	

	public static void backTrack(List<Integer> numsList, List<Integer> tempList, List<List<Integer>> result) {
		if (numsList.size() < 0) {
			return;
		} else if (numsList.size() == 0) {

			result.add(new ArrayList<Integer>(tempList));
		} else {
			for (int i = 0; i < numsList.size(); i++) {
				int pick = numsList.get(i);
				tempList.add(pick);
				numsList.remove(i);
				backTrack(numsList, tempList, result);
				numsList.add(i, pick);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void backTrack1(List<Integer> numsList, List<Integer> tempList, List<int[]> result) {
		if (numsList.size() < 0) {
			return;
		} else if (numsList.size() == 0) {
			int[] arr = new int[tempList.size()];
			for (int i = 0; i < tempList.size(); i++) {
				arr[i] = tempList.get(i);
			}
			result.add(arr);
		} else {
			for (int i = 0; i < numsList.size(); i++) {
				int pick = numsList.get(i);
				tempList.add(pick);
				numsList.remove(i);
				backTrack1(numsList, tempList, result);
				numsList.add(i, pick);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
