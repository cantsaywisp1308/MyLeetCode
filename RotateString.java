package LeetCode;

public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcde";
		String goal = "abced";
		System.out.print(rotateString(s,goal));
	}
	
	public static boolean rotateString(String s, String goal) {
		int i = 0;
		while(i< s.length()) {
			s = rotate(s);
			if(s.equals(goal)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public static String rotate(String s) {
		String res = "";
		char[] c = new char[s.length()];
		for(int i = 1; i<s.length();i++) {
			c[i] = s.charAt(i-1);
		}
		c[0] = s.charAt(s.length()-1);
		for(int i = 0; i < c.length;i++) {
			res += c[i];
		}
		return res;
	}

}
