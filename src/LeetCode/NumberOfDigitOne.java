package LeetCode;

public class NumberOfDigitOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 824883294;
		System.out.print(countDigitOne1(n));
	}

	public static long countDigitOne(int n) {
		long count = 0;
		for(int i = 1; i<=n;i++) {
			String str = String.valueOf(i);
			count += str.split("1", -1).length-1;
		}
		return count;
	}
	
	public static int countDigitOne1(int a) {
		int n = a;
		int factors = 1;
		int remainder = 0;
		int count = 0;
		while (n > 0) {
			int temp = factors;
			if (n % 10 == 0) {
				remainder = 0;
			} else if (n % 10 > 1) {
				remainder = temp;
			} else if (n % 10 == 1) {
				remainder = (a % temp ) +1;
			}
			factors *= 10;
			count += (a/factors)*temp + remainder;
			n = n/10;
		}
		return count;
	}
}
