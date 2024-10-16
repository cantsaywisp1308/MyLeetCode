package LeetCode;
import java.util.*;
public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3z4";
        List<String> result = letterCasePermutation(s);
        System.out.println(result);
	}
	
	 public static List<String> letterCasePermutation(String s) {
	        List<String> result = new ArrayList<>();
	        backtrack(result, new StringBuilder(), s, 0);
	        return result;
	    }

	    private static void backtrack(List<String> result, StringBuilder current, String s, int index) {
	        if (index == s.length()) {
	            result.add(current.toString());
	            return;
	        }

	        char ch = s.charAt(index);
	        if (Character.isLetter(ch)) {
	            // Lowercase branch
	            current.append(Character.toLowerCase(ch));
	            backtrack(result, current, s, index + 1);
	            current.deleteCharAt(current.length() - 1);

	            // Uppercase branch
	            current.append(Character.toUpperCase(ch));
	            backtrack(result, current, s, index + 1);
	            current.deleteCharAt(current.length() - 1);
	        } else {
	            // If it's a digit, just continue with it
	            current.append(ch);
	            backtrack(result, current, s, index + 1);
	            current.deleteCharAt(current.length() - 1);
	        }
	    }

}
