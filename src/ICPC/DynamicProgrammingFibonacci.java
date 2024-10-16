package ICPC;

public class DynamicProgrammingFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		System.out.print(Fibonacci(n));
	}

	public static int Fibonacci(int n) {
		if(n==0 || n ==1) {
			return n;
		} else {
			int[] result = new int[n+2];
			result[0] = 0;
			result[1] = 1;
			for(int i =2;i<=n;i++) {
				result[i] = result[i-1]+ result[i-2];
			}
			return result[n];
		}
	}
}
