package LeetCode;
import java.util.*;

public class ValidTriangleNumber {
	
	//Use the find combinations algorithm and then check if the triplets make a triangle

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,3,4};
		System.out.print(triangleNumber(nums));
	}

	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		int n = nums.length;
		for(int i = 0 ; i < n;i++) {
			for(int j = i+1, k = j+1;j<n-1 && k <= n;) {
				if(k == n|| nums[i] + nums[j] <= nums[k]) {
					if(k > j+1) {
						res += k-j-1;
					}
					j++;
				} else {
					k++;
				}
			}
		}
		return res;
	}
	
	public static void combinationsUtil(int[] arr, int[] data, int start, int end, int index, int r, List<List<Integer>> res) {
		if(index == r) {
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < r; i++) {
				list.add(data[i]);
			}
			if(checkTriangle(data)) {
				res.add(list);
			}
			return;
		}
		for(int i = start; i <= end && end-i+1 >= r - index;i++) {
			data[index] = arr[i];
			combinationsUtil(arr, data, i+1, end, index+1, r, res);
		}
	}
	
	public static boolean checkTriangle(List<Integer> list) {
		return (list.get(0)+list.get(1) > list.get(2) && list.get(0)+list.get(2) > list.get(1) && list.get(2)+list.get(1) > list.get(0));
	}
	
	public static boolean checkTriangle(int[] list) {
		return (list[0] + list[1] > list[2] && list[2] + list[0] > list[1] && list[1] + list[2] > list[0]);
	}
}
