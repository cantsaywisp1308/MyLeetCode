package LeetCode;
import java.util.*;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		merge(nums1, m, nums2, n);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int j = 0;
		for(int i = m; i < nums1.length; i++) {
			nums1[i] = nums2[j];
			j++;
		}
		Arrays.sort(nums1);
		print(nums1);
	}
	
	public static void print(int[] nums) {
		for(int i = 0 ; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
