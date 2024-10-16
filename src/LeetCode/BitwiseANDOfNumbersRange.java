package LeetCode;

public class BitwiseANDOfNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int left = 1;
		int right = 2147483647;
		System.out.print(rangeBitwiseAnd(left, right));
	}
	
	public static int rangeBitwiseAnd(int left, int right) {
		while(right > left) {
			right = right & (right-1);
		}
		return right;
	}

}
