package LeetCode;
import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		String[] words = {"leet","code"};
		List<String> wordDict = new ArrayList<String>(Arrays.asList(words));
		System.out.print(wordBreak2(s, wordDict));
	}
	
	public static boolean  wordBreak(String s, List<String> wordDict) {
		boolean status = true;
		Set<String> wordSet = new HashSet<String>();
		String ans = "";
		wordBreakUtil(s.length(), wordSet,s, wordDict, ans);
//		for(String sentences: wordSet) {
//			String[] words = sentences.split(" ");
//			for(String word : words) {
//				if(!wordDict.contains(word)) {
//					status = false;
//					break;
//				}
//			}	
//		}
		return !wordSet.isEmpty();
	}
	
	public static void wordBreakUtil(int n, Set<String> wordSet ,String s, List<String> dict, String ans) {
		for(int i = 1; i <= n;i++) {
			String prefix = s.substring(0, i);
			if(dict.contains(prefix)) {
				if(i == n) {
					ans += prefix;
					wordSet.add(ans);
					return;
				}
				wordBreakUtil(n-i, wordSet, s.substring(i, n), dict, ans+prefix+" ");
			}
		}
	}

	public static boolean wordBreak2(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(int i = 1; i <= s.length();i++) {
			for(int j = 0;j < i;j++) {
				if(dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
