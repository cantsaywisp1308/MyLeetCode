package LeetCode;
import java.util.*;

public class PermutationInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdxabcde";
		String s2 = "abcdeabcdx";
		System.out.print(checkInclusion(s1, s2));
	}

	public static boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length()) return false;
		
		int[] s1Freq = new int[26];
		int[] windowFreq = new int[26]; // Frequency array for the current window in s2
		
		for(char c:s1.toCharArray()) {
			s1Freq[c - 'a']++;
		}
		
		// Initialize the frequency array for the first window in s2
		for(int i = 0 ; i < s1.length(); i++) {
			windowFreq[s2.charAt(i) - 'a']++;
		}
		
		if(Arrays.equals(s1Freq, windowFreq)) return true;
		
		// Slide the window across s2
		for(int i = s1.length(); i < s2.length(); i++) {
			// Add the next character to the window
			windowFreq[s2.charAt(i) - 'a'] ++;
			// Remove the first character of the previous window
			windowFreq[s2.charAt(i - s1.length()) - 'a']--;
			
			if(Arrays.equals(s1Freq, windowFreq)) return true;
		}
		
		return false;
		
    }
	
	public static void generatePermutations(String str) {
		List<String> list = new ArrayList<>();
        list = permute(str, 0, str.length() - 1, list);
        for(String string:list) {
        	System.out.println(string);
        }
    }
	
	public static List<String> permute(String string, int left, int right, List<String> list){
		if(left == right) {
			list.add(string);
		} else {
			for(int i = left; i <= right; i++) {
				string = swap(string, left, i);
				permute(string, left +1, right, list);
				swap(string, left, i); //backtrack
			}
		}
		return list;
	}
	
	public static String swap(String str, int i, int j) {
		char[] charArray = str.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.copyValueOf(charArray);
	}
}

