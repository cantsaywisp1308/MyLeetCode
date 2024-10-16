package LeetCode;

public class SingleElementInASortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2};
		System.out.print(singleNonDuplicate(nums));
	}

	public static int singleNonDuplicate(int[] nums) {
		int res = 0;
		if(nums.length == 1) {
			res = nums[0];
		} else {
			for(int i = 0 ; i<nums.length;i=i+2) {
				if(i+1 >= nums.length) {
					res = nums[nums.length-1];
				} else if(nums[i] != nums[i+1]) {
					res = nums[i];
					break;
				}
			}
		}	
		return res;
	}
}
