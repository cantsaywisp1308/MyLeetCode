package trial;
import java.util.*;

public class SubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,1,1,1},{1,0,1,1},{1,0,1,1},{1,1,1,0}};
		int[] glasses = {1,0,1,0,1,0,0,0,1,1};
		System.out.print(alternateGlassesRandom(glasses));
	}
	
	public static boolean checkConnected(int[][] nums){
		boolean status = true;
		for(int i = 0 ; i < nums.length;i++) {
			int sum = 0;
			for(int j = 0; j < nums[i].length;j++) {
				sum+= nums[i][j];
			}
			if(sum != nums.length-1) {
				status = false;
				break;
			}
		}
		return status;
	}
	
	public static List<Integer> alternateGlassesRandom(int[] randomOrderGlasses) {
        int filled = 0;
        int empty = 1;
        int[] res = new int[randomOrderGlasses.length];
        //List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < randomOrderGlasses.length;i++) {
        	if(randomOrderGlasses[i] == 1) {
        		res[filled] = randomOrderGlasses[i];
        		filled+=2;
        	} else {
        		res[empty] = randomOrderGlasses[i];
        		empty+=2;
        	}
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < res.length;i++) {
        	list.add(res[i]);
        }
        return list;
    }

}
