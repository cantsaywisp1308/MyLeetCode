package HackerRank;
import java.util.*;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3, 6, 9, 1, 4, 8, 2, 7, 5, 0};
        
        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Perform bucket sort
        bucketSort(array);
        
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
	}

	public static void bucketSort(int[] array) {
        // Step 1: Create 10 buckets (one for each digit 0 to 9)
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>()); // Each bucket is a list
        }
        
        // Step 2: Distribute elements into corresponding buckets
        for (int num : array) {
            buckets.get(num).add(num); // Insert element into the bucket corresponding to its value
        }
        
        // Step 3: Concatenate buckets back into the original array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                array[index++] = num;
            }
        }
    }
}
