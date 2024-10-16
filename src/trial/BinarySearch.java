package trial;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47};
        int key = 25;
        
        // Perform binary search
        int result = binarySearch(array, 0, array.length - 1, key);
        
        if (result != -1) {
            System.out.println("Element " + key + " found at index: " + result);
        } else {
            System.out.println("Element " + key + " not found in the array.");
        }
	}
	
	public static int binarySearch(int[] array, int left, int right, int key) {
		if(left <= right) {
			int mid = left + (right - left) /2;
			
			if(array[mid] == key) {
				return mid;
			}
			
			if(array[mid] < key) {
				return binarySearch(array, mid + 1, right, key);
			}
			
			return binarySearch(array, left, mid - 1, key);
		}
		return -1;
	}
	
	
}
