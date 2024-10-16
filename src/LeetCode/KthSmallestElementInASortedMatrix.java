package LeetCode;

import java.util.Arrays;

public class KthSmallestElementInASortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		int k = 8;
		System.out.print(kthSmallest(matrix, k));
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		int[] arr = new int[matrix.length * matrix[0].length];
		int pos = 0;
		for(int i = 0 ; i < matrix.length;i++) {
			System.arraycopy(matrix[i],0, arr,pos,matrix[i].length);
			pos = matrix[i].length * (i+1);
		}
		Arrays.sort(arr);
		return arr[k-1];
	}

}
