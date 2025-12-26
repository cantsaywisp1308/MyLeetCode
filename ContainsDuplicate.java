package LeetCode;
import java.util.*;

import java.util.Arrays;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,3,4};
		System.out.print(containsDuplicate(nums));
	}
	
	public static boolean containsDuplicate(int[] nums) {
        boolean res = false;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length-1;i++){
            set.add(nums[i]);
            if(nums[i+1] == nums[i]) {
            	res = true;
            	break;
            }
        }
        return res;
    }

}
