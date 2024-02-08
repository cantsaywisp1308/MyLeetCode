package LeetCode;
import java.util.*;

public class CountOfRangeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,5,-1};
		int lower = -2;
		int upper = 2;
		System.out.print(countRangeSum(nums, lower, upper));
	}
	
	public static int countRangeSum(int[] nums, int lower, int upper) {
		int left = 0;
		int right = 0;
		int sum = 0;
		List<List<Integer>> list = new ArrayList<>();
		while(right < nums.length) {
			sum += nums[right];
			while(sum <= lower || sum >= upper) {
				sum -= nums[left];
				list.add(new ArrayList<Integer>(Arrays.asList(left,right)));
				left++;
			}
			right++;
		}
		return list.size();
	}
	
	public static int sum(int[] nums, int left, int right) {
		int sum = 0;
		for(int i = left; i<=right;i++) {
			sum += nums[i];
		}
		return sum;
	}

}
