package LeetCode;

public class MultiplyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "9133";
		String num2 = "0";
		System.out.print(multiply(num1, num2));

	}

	public static String multiply(String num1, String num2) {
//		if (num1 == "0" || num2 == "0") {
//			return "0";
//		}
//		return multiplyUtil(num1, num2);
		String finalRes = "";
		int[] n1 = new int[num1.length()];
		int[] n2 = new int[num2.length()];
		for (int i = 0; i < n1.length; i++) {
			n1[i] = num1.charAt(i) - 48;
		}

		for (int i = 0; i < n2.length; i++) {
			n2[i] = num2.charAt(i) - 48;
		}
		int[] res = new int[num1.length() + num2.length()];
		int[][] mem = new int[num2.length()][num1.length() + num2.length()];
		int k = 0;
		int p2 = num2.length() - 1;
		for (int i = 0; i < num2.length(); i++) {
			int remember = 0;
			int p1 = num1.length() - 1;

			for (int j = num1.length() + num2.length() - 1 - k; j >= 0; j--) {
				if (p1 < 0) {
					mem[i][j] = (remember) % 10;
					break;
				} else {
					mem[i][j] = (n1[p1] * n2[p2] + remember) % 10;
					remember = (n1[p1] * n2[p2] + remember) / 10;
					;
					p1--;
				}
			}
			p2--;
			k++;
		}

		int remember = 0;
		for (int i = mem[0].length - 1; i >= 0; i--) {
			res[i] = (sumByColumn(mem, i) + remember) % 10;
			remember = (sumByColumn(mem, i) + remember) / 10;

		}
		int pos = 0;
		while (res[pos] == 0 && pos < res.length-1) {
			pos++;
		}
		for (int i = pos; i < res.length; i++) {
			finalRes += res[i];
		}
		return finalRes;
	}

	

	public static int sumByColumn(int[][] num, int i) {
		int sum = 0;
		for (int j = 0; j < num.length; j++) {
			sum += num[j][i];
		}

		return sum;
	}

}
