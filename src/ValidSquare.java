package LeetCode;
import java.util.*;

import java.util.Arrays;

public class ValidSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1 = {1,1};
		int[] p2 = {0,1};
		int[] p3 = {1,2};
		int[] p4 = {0,0};
		System.out.print(validSquare(p1, p2, p3, p4));
	}

	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int d1 = disSq(p1,p2);
		int d2 = disSq(p1,p3);
		int d3 = disSq(p1,p4);
		int d4 = disSq(p2,p3);
		int d5 = disSq(p2,p4);
		int d6 = disSq(p3,p4);
		Set<Integer> dis = new HashSet<Integer>();
		dis.add(d1);
		dis.add(d2);
		dis.add(d3);
		dis.add(d4);
		dis.add(d5);
		dis.add(d6);
		return !dis.contains(0) && dis.size() == 2;
	}
	
	public static int disSq(int[] p1, int[] p2) {
		return ((p2[0]-p1[0])*(p2[0]-p1[0]) + (p2[1]-p1[1])*(p2[1]-p1[1]));
	}
}
