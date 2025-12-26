package LeetCode;

import java.util.*;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "101023";
		System.out.print(restoreIpAddresses(s));
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		List<String> dict = new ArrayList<String>();
		for (int i = 0; i < 256; i++) {
			dict.add(Integer.toString(i));
		}
		String ans = "";
		String[] add = new String[4];
		breakIPAddressUtil(add, s.length(), s, dict, res, ans, 0);
		return res;
	}

	public static void breakIPAddressUtil(String[] add, int n, String s, List<String> dict, List<String> res, String ans, int index) {
		for (int i = 1; i <= n; i++) {
			String prefix = s.substring(0, i);		
			if (dict.contains(prefix)) {
				if (index > 3 || i == n) {
					ans += prefix;
					if(countDot(ans)==3) {
						res.add(ans);
					}
					return;
				} else {
					add[index] = prefix;
				}
				breakIPAddressUtil(add,n - i, s.substring(i, n), dict, res, ans + prefix + ".",index+1);
			}

		}
	}
	
	public static int countDot(String s) {
		int count = 0;
		for(int i = 0 ; i < s.length();i++) {
			if(s.charAt(i) == '.') {
				count++;
			}
		}
		return count;
	}

}
