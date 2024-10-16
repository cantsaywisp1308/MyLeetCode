package LeetCode;

import java.util.*;

public class LetterCombinationsPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "";
		System.out.print(letterCombinations(digits));
	}

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == "") {
			return result;
		}
		Map<Character, String> map = new HashMap<Character, String>();
		map = getMap(map);
		StringBuffer s = new StringBuffer();
		dfs(0, digits, result, s, map);
		return result;

	}

	public static void dfs(int i, String digits, List<String> result, StringBuffer s, Map<Character, String> map) {
		if (i == digits.length()) {
			result.add(s.toString());
			return;
		}
		String temp = map.get(digits.charAt(i));
		for (char c : temp.toCharArray()) {
			s.append(c);
			dfs(i + 1, digits, result, s, map);
			s.deleteCharAt(s.length() - 1);
		}
	}

	public static Map<Character, String> getMap(Map<Character, String> map) {
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		return map;
	}
}
