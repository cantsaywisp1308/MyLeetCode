package LeetCode;

public class SumOfSquareNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = 2147483600;
		System.out.print(judgeSquareSum(c));
	}

	public static boolean judgeSquareSum(int c) {
		int i = 0;
		int j = (int)Math.sqrt(c);
		while (i <= j) {
			long sum = (long) (Math.pow(i, 2) + (long)Math.pow(j, 2));
			if (sum == c)
				return true;
			else if (sum > c)
				j--;
			else
				i++;
		}
		return false;
	}
}
