package HackerRank;
import java.util.*;

import java.util.Arrays;

public class ZigZagNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] numbers = {1,2,1,3,4};
		//print(solution(numbers));
		//String s = "aabba";
		//System.out.print(isPalindrome(s));
		//int n = 2;
		//System.out.print(shapeArea(n));
		//int[] statues = {6,2,3,8};
		//System.out.print(MakeArrayConsecutive2(statues));
		int[] sequence = {10, 1, 2, 3, 4, 5};
		System.out.print(almostIncreasingSequence(sequence));
	}
	
	public static int[] solution(int[] numbers) {
		int[] result = new int[numbers.length-2];
		for(int i = 0; i < result.length; i++) {
			if((numbers[i] > numbers[i+1] && numbers[i+1] < numbers[i+2]) 
					|| (numbers[i] < numbers[i+1] && numbers[i+1] > numbers[i+2])) {
				result[i] = 1;
			}
		}
		
		return result;
	}
	
	public static void print(int[] result) {
		for(int i = 0 ; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static boolean isPalindrome(String string) {
		boolean status = true;
		for(int i = 0 ; i < string.length()/2;i++) {
			if(string.charAt(i) != string.charAt(string.length()-i-1)) {
				status = false;
				break;
			}
		}
		return status;
	}
	
	public static int shapeArea(int n) {
		if (n==1) {
			return 1;
		} else {
			return 2*n-1 + 2*(n-1)*(n-1);
		}
	}
	
	public static int MakeArrayConsecutive2(int[] statues) {
		Arrays.sort(statues);
		int total = 0;
		for(int i = 0; i < statues.length-1;i++) {
			if(statues[i+1]-statues[i] != 1) {
				total += statues[i+1] - statues[i] - 1;
			}
		}
		return total;
	}
	
	public static boolean almostIncreasingSequence(int[] sequence) {
		int count = 0;
        
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] >= sequence[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                
                // Check if the element at i can be removed
                if (i > 0 && sequence[i - 1] >= sequence[i + 1]) {
                    // Check if the element at i + 1 can be removed
                    if (i < sequence.length - 2 && sequence[i] >= sequence[i + 2]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
	}
}
