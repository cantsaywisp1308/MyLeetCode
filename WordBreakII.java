package LeetCode;
import java.util.*;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		String[] words = {"cat","cats","and","sand","dog"};
		List<String> wordDict = Arrays.asList(words);
		System.out.print(wordBreak(s, wordDict));
	}
	
	public static List<String> wordBreak(String s, List<String> wordDict){
		List<String> res = new ArrayList<String>();
		String ans = "";
		wordBreakUtil(s, wordDict, ans, s.length(), res);
		return res;
	}
	
	public static void wordBreakUtil(String s, List<String> wordDict, String ans,int n, List<String> res) {
		for(int i = 1; i <= n;i++) {
			String prefix = s.substring(0, i);
			if(wordDict.contains(prefix)) {
				if(i == n) {
					ans += prefix;
					res.add(ans);
					return;
				}
				wordBreakUtil(s.substring(i, n), wordDict, ans+prefix+" ", n-i, res);
			}
		}
	}

}
