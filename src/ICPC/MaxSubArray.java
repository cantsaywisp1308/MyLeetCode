package ICPC;

import java.util.Arrays;

public class MaxSubArray {

	//Cho dãy A gồm N phần tử số nguyên dương và một số nguyên dương K; 
	//Tìm mảng con có kích thước lớn nhất sao cho tất cả các mảng con có kích thước 
	//bé hơn nó đều có tổng các phần tử nhỏ hơn K.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4};
		int k = 8;
		System.out.print(maxSubArraySize(nums,nums.length, k));
	}

	public static int maxSubArraySize(int[] nums,int n, int k) {
		int[] prefixArray = new int[nums.length+1];
		Arrays.fill(nums, 0);
		for(int i = 0; i< n;i++) {
			prefixArray[i+1] = prefixArray[i] + nums[i];
		}
		return binarySearch(prefixArray, prefixArray.length, k);
	}
	
	public static int binarySearch(int[] prefixsum, int n, int k) {
		int ans = -1;    // Initialize result

	    // Tìm kiếm nhị phân: tìm kích thướng mảng con lớn nhất 
	    int left = 0, right = n-1;
	    while (left <= right)
	    {
	        int mid = (left + right)/2;

	        int i;
	        for (i = mid; i <= n-1; i++)
	        {
	            if (prefixsum[i] - prefixsum[i - mid] > k)
	                break;
	        }

	        if (i == n)
	        {
	            left = mid + 1;
	            ans = mid;
	        }
	        else
	            right = mid -1;
	    }

	    return ans;

	}
	
	
}
