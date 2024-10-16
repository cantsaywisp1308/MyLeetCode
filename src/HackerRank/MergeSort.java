package HackerRank;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {1, 2, 9, 23, 87};
		int[] array2 = {5, 9, 10, 87, 222, 1000};
		int[] result = new int[array1.length + array2.length];
		merge(result, array1, array2);
		
	}

	public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: arrays with 0 or 1 elements are already sorted
        }
        int mid = array.length / 2;

        // Split the array into two halves
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Copy data to temp arrays
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }
	
	private static void merge(int[] result, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        // Merge the arrays while there are elements in both left and right
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        // Copy any remaining elements from the left array
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        // Copy any remaining elements from the right array
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        
        for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
    }
	
	private static void print(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ' ');
		}
	}
	
}
