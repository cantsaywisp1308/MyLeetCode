package ICPC;

public class MinimumNumberOfJumpsToReachEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,1,4};
		System.out.print(minJumps(nums));
	}
	
	public static boolean canJump(int[] nums) {
		if(minJumps(nums) != Integer.MAX_VALUE) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int minJumps(int[] arr) {
		int n = arr.length;
		int[] jumps = new int[n];
		if(n == 0 || arr[0] == 0) {
			 return Integer.MAX_VALUE;
		}
		
		jumps[0] = 0;
		
		for(int i = 1; i < n;i++) {
			jumps[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i;j++) {
				if(i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		
		return jumps[n-1];
		 
	}

}
