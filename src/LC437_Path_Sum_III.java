import com.sun.source.tree.Tree;

import java.util.*;

public class LC437_Path_Sum_III {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        Integer[] nums = {1000000000, 1000000000, null,
                294967296, null, 1000000000, null,
                1000000000, null, 1000000000};
        int target = 8;
        TreeNode root = insertLevelOrder(nums);
        System.out.print(pathSum(root, target));
    }

    public static TreeNode insertLevelOrder(Integer[] arr) {
        if(arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();
            //left child
            if(i < arr.length) {
                Integer leftVal = arr[i++];
                if(leftVal != null) {
                    node.left = new TreeNode(leftVal);
                    q.add(node.left);
                }
            }
            //right child
            if(i < arr.length) {
                Integer rightVal = arr[i++];
                if(rightVal != null) {
                    node.right = new TreeNode(rightVal);
                    q.add(node.right);
                }
            }
        }
        return root;
    }

    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1); // zero prefix sum seen once
        return dfs(root, 0L, targetSum, prefixCount);
    }

    private static int dfs(TreeNode node, long currSum, int target, Map<Long,Integer> prefixCount) {
        if (node == null) return 0;
        currSum += node.val; // use long to avoid overflow
        int res = prefixCount.getOrDefault(currSum - target, 0);
        // increment current prefix count
        prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);
        // explore children
        res += dfs(node.left, currSum, target, prefixCount);
        res += dfs(node.right, currSum, target, prefixCount);
        // backtrack
        int newCount = prefixCount.get(currSum) - 1;
        if (newCount == 0) prefixCount.remove(currSum);
        else prefixCount.put(currSum, newCount);
        return res;
    }

}
