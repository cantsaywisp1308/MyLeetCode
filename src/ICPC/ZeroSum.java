package ICPC;
import java.util.*;

public class ZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-3, 2, 3, 1, 6};
		System.out.print(checkZeroSum(nums));

	}

	public static boolean checkZeroSum(int[] nums) {
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < nums.length;i++) {
			sum += nums[i];
			if(sum == 0 || list.contains(sum)) {
				return true;
			}
			list.add(sum);
		}
		return false;
	}
}
