package LeetCode;
import java.util.*;
import java.util.stream.Collectors;

public class PermutationII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.print(permutationUnique(nums));
	}

	public static List<List<Integer>> permutationUnique(int[] nums){
		List<List<Integer>> temp = new ArrayList<>();
		Set<List<Integer>> result = new HashSet<>();
		permute(temp,nums,0,nums.length-1);
		result = new HashSet<>(temp);
		return new ArrayList<>(result);
	}
	
	public static void permute(List<List<Integer>> result, int[] nums, int l, int r){
		if(l == r) {
			List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
			//Set list to unique list
			result.add(list);
		} else {
			for(int i = l;i<=r ;i++) {
				nums = swap(nums,l,i);
				permute(result,nums,l+1,r);
				nums = swap(nums,l,i);
			}
			
		}
	}
	
	public static int[] swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
		return nums;
	}
}
