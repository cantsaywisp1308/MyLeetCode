package LeetCode;
import java.util.*;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.print(permute(nums));
	}
	
	public static List<List<Integer>> permute(int[] nums){
		List<Integer> numsList = new ArrayList<Integer>();
		for(int i = 0; i< nums.length;i++) {
			numsList.add(nums[i]);
		}
		List<List<Integer>> result = new ArrayList<>();
		backTrack(numsList, new ArrayList<Integer>(), result);
		return result;
	}
	
	public static void backTrack(List<Integer> numsList, List<Integer> tempList, List<List<Integer>> result) {
		if(numsList.size() < 0) {
			return;
		} else if(numsList.size() == 0) {
			result.add(new ArrayList<Integer>(tempList));
		} else {
			for(int i = 0;i<numsList.size();i++) {
				int pick = numsList.get(i);
				tempList.add(pick);
				numsList.remove(i);
				backTrack(numsList,tempList,result);
				numsList.add(i, pick);
				tempList.remove(tempList.size()-1);
			}
		}
	}

}
