public class LC81_Search_in_Rotated_Sorted_Array_II {

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
        System.out.println(3 | 2);
    }

    public static boolean search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
