package ICPC;
import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "samsungmobilelovemango";
		int n = s.length();
		List <String> dict= Arrays.asList("mobile","samsung","sam","sung",
                "man","mango", "icecream","and",
                "go","i","love","ice","cream");   
		wordBreak(n, dict, s);
	}
	
	public static void wordBreak(int n, List<String> dict, String s) {
		String ans="";
	    wordBreakUtil(n, s, dict, ans);
	}
	
	public static void wordBreakUtil(int n, String s, List<String> dict, String ans) {
		for(int i = 1; i <= n;i++) {
			String prefix = s.substring(0, i);
			if(dict.contains(prefix)) {
				if(i == n) {
					ans += prefix;
					System.out.println(ans);
					return;
				}
				wordBreakUtil(n-i, s.substring(i, n), dict, ans+prefix+" ");
			}
		}
	}

}
