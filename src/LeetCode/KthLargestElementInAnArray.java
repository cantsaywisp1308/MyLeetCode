package LeetCode;

import java.util.*;

public class KthLargestElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3,2,3,1,2,4,5,5,6};
		int k = 4;
		System.out.print(findKthLargest(nums, k));
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for(int num:nums) {
			maxHeap.offer(num);
		}
		for(int i = 0 ; i < k-1;i++) {
			maxHeap.poll();
		}
		return maxHeap.peek();
	}

	

}
