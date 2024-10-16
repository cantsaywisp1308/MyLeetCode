package LeetCode;
import java.util.*;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int k = 2;
		System.out.print(combine(n, k));
	}

	public static List<List<Integer>> combine(int n, int k) {
		int[] nums = new int[n];
		for(int i = 1; i <=n;i++) {
			nums[i-1] = i;
		}
		List<List<Integer>> res = new ArrayList<>();
		combinationsForm(res, new ArrayList<Integer>(), 0, nums);
		List<List<Integer>> res1 = new ArrayList<>();
		for(List<Integer> l : res) {
			if(l.size() == k) {
				res1.add(l);
			}
		}
		return res1;
	}
	
	public static void combinationsForm(List<List<Integer>> res, List<Integer> temp, int start, int[] nums) {
		if(start == nums.length) {
			res.add(temp);
			return;
		}
		combinationsForm(res, new ArrayList<Integer>(temp), start+1, nums);
		temp.add(nums[start]);
		combinationsForm(res, new ArrayList<Integer>(temp), start+1, nums);
	}
}
