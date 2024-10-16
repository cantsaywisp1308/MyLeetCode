package HackerRank;
import java.util.*;

public class CaesarsCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Always-Look-on-the-Bright-Side-of-Life";
		int k = 3;
		System.out.print(caesarCipher(s, k));
	}
	
	public static String caesarCipher(String s, int k) {
//		List<String> letter = new ArrayList<String>();
//		List<String> cap = new ArrayList<String>();
//		for(int i = 0; i < 26;i++) {
//			letter.add(""+(char)i+65);
//		}
//		for(int i = 0; i < 26;i++) {
//			cap.add(""+(char)i+97);
//		}
		char[] letters = new char[26];
		char[] caps = new char[26];
		for(int i = 0; i < 26;i++) {
			letters[i] = (char) (i +97);
		}
		for(int i = 0; i < 26;i++) {
			caps[i] = (char) (i +65);
		}
		String result = "";
		for(int i = 0; i < s.length();i++) {
			if(s.charAt(i)>=65 && s.charAt(i)<=90) {
				int l = s.charAt(i) - 65;
				l = (l+k)%26;
				result += caps[l];
			} else 
			if(s.charAt(i)>=97 && s.charAt(i)<=122) {
				int l = s.charAt(i) - 97;
				l = (l+k)%26;
				result += letters[l];
			} else {
				result+=s.charAt(i);
			}
			
		}
		return result;
	}

}
