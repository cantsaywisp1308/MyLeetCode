package LeetCode;

import java.util.*;

public class LongestConsecutiveSequence {
	
	static int max_ref;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {};
		System.out.print(lis(nums,nums.length));
	}

	public static int longestConsecutive(int[] nums) {

		if (nums.length == 0) {
			return 0;
		} else {
			Arrays.sort(nums);
			Vector<Integer> list[] = new Vector[nums.length];
			for(int i = 0; i < nums.length;i++) {
				list[i] = new Vector<Integer>();
			}
			list[0].add(nums[0]);
			for(int i = 1;i<nums.length;i++) {
				for(int j = 0; j < i;j++) {
					if(nums[i] == nums[j]+1 && list[i].size() < list[j].size()+1) {
						list[i] = (Vector<Integer>) list[j].clone();
					}
				}
				list[i].add(nums[i]);
			}
			Vector<Integer> max = list[0];
			for(Vector<Integer> x : list) {
				if(x.size() > max.size()) {
					max = x;
				}
			}
			return max.size();
		}
		
	}
	
	static int _lis(int arr[], int n)
    {
        // Base case
        if (n <= 1)
            return n;

        // 'max_ending_here' is length of LIS ending with
        // arr[n-1]
        int res, max_ending_here = 1;

        // Recursively get all LIS ending with arr[0],
        // arr[1] ... arr[n-2]. If   arr[i-1] is smaller
        // than arr[n-1], and max ending with arr[n-1] needs
        // to be updated, then update it
        for (int i = 1; i < n; i++) {
            res = _lis(arr, i);
            if (arr[i - 1]+1 == arr[n - 1]
                && res + 1 > max_ending_here)
                max_ending_here = res + 1;
        }

        // Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (max_ref < max_ending_here)
            max_ref = max_ending_here;

        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
    }
	
	static int lis(int arr[], int n)
    {
		
        // The max variable holds the result
        max_ref = 1;
        
        Arrays.sort(arr);

        // The function _lis() stores its result in max
        _lis(arr, n);

        // Returns max
        return max_ref;
    }
}
