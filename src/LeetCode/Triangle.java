package LeetCode;
import java.util.*;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{2},{3,4},{6,5,7},{4,1,8,3}};
		List<List<Integer>> triangle = new ArrayList<>();
		for(int i = 0; i < array.length;i++) {
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0 ; j < array[i].length;j++) {
				list.add(array[i][j]);
			}
			triangle.add(list);
		}
		System.out.print(minimumTotal2(triangle));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		for(int i = 0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		return helper(triangle,0,0,dp);
	}
	
	public static int helper(List<List<Integer>> triangle, int i , int j, int[][] dp) {
		if(i == triangle.size()-1) {
			return triangle.get(i).get(j);
		} 
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int left = helper(triangle,i+1,j,dp) + triangle.get(i).get(j);
		int right = helper(triangle, i+1,j+1,dp) + triangle.get(i).get(j);
		return dp[i][j] = Math.min(left, right); 
	}
	
	public static int minimumTotal2(List<List<Integer>> triangle) {
		int total = 0;
		for(int i = 0; i < triangle.size();i++) {
			total+= min(triangle.get(i));
		}
		return total;
	} 
	
	public static int min(List<Integer> array) {
		int min = array.get(0);
		for(int i = 0; i < array.size();i++) {
			if(array.get(i) < min ) {
				min = array.get(i);
			}
		}
		return min;
	}

}
