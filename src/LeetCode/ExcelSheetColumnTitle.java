package LeetCode;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int columnNumber = 1;
		System.out.print(convertToTitle(columnNumber));
	}

	public static String convertToTitle(int columnNumber) {
		String result = "";
		while(columnNumber > 0) {
			columnNumber--;
			result += (char)((columnNumber%26) + 'A');
			columnNumber /= 26;
		}
		String res = "";
		for(int i = result.length()-1;i>=0;i--) {
			res += result.charAt(i);
		}
		return res;
	}

}
