package LeetCode;
import java.util.*;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2;
		System.out.print(isHappy(num));
	}

	public static boolean isHappy(int num) {
		Set seen = new HashSet();
		String cur = String.valueOf(num);
		while(!seen.contains(cur)) {
			seen.add(cur);
			int sum = 0;
			for(int i = 0 ; i < cur.length(); i++) {
				String dig = "";
				dig += cur.charAt(i);
				int digit = Integer.parseInt(dig);
				sum += digit * digit;
			}
			if(sum == 1) return true;
			cur = String.valueOf(sum);
		}
		return false;
	}
}
