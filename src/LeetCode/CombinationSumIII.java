package LeetCode;
import java.util.*;

public class CombinationSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int k =3;
		System.out.print(combinationSum3(k, n));
	}
	
	public static List<List<Integer>> combinationSum3(int k, int n){
		int[] nums = {1,2,3,4,5,6,7,8,9};
		List<List<Integer>> list = new ArrayList<>();
		backtracking(list, nums, 0, n, new ArrayList<Integer>(), k);
		return list;
	}
	
	public static void backtracking(List<List<Integer>> result, int[] nums, int start, int remain, List<Integer> temp,int k) {
		if(remain < 0 || temp.size() > k) {
			return;
		} else if(remain == 0 && temp.size() == k) {
			result.add(new ArrayList<Integer>(temp));
		} else {
			for(int i = start;i<nums.length;i++) {
				temp.add(nums[i]);
				backtracking(result, nums, i+1, remain - nums[i], temp, k);
				temp.remove(temp.size()-1);
			}
		}
	}

}
