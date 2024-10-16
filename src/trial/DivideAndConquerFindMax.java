package trial;

public class DivideAndConquerFindMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,2,-3,-4,-12,5,2,12};
		//System.out.print(findMax(nums, 0, nums.length-1));
		rearrangeNegaAndPosi(nums);
	}

	public static int findMax(int[] nums,int left, int right) {
		int[] res = findMaxByDivide(nums, 0, nums.length-1);
		return res[1];
	}
	
	public static int[] findMaxByDivide(int[] nums, int left, int right) {
		int[] pair = new int[2];
		if(right - left ==1) {
			pair[0] = nums[right];
			pair[1] = right;
			return pair;
		}
		int mid = (right + left)/2;
		int[] leftMax = findMaxByDivide(nums, left, mid);
		int[] rightMax = findMaxByDivide(nums,mid,right);
		return (leftMax[0] > rightMax[0] ? leftMax : rightMax);
	}
	
	public static void rearrangeNegaAndPosi(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            while (arr[left] < 0) {
                left++;
            }
            while (arr[right] >= 0) {
                right--;
            }

            if (left < right) {
                // Swap elements at positions left and right
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        
        for(int i = 0; i < arr.length;i++) {
        	System.out.print(arr[i] + " ");
        }
    }
}
