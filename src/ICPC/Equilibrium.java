package ICPC;
import java.util.*;

public class Equilibrium {
	//tìm vị trí mà tổng bên phải = tổng bên trái

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-7, 1, 5, 2, -4, 3 ,0};
		System.out.print(equilibrium(nums));
	}

	public static int equilibrium(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		int sum = sumArray(nums, 0, nums.length-1);
		int leftSum = 0;
		for(int i = 1; i < nums.length-1;i++) {
			leftSum = leftSum + nums[i];
			int rightSum = sum - nums[i];
			if(leftSum == rightSum) {
				return i;
			}
		}
		return -1;
	}
	
	public static int sumArray(int[] nums,int start, int end) {
		int sum = 0;
		for(int i = start; i <= end;i++) {
			sum += nums[i];
		}
		return sum;
	}
	
}
