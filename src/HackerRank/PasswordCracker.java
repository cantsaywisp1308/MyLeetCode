package HackerRank;
import java.util.*;

public class PasswordCracker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] pass = {"hello","planet"};
		String loginAttempt = "helloworld";
		List<String> passwords = Arrays.asList(pass);
		System.out.print(passwordCracker(passwords, loginAttempt));
	}
	
	public static String passwordCracker(List<String> passwords, String loginAttempt) {
		String ans = "";
		int n = loginAttempt.length();
		List<String> res = new ArrayList<String>();
		passwordCrackUtil(loginAttempt, res, passwords, n, ans);
		if(res.size() == 0) {
			return "WRONG PASSWORD";
		} else {
			return res.get(0);
		}
	}
	
	public static void passwordCrackUtil(String s, List<String> res, List<String> passwords, int n, String ans) {
		for(int i = 1; i <= n; i++) {
			String prefix = s.substring(0,i);
			if(passwords.contains(prefix)) {
				if(i == n) {
					ans += prefix;
					res.add(ans);
					return;
				}
				passwordCrackUtil(s.substring(i,n), res, passwords, n-i, ans+prefix+" ");
			}
			
		}
	}

}
