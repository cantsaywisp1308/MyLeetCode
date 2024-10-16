package ICPC;

import java.util.Arrays;

public class DPPermutations {
	
	//Most optimal

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
//		permute(arr,0,arr.length);
		permute(arr,0,arr.length-1);
	}
	
	public static void permute(int[] nums, int l, int r) {
		if(l == r) {
			printArray(nums);
		} else {
			for(int i = l; i<= r ;i++) {
				nums = swap(nums,l,i);
				permute(nums, l+1,r);
				nums = swap(nums, l, i);
			}
		}
	}

//	public static void permute(int[] arr, int l, int r) {
//		if( l ==r) {
//			printArray(arr);
//		} else {
//			for(int i = l; i<r;i++) {
//				arr = swap(arr,l,i);
//				permute(arr, l+1,r);
//				arr = swap(arr,l,i);
//			}
//		}
//	}
//	
	public static void printArray(int[] arr) {
		System.out.print("[");
		for(int i = 0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
	
	
	public static int[] swap(int[] arr, int l, int r) {
		int temp;
		temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		return arr;
	}
}
