import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC910_Smallest_Range_II {
    public static void main(String[] args) {
        int[] nums = {1,3,6};
        int k = 3;
        System.out.println(smallestRangeII(nums, k));
    }

    public static int smallestRangeII(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int range = nums[nums.length - 1] - nums[0];
        for (int i = 0 ; i < nums.length -1; i++) {
            int high = Math.max(nums[i] + k , nums[nums.length - 1] - k);
            int low = Math.min(nums[0] + k, nums[i+1] -k);
            range = Math.min(range, high - low);
        }
        return range;
    }

//    public static int smallestRangeII(int[] nums, int k) {
//        List<Integer> temp = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        backtrack(nums, k, 0, temp, res);
//        int best = Integer.MAX_VALUE;
//        for (List<Integer> list : res) {
//            best = Math.min(best, range(list));
//        }
//        return best;
//    }

//    private static void backtrack(int[] nums, int k, int index, List<Integer> temp, List<List<Integer>> res) {
//        if(temp.size() == nums.length) {
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//
//        temp.add(nums[index]+k);
//        backtrack(nums, k, index+1, temp, res);
//        temp.remove(temp.size() - 1);
//
//        temp.add(nums[index] - k);
//        backtrack(nums, k, index +1, temp, res);
//        temp.remove(temp.size() - 1);
//
//    }
//
//    private static int range(List<Integer> list) {
//        int min = list.get(0);
//        int max = list.get(0);
//        for (Integer num:list) {
//            if(num > max) {
//                max = num;
//            }
//
//            if(num < min) {
//                min = num;
//            }
//        }
//        return max - min;
//    }
}
