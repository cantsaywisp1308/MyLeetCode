package LeetCode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.print(findMedianSortedArrays(nums1, nums2));

	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        Arrays.sort(arr);

        if(arr.length % 2 !=0){
            int mid = arr.length / 2;
            return (double) arr[mid];
        }

        int mid = arr.length / 2;
        return (double) (arr[mid -1 ] + arr[mid])/2;
	}
	
	
	public static double findAverage(int[] nums) {
		if(nums.length == 0) {
			return 0;
		} else if(nums.length %2 ==0) {
			return ((double)nums[nums.length/2] + (double)nums[nums.length/2-1])/2.0;
		} else {
			return (double)nums[nums.length/2];
		}
	}
	

}
