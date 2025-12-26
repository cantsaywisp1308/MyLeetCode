package LeetCode;

public class FindNUniqueIntegersSumUpToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.print(sumZero(n));
	}
	
	public static int[] sumZero(int n) {
		int[] res = new int[n];
		if(n%2 != 0) {
			res[0] = -n/2;
			for(int i = 1; i < n;i++) {
				res[i] = res[i-1]+1;
			}
		} else {
			res[0] = -n/2;
			for(int i = 1;i<n;i++) {
				if(res[i-1] == -1) {
					res[i] = res[i-1]+2;
				} else {
					res[i] = res[i-1]+1;
				}
			}
		}
		return res;
	}

}
