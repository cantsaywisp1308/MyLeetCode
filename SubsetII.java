package LeetCode;
import java.util.*;

public class SubsetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2};
		System.out.print(subsetsWithDup(nums));
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		backtracking(nums, new ArrayList<Integer>(), 0, res);
		Set<List<Integer>> res1 = new HashSet<>(res);
		res = new ArrayList<>(res1);
		return res;
	}
	
	public static void backtracking(int[] nums, List<Integer>temp, int index, List<List<Integer>> res) {
		if(index == nums.length) {
			res.add(temp);
			return;
		}
		backtracking(nums, new ArrayList<Integer>(temp), index+1, res);
		temp.add(nums[index]);
		backtracking(nums, new ArrayList<Integer>(temp), index+1, res);
	}
}
