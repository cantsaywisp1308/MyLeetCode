package LeetCode;
import java.util.*;

public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String removeKdigits(String num, int k) {
		if(num.length() == k) {
			return "0";
		}
		Deque<Character> deque = new LinkedList<Character>();
		for(char ch:num.toCharArray()) {
			while(!deque.isEmpty() && k > 0 && deque.peekLast() > ch) {
				deque.removeLast();
				k--;
			}
			deque.addLast(ch);
		}
		
		while(k > 0) {
			deque.removeLast();
			k--;
		}
		
	}

}
