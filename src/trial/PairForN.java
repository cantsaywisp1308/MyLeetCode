package trial;

import java.util.Arrays;

public class PairForN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 57;
		findThePair(n);
		int[] array = {3, 1, 6, 5, 2, 4};

        // Step 1: Negate all elements
        negateElements(array);

        // Step 2: Build a max heap from the negated elements
        buildMaxHeap(array);

        // Step 3: Negate all elements again to get the min heap
        negateElements(array);

        // Now, array represents a min heap
        System.out.println("Min Heap: " + Arrays.toString(array));
	}

	public static void findThePair(int n) {
		if(n%2 == 0) {
			int a = n/2;
			System.out.println("The pair of numbers are: " + a + " and " + a);
			System.out.print("Max production: " + a*a);
		} else {
			int a = n/2;
			System.out.println("The pair of numbers are: " + a + " and " + (a+1));
			System.out.print("Max production: " + a*(a+1));
		}
	}
	
	private static void negateElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = -array[i];
        }
    }

    // Method to build a max heap from the negated array
    private static void buildMaxHeap(int[] array) {
        int n = array.length;
        // Start from the last internal node and heapify each one
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(array, n, i);
        }
    }

    // Method to max-heapify a subtree rooted with node i which is an index in array[]
    private static void maxHeapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            maxHeapify(array, n, largest);
        }
    }
}
