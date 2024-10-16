package trial;

public class FindMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,10};
		System.out.print(FindNumber(nums));
	}
	
	public static int FindNumber(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(nums[mid] == mid+1) {
				left = mid +1;
			} else {
				right = mid -1;
			}
		}
		return left+1;
	}

}
