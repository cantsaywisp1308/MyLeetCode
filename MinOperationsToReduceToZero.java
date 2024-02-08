package LeetCode;

public class MinOperationsToReduceToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int minOperations(int n) {
		int pow = powerOfTwo(n);
		return 0;
	}
	
	public static int powerOfTwo(int n) {
		int result = 0;
		while(n > (int)Math.pow(2, result)) {
			result++;
		}
		return result;
	}

}
