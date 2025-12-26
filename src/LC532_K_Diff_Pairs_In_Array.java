import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC532_K_Diff_Pairs_In_Array {

    public static void main(String[] args) {
        int[] nums = {1,3,1,5,4};
        int k = 0;
        System.out.println(findPairs(nums,k));
    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-1; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[j] - nums[i] == k) {
                        map.put(nums[i], nums[j]);
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
