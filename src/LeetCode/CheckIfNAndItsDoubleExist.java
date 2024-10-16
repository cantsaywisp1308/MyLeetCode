package LeetCode;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,1,14,11};
		System.out.print(checkIfExist(arr));
	}
	
	public static boolean checkIfExist(int[] arr) {
		Arrays.sort(arr);
		boolean status = false;
		for(int i = 0 ; i< arr.length-1;i++) {
			for(int j = i +1;j < arr.length;j++) {
				if(arr[i] == arr[j]*2 || arr[i]*2 == arr[j]) {
					status = true;
					break;
				}
			}
		}
		return status;
	}

}
