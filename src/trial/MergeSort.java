package trial;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		System.out.println("Given array is");
        printArray(arr);

        mergeSort(arr);

        System.out.println("\nSorted array is");
        printArray(arr);
	}

	public static void mergeSort(int[] array) {
		// Find sizes of two subarrays to be merged
		if(array.length < 2) {
			return;
		}
		
		int mid = array.length / 2;
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];
		
		for(int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for(int i = mid; i < array.length; i++) {
			right[i - mid] = array[i];
		}
		
		mergeSort(left);
		mergeSort(right);
		
		merge(array, left, right);
	}
	
	public static void merge(int[] array, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}
		
		while(i < left.length) {
			array[k++] = left[i++];
		}
		
		while(j < right.length) {
			array[k++] = right[j++];
		}
	}
	
	public static void printArray(int[] arr) {
		int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
	}
	
}
