package ICPC;

import java.util.List;
import java.util.*;

public class FindAllPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {1,2,3};
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i<values.length;i++) {
			nums.add(values[i]);
		}
		List<Integer> tempList = new ArrayList<Integer>();
		findPermutations(nums, tempList);
	}
	
	public static void findPermutations(List<Integer> nums, List<Integer> tempList){
		List<List<Integer>> result = new ArrayList<>();
		if(nums.size() == 0) {
			result.add(tempList);
		} else {
			for(int i = 0;i<nums.size();i++) {
				int pick = nums.get(i);
				tempList.add(pick);
				nums.remove(i);
				findPermutations(nums, tempList);
				nums.add(i, pick);
				tempList.remove(tempList.size()-1);
			}
		}
		for(int i = 0; i<result.size();i++) {
			if(result.get(i).size()>0) {
				System.out.println(result.get(i));
			}
		}
		
	}

}
