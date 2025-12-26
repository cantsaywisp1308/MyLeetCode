import java.util.ArrayList;
import java.util.List;

public class LC2708_Maximum_Strength_Of_A_Group {

    public static void main(String[] args) {
        int[] nums = {3,-1,-5,2,5,-9};
        System.out.println(maxStrength(nums));
    }

    public static long maxStrength(int[] nums) {
        long posProd = 1, negProd = 1;
        int maxNeg = Integer.MIN_VALUE, negCount = 0;
        boolean hasPos = false, hasZero = false;

        for (int num: nums) {
            if(num > 0) {
                posProd *= num;
                hasPos = true;
            } else if (num < 0) {
                negProd *= num;
                maxNeg = Math.max(maxNeg, num);
                negCount ++;
            } else {
                hasZero = true;
            }
        }

        if(negCount == 0 && !hasPos) {
            return 0;
        }
        if(negCount %2 == 0) {
            return negProd * posProd;
        }
        if(negCount >= 3) {
            return (negProd / maxNeg) * posProd;
        }
        if (hasPos) {
            return posProd;
        }
        if(hasZero) {
            return 0;
        }
        return maxNeg;
    }

//    public static void backtracking(int[] nums, List<Integer> subset, List<List<Integer>> subsets, int index) {
//        if(index == nums.length) {
//            subsets.add(subset);
//            return;
//        }
//
//        backtracking(nums, new ArrayList<>(subset), subsets, index+1);
//        subset.add(nums[index]);
//        backtracking(nums, new ArrayList<>(subset), subsets, index+1);
//    }
//
//    private static long findProduct(List<Integer> list) {
//        long product = 1;
//        for(int i = 0 ; i < list.size(); i++) {
//            product *= list.get(i);
//        }
//        return product;
//    }
}
