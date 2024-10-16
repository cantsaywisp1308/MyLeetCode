package LeetCode;
import java.util.*;
import java.util.Arrays;

public class TotalCostToHireKWorkers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] costs = {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
		int k = 11;
		int candidates = 2;
		System.out.print(totalCost(costs, k, candidates));
	}

	public static long totalCost(int[] costs, int k, int candidates) {
		long res = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0]==b[0]? a[1] - b[1]: a[0]-b[0]);
		int[] isLowerHalf = new int[costs.length];
		int left = candidates - 1;
		int right = costs.length - candidates;
		for(int i = 0 ; i < candidates; i++) {
			q.add(new int[] {costs[i], i});
			isLowerHalf[i] = 1;
		}
		for(int i = costs.length-1; i >=0 && q.size() < Math.min(2*candidates, costs.length);i--) {
			q.add(new int[] {costs[i],i});
			isLowerHalf[i] = -1;
		}
		for(int i = 0 ; i<k;i++) {
			int[] min = q.poll();
			res += min[0];
			if(isLowerHalf[min[1]]==1) {
				if(left +1 < right) {
					q.add(new int[] {costs[left+1],left+1});
					isLowerHalf[left+1]=1;
					left++;
				}
			} else {
				if(right - 1 > left) {
					q.add(new int[] {costs[right-1],right-1});
					isLowerHalf[right-1] = -1;
					right--;
				}
			}
		}
		return res;
	}
}
