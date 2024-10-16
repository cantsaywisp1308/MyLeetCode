package trial;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 12, 11, 13, 5, 6 };
		insertionSort(arr);
		printArray(arr);
	}

	public static void insertionSort(int[] array) {
		for(int i = 1 ; i < array.length; i++) {
			int key = array[i];
			int j = i -1;
			
			while(j >= 0 && array[j] > key) {
				array[j+1] = array[j];
				j = j - 1;
			}
			array[j+1] = key;
		}
	}
	
	public static void printArray(int[] arr) {
		int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
	}
}
