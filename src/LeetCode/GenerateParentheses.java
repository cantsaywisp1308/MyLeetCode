package LeetCode;
import java.util.*;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.print(generateParenthesis(n));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		recurse(result, 0, 0,"", n);
		return result;
	}
	
	public static void recurse(List<String> result, int left, int right, String s, int n) {
		if(s.length() == n*2) {
			result.add(s);
			return;
		}
		
		if(left < n) {
			recurse(result, left+1, right, s + "(", n);
		}
		
		if(right < left) {
			recurse(result, left, right+1, s +")", n);
		}
	}
}
