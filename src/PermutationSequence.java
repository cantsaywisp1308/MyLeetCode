package LeetCode;
import java.util.*;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int k = 362000;
		System.out.print(getPermutation(n, k));
	}
	
	public static String getPermutation(int n, int k) {
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <=n;i++) {
			nums.add(i);
		}
		List<String> res = new ArrayList<String>();
		backtracking(res, new ArrayList<Integer>(), nums);
		return res.get(k-1);
	}
	
	

	public static void backtracking(List<String> res, List<Integer> temp, List<Integer> nums) {
		if(nums.size() < 0) {
			return;
		} else if(nums.size() == 0) {
			res.add(toString(temp));
		} else {
			for(int i = 0 ; i<nums.size();i++) {
				int pick = nums.get(i);
				temp.add(pick);
				nums.remove(i);
				backtracking(res, temp, nums);
				nums.add(i, pick);
				temp.remove(temp.size()-1);
			}
		}	
	}

	public static String toString(List<Integer> list) {
		String res = "";
		for(int i : list) {
			res += i;
		}
		return res;
	}

}
