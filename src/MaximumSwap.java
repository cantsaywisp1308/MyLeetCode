package LeetCode;
import java.util.*;

public class MaximumSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums = 9973;
		System.out.print(maximumSwap(nums));
	}

	public static int maximumSwap(int num) {
		String s = String.valueOf(num);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if(swap(s,i,j).compareTo(s) > 0) {
					list.add(swap(s,i,j));
				}
			}
		}
		String[] arr = new String[list.size()];
		for(int i = 0;i<list.size();i++) {
			arr[i] = list.get(i);
		}
		Arrays.sort(arr, (a,b)-> (b+a).compareTo(a+b));
		if(arr.length == 0) {
			return num;
		} else {
			return Integer.valueOf(arr[0]);
		}
	}

	public static String swap(String s, int i, int j) {
		String result ="";
		char[] chars = new char[s.length()];
		for(int k = 0; k<s.length();k++) {
			chars[k] = s.charAt(k);
		}
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
		for(int k = 0; k<chars.length;k++) {
			result += chars[k];
		}
		return result;
	}
}
