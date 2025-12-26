package LeetCode;

public class ConvertANumberToHexadecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = -2;
		System.out.print(toHex(num));
	}

	public static String toHex(int num) {
		String hexValue = Integer.toHexString(num);
        return hexValue;
	}

}
