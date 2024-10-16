package HackerRank;
import java.util.*;

public class FindDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		System.out.print(findDigits(n));
	}
	
	public static int findDigits(int n) {
		int count = 0;
		List<Integer> digits = new ArrayList<Integer>();
		int num = n;
		while(num != 0) {
			digits.add(num%10);
			num /= 10;
		}
		for(int digit:digits) {
			if(digit != 0) {
				if(n % digit == 0) {
					count++;
				}
			}
		}
		return count;
	}

}
