package LeetCode;
import java.util.*;

public class FindMinimumInRotatedSortedArray {
	
	//use binary search since the requirement is O(logn)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,5,6,7,0,1,2};
		System.out.print(findMin(nums));
	}

	public static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[right];
	}
	

}
