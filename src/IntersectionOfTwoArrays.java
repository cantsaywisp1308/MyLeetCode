package LeetCode;

import java.util.*;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {1,3,5,7,9};
		intersection(nums1, nums2);
		
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:nums1) {
        	set1.add(i);
        }
        
        for(int i:nums2) {
        	set2.add(i);
        }
        
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        List<Integer> list = new ArrayList<Integer>(set1);
        for(int i = 0; i<list.size();i++) {
        	res[i] = list.get(i);
        }
        return res;
	}

}
