package HackerRank;
import java.util.*;

public class BirdNest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] forest = {0, 0, 50, 0, 0, 0, 0, 15, 0, 0,10, 10,15,0};
		int bird = 4;
		System.out.print(collectBranches(forest, bird));
	}	
	
	public static List<Integer> collectBranches(int[] forest, int birdPosition) {
		List<Integer> collectedPositions = new ArrayList<>();
        int totalBranches = 0;
        int n = forest.length;
        int rightPointer = birdPosition + 1;
        int leftPointer = birdPosition - 1;
        int direction = 1; //1 is right 0 is left

        while (totalBranches < 100) {
            // Collect from the right
            if (rightPointer < n && totalBranches < 100) {
                if (forest[rightPointer] > 0) {
                    totalBranches += forest[rightPointer];
                    collectedPositions.add(rightPointer);
                }
                rightPointer++;
            }

            // Collect from the left
            if (leftPointer >= 0 && totalBranches < 100) {
                if (forest[leftPointer] > 0) {
                    totalBranches += forest[leftPointer];
                    collectedPositions.add(leftPointer);
                }
                leftPointer--;
            }
        }

        return collectedPositions;
    }
	

}
