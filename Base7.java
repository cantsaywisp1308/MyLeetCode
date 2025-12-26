package LeetCode;

public class Base7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = -8;
		System.out.print(convertToBase7(num));

	}

	public static String convertToBase7(int num) {
		String result = "";
		if(num == 0) {
			return "0";
		} else {
			if(num >0) {
				while(num != 0) {
					result = String.valueOf(num%7) + result;
					num/=7;
				}
			} else {
				num = Math.abs(num);
				while(num != 0) {
					result = String.valueOf(num%7) + result;
					num/=7;
				}
				result = "-" + result;
			}
			
		}

		
		
		return result;
	}
}
