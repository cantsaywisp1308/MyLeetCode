package HackerRank;

import java.util.Arrays;

public class StringCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"apple", "ple", "le", "banana", "nana", "pple"};
        int result = countSuffixPairs(strings);
        System.out.println("Number of suffix pairs: " + result);
	}
	
	public static int countSuffixPairs(String[] strings) {
        // Sort the array lexicographically
        Arrays.sort(strings);

        int count = 0;
        int n = strings.length;

        // Compare each string with the subsequent strings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if strings[j] ends with strings[i] or vice versa
                if (strings[j].endsWith(strings[i]) || strings[i].endsWith(strings[j])) {
                    count++;
                }

                // Since the array is sorted, if strings[j] doesn't start with the same prefix
                // as strings[i], no need to continue with further comparisons.
//                if (!strings[j].startsWith(strings[i].substring(0, 1))) {
//                    break;
//                }
            }
        }

        return count;
    }

}
