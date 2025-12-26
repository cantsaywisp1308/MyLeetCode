public class LC494_Target_Sum {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.print(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return backtracking(nums, 0, 0, target);
    }

    public static int backtracking(int[] num, int index, int curSum, int target) {
        if(index == num.length) {
            if(curSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int left = backtracking(num, index+1, curSum + num[index], target);
        int right = backtracking(num, index + 1, curSum - num[index], target);
        return left + right;
    }
}
