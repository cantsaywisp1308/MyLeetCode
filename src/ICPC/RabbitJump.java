package ICPC;
import java.util.*;



public class RabbitJump { // this one uses permuation

	static int[] dp = new int[10001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] step = {1,2,5};
		System.out.print(DPSolution(dp, n, step.length, step));
	}

//	public static int rabbitJump(int n, int[] step) {

//		List<Integer> steps = new ArrayList<Integer>();
//		for(int i = 0; i<step.length;i++) {
//			steps.add(step[i]);
//		}
//		List<List<Integer>> result = new ArrayList<>();
//		List<Integer> tempList = new ArrayList<Integer>();
//		backTracking(result,steps, tempList, n);
//		return result.size()%1000000007;
//	}
//	
//	public static void backTracking(List<List<Integer>> result,List<Integer> steps, List<Integer> tempList,int n) {
//		if(n<0 || steps.size() < 0) {
//			return;
//		} else if( n==0) {
//			result.add(new ArrayList<Integer>(tempList));
//		} else {
//			for(int i = 0;i<steps.size();i++) {
//				int pick = steps.get(i);
//				tempList.add(pick);
//				backTracking(result,steps, tempList, n-pick);
//				tempList.remove(tempList.size()-1);
//			}
//		}
//	}
	
	public static int DPSolution(int[] dp,int n, int k, int[] step) {
		for(int i = 0;i <= n;i++) {
			dp[i] = 0;
		}
		
		for(int i = 0; i< k;i++) {
			dp[step[i]]++;
		}
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0;j<k;j++) {
				if(i - step[j] >= 0) {
					dp[i] += dp[i-step[j]];
					dp[i]%= 1000000007;
				}
			}
		}
		return dp[n];
	}
}
