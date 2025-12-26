public class LC198_House_Robber {

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            money[i] = Math.max(money[i-2] + nums[i], money[i-1]);
        }
        return Math.max(money[money.length-1], money[money.length-2]);
    }
}
