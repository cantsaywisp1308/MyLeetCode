package LeetCode;
import java.util.*;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbacdcbc";
		System.out.print(removeDuplicateLetters(s));

	}

	public static String removeDuplicateLetters(String s) {
		Set<Character> charSet = new HashSet<Character>();
		PriorityQueue<Character> charQueue = new PriorityQueue<Character>();
		for(int i = 0; i < s.length(); i++) {
			charQueue.offer(s.charAt(i));
		}
		
		while(!charQueue.isEmpty()) {
			Character c = charQueue.peek();
			charSet.add(c);
			charQueue.poll();
		}
		
		Character[] array = new Character[charSet.size()];
		array = (Character[]) charSet.toArray();
		Arrays.sort(array);
		
		
		String result = "";
		for(Character c:charSet) {
			result += c;
		}
		return result;
	}

}
