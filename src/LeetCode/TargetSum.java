package LeetCode;

public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,1,1};
		System.out.print(findTargetSumWays(nums, 3));
	}
	
	 public static int findTargetSumWays(int[] nums, int target) {
		 return helper(nums, 0, 0, target);
	 }
	 
	 public static int helper(int[] nums, int index, int curSum, int target) {
		 if (index == nums.length) {
	            // Check if we have reached the target sum
	            if (curSum == target) {
	                return 1; // Return 1 to indicate that we have found a valid combination
	            } else {
	                return 0; // Return 0 to indicate that we have not found a valid combination
	            }
	        }
	        
	        // Recursive case: we can either add or subtract the current number to the current sum
	        int left = helper(nums, index + 1, curSum + nums[index], target); // Add the current number to the current sum
	        int right = helper(nums, index + 1, curSum - nums[index], target); // Subtract the current number from the current sum
	        return left + right;
	 }
	 


}
