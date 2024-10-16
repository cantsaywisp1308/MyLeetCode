package LeetCode;

import java.util.Arrays;
import java.util.*;

public class BoatsToSavePeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = {3,2,2,1};
		int limit = 3;
		System.out.print(numRescueBoats(people, limit));
	}

	public static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int res = 0;
		int left = 0;
		int right = people.length - 1;
		while(left <= right) {
			if(people[left] + people[right] <= limit) {
				left++;
				right--;
				res++;
			} else {
				right--;
				res++;
			}
		}
		return res;
	}

}
