package LeetCode;

import java.util.*;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,0,3,2,3};
		System.out.print(lengthOfLIS(nums));
	}
	
	public static int lengthOfLIS(int[] nums) {
		 List<Integer> L[] = new Vector[nums.length];
		  for (int i = 0; i < L.length; i++)
		    L[i] = new Vector<Integer>();
		   
		  // L[0] is equal to arr[0]
		  L[0].add(nums[0]);
		 
		  // Start from index 1
		  for (int i = 1; i < nums.length; i++)
		  {
		    // Do for every j less than i
		    for (int j = 0; j < i; j++)
		    {
		      //L[i] = {Max(L[j])} + arr[i]
		      // where j < i and arr[j] < arr[i]
		      if ((nums[i] > nums[j]) && (L[i].size() < L[j].size() + 1))
		        L[i] = (List<Integer>) ((Vector<Integer>) L[j]).clone();  //deep copy
		    }
		 
		    // L[i] ends with arr[i]
		    L[i].add(nums[i]);
		  }
		 
		  // L[i] now stores increasing sub-sequence of
		  // arr[0..i] that ends with arr[i]
		  Vector<Integer> max = (Vector<Integer>) L[0];
		   
		  // LIS will be max of all increasing sub-
		  // sequences of arr
		  for (List<Integer> x : L)
		    if (x.size() > max.size())
		      max = (Vector<Integer>) x;
		 
		  // max will contain LIS
		  return max.size();
	}

}
