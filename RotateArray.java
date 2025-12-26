package LeetCode;
import java.util.*;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums, k);
	}
	
	public static void rotate(int[] nums, int k) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		k = k % nums.length;
		for(int i = 0; i < nums.length;i++) {
			deque.add(nums[i]);
		}
		for(int i = 0 ; i < k;i++) {
			int value = deque.getLast();
			deque.removeLast();
			deque.addFirst(value);
		}
		for(int i = 0 ; i < nums.length;i++) {
			int val = deque.getFirst();
			nums[i] = val;
			deque.removeFirst();
		}
	}

}
