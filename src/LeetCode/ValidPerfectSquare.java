package LeetCode;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2147483647;
		System.out.print(isPerfectSquare(num));
	}

	public static boolean isPerfectSquare(int num) {
		return (Math.pow(num, 0.5))%1 == 0;
	}

}
