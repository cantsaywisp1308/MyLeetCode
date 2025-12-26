package LeetCode;
import java.util.*;
public class RabbitsInForest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = {10,10,10};
		System.out.print(numRabbits(answers));
	}
	
	public static int numRabbits(int[] answers) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for(int answer: answers) {
			countMap.put(answer, countMap.getOrDefault(answer, 0)+1);
		}
		int total = 0;
		for(int color : countMap.keySet()) {
			int count = countMap.get(color);
			int groups = (int) Math.ceil((double)count/(color+1));
			total += groups*(color +1);
		}
		return total;
		
    }

}
