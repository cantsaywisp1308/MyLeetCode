import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2150_Find_All_Lonely_Numbers_Array {

    public static void main(String[] args) {
        int[] nums = {10,6,5,8};
        System.out.println(findLonely(nums));
    }

    public static List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> adjacentMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i++) {
            if(!adjacentMap.containsKey(nums[i])) {
                adjacentMap.put(nums[i], 1);
                if(!adjacentMap.containsKey(nums[i]-1)) {
                    adjacentMap.put(nums[i]-1, 0);
                }
                if(!adjacentMap.containsKey(nums[i]+1)) {
                    adjacentMap.put(nums[i]+1, 0);
                }
            } else {
                adjacentMap.put(nums[i], adjacentMap.get(nums[i]) + 1);
                if(!adjacentMap.containsKey(nums[i]-1)) {
                    adjacentMap.put(nums[i]-1, 0);
                }
                if(!adjacentMap.containsKey(nums[i]+1)) {
                    adjacentMap.put(nums[i]+1, 0);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(adjacentMap.get(nums[i]) == 1 && adjacentMap.get(nums[i] + 1) == 0 && adjacentMap.get(nums[i] - 1) == 0 ) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
