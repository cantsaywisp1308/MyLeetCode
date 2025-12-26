package LeetCode;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "luffy is still joyboy";
		System.out.print(lengthOfLastWord(s));
	}

	public static int lengthOfLastWord(String s) {
		s.trim();
		String[] strings = s.split(" ");
		int max = 0;
		return strings[strings.length-1].length();
	}
}
