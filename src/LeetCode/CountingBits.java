package LeetCode;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		displayArray(countBits(n));
	}

	public static int[] countBits(int n) {
		int[] res = new int[n+1];
		String[] bin = new String[n+1];
		for(int i = 0 ; i < bin.length; i++) {
			bin[i] = Integer.toBinaryString(i);
			res[i] = checkOne(bin[i]);
		}
		return res;
	}
	
	public static int checkOne(String s) {
		int count = 0;
		for(int i = 0; i<s.length();i++) {
			if(s.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
	
	public static void displayArray(int[] a) {
		for(int i = 0; i < a.length;i++) {
			System.out.print(a[i]+ " ");
		}
	}

}
