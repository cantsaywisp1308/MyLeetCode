package trial;

public class Balance {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 15;
		int b = 10;
		System.out.print(a*b/gcd(a, b));
	}
	
	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a -b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

}
